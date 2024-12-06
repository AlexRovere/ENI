package com.example.ludotheque.dal;

import com.example.ludotheque.bo.*;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Primary
@Repository
public class LocationRepositoryJdbcImpl implements ILocationRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
    private IExemplaireJeuRepository exemplaireJeuRepository;


    public LocationRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, IExemplaireJeuRepository exemplaireJeuRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.exemplaireJeuRepository = exemplaireJeuRepository;
    }


    @Override
    public void add(Location location) {
        String sql = "insert into locations (date_debut_location, paye, prix_total, no_client) VALUES (:dateDebutLocation, :paye, :prixTotal, :noClient)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dateDebutLocation", location.getDateDebutLocation());
        params.addValue("paye", location.getPaye());
        params.addValue("prixTotal", location.getPrixTotal());
        params.addValue("noClient", location.getClient().getNoClient());
        namedParameterJdbcTemplate.update(sql, params);
        if (location.getPaye()) {
            exemplaireJeuRepository.returnAllExemplaireToStoreFromLocation(location);
        }
    }

    @Override
    public List<Location> getAll() {
        String sql = "select l.no_location, l.date_debut_location, l.paye, l.prix_total, l.no_client, c.no_client, c.nom, c.prenom, dl.tarif_location, dl.no_location, dl.no_jeu, dl.no_ligne, dl.date_retour, j.titre, j.reference, j.tarif_journee from locations l" +
                " LEFT JOIN detail_location dl on dl.no_location = l.no_location LEFT JOIN jeu j ON j.no_jeu = dl.no_jeu LEFT JOIN clients c ON c.no_client = l.no_client";
        Map<Integer, Location> locationMap = new HashMap<>();

        List<Location> locations = namedParameterJdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {

            int locationId = rs.getInt("no_location");
            Location l = locationMap.get(locationId);

            if (l == null) {
                l = new Location();
                l.setNoLocation(locationId);
                l.setDateDebutLocation(rs.getDate("date_debut_location").toLocalDate());
                l.setPaye(rs.getBoolean("paye"));
                l.setPrixTotal(rs.getFloat("prix_total"));

                Client c = new Client();
                c.setNoClient(rs.getInt("no_client"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));

                l.setClient(c);

            }
            int noLigne = rs.getInt("no_ligne");
            boolean ligneExist = l.getDetails().stream()
                    .anyMatch(ligne -> ligne.getNoLigne() == noLigne);
            if (!rs.wasNull() && !ligneExist) {
                Jeu j = new Jeu();
                j.setNoJeu(rs.getInt("no_jeu"));
                j.setTitre(rs.getString("titre"));
                j.setReference(rs.getInt("reference"));
                j.setTarifJournee(rs.getInt("tarif_journee"));

                DetailLocation ligne = new DetailLocation();
                ligne.setNoLigne(rs.getInt("no_ligne"));
                if (rs.getDate("date_retour") != null) {
                    ligne.setDateRetour(rs.getDate("date_retour").toLocalDate());

                }
                ligne.setTarifLocation(rs.getFloat("tarif_location"));
                ligne.setJeu(j);
                ligne.setLocation(l);
                l.setDetail(ligne);
            }

            locationMap.put(locationId, l);
            return null;
        });
        return new ArrayList<>(locationMap.values());
    }

    @Override
    public Optional<Location> getById(int id) {
        String sql = "select l.no_location, l.date_debut_location, l.paye, l.prix_total, l.no_client, c.no_client, c.nom, c.prenom,\n" +
                "dl.tarif_location, dl.no_location, dl.no_jeu, dl.no_ligne, dl.date_retour, j.titre, j.reference, j.tarif_journee\n" +
                "from locations l LEFT JOIN detail_location dl on dl.no_location = l.no_location\n" +
                "LEFT JOIN jeu j ON j.no_jeu = dl.no_jeu LEFT JOIN clients c ON c.no_client = l.no_client where l.no_location =:id\n";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        Location location = namedParameterJdbcTemplate.queryForObject(sql, params, (ResultSet rs, int rowNum) -> {
            Location l = new Location();
            l.setNoLocation(rs.getInt("no_location"));
            if (rs.getDate("date_debut_location") != null) {
                l.setDateDebutLocation(rs.getDate("date_debut_location").toLocalDate());
            }
            l.setPaye(rs.getBoolean("paye"));
            l.setPrixTotal(rs.getFloat("prix_total"));

            Client c = new Client();
            c.setNoClient(rs.getInt("no_client"));
            c.setNom(rs.getString("nom"));
            c.setPrenom(rs.getString("prenom"));

            l.setClient(c);

            do {
                int noLigne = rs.getInt("no_ligne");
                boolean ligneExist = l.getDetails().stream()
                        .anyMatch(ligne -> ligne.getNoLigne() == noLigne);
                if (!rs.wasNull() && !ligneExist) {
                    Jeu j = new Jeu();
                    j.setNoJeu(rs.getInt("no_jeu"));
                    j.setTitre(rs.getString("titre"));
                    j.setReference(rs.getInt("reference"));
                    j.setTarifJournee(rs.getInt("tarif_journee"));

                    DetailLocation ligne = new DetailLocation();
                    ligne.setNoLigne(rs.getInt("no_ligne"));
                    if (rs.getDate("date_retour") != null) {
                        ligne.setDateRetour(rs.getDate("date_retour").toLocalDate());

                    }
                    ligne.setTarifLocation(rs.getFloat("tarif_location"));
                    ligne.setJeu(j);
                    ligne.setLocation(l);
                    l.setDetail(ligne);
                }
            } while (rs.next());

            return l;
        });

        return Optional.ofNullable(location);
    }

    @Override
    public void update(Location location) {
        String sql = "update locations SET date_debut_location= :dateDebutLocation, paye= :paye, prix_total= :prixTotal, no_client= :noClient where no_location= :noLocation";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dateDebutLocation", location.getDateDebutLocation());
        params.addValue("paye", location.getPaye());
        params.addValue("prixTotal", location.getPrixTotal());
        params.addValue("noClient", location.getClient().getNoClient());
        params.addValue("noLocation", location.getNoLocation());
        namedParameterJdbcTemplate.update(sql, params);
        if (location.getPaye()) {
            exemplaireJeuRepository.returnAllExemplaireToStoreFromLocation(location);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Location> optionalLocation = this.getById(id);
        if (optionalLocation.isPresent()) {
            exemplaireJeuRepository.returnAllExemplaireToStoreFromLocation(optionalLocation.get());
            String sql = "delete from locations where no_location = :id";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            namedParameterJdbcTemplate.update(sql, params);
        }
    }


}
