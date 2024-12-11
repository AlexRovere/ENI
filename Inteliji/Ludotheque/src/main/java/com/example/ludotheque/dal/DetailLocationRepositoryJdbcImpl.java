package com.example.ludotheque.dal;

import com.example.ludotheque.bo.DetailLocation;
import com.example.ludotheque.bo.Jeu;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;


@Primary
@Repository
public class DetailLocationRepositoryJdbcImpl implements IDetailLocationRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
    private final IExemplaireJeuRepository exemplaireJeuRepositroy;

    public DetailLocationRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, IExemplaireJeuRepository exemplaireJeuRepositroy) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.exemplaireJeuRepositroy = exemplaireJeuRepositroy;
    }


    @Override
    public void add(DetailLocation detailLocation) {
        String sql = "insert into detail_location (date_retour, tarif_location, no_location, no_jeu) VALUES (:dateRetour, :tarifLocation, :noLocation, :noJeu)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dateRetour", detailLocation.getDateRetour());
        params.addValue("tarifLocation", detailLocation.getTarifLocation());
        params.addValue("noLocation", detailLocation.getLocation().getNoLocation());
        params.addValue("noJeu", detailLocation.getJeu().getNoJeu());
        namedParameterJdbcTemplate.update(sql, params);
        exemplaireJeuRepositroy.giveExemplaireToClient(detailLocation.getJeu().getNoJeu());
    }

    @Override
    public List<DetailLocation> getAll() {
        String sql = "select * from detail_location";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DetailLocation.class));
    }

    @Override
    public Optional<DetailLocation> getById(int id) {
        String sql = "select dl.tarif_location, dl.no_jeu, dl.no_ligne, dl.date_retour from detail_location dl LEFT JOIN jeu j ON j.no_jeu = dl.no_jeu where dl.no_ligne =:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        DetailLocation ligne = namedParameterJdbcTemplate.queryForObject(sql,params,  (ResultSet rs, int rowNum) -> {
            DetailLocation l = new DetailLocation();
            l.setNoLigne(rs.getInt("no_ligne"));
            if(rs.getDate("date_retour") != null ) {
                l.setDateRetour(rs.getDate("date_retour").toLocalDate());

            }
            l.setTarifLocation(rs.getFloat("tarif_location"));

            Jeu j = new Jeu();
            j.setNoJeu(rs.getInt("no_jeu"));
            l.setJeu(j);
            return l;
        });

        return Optional.ofNullable(ligne);
    }

    @Override
    public void update(DetailLocation detailLocation) {
       Optional<DetailLocation> oldDetailLocationOpt = getById(detailLocation.getNoLigne());
       if(oldDetailLocationOpt.isPresent()) {
           DetailLocation oldDetailLocation = oldDetailLocationOpt.get();
               exemplaireJeuRepositroy.returnExemplaireToStore(oldDetailLocation.getJeu().getNoJeu());
       }
        String sql = "update detail_location SET date_retour = :dateRetour, tarif_location = :tarifLocation, no_jeu = :noJeu where no_ligne= :noLigne";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dateRetour", detailLocation.getDateRetour());
        params.addValue("tarifLocation", detailLocation.getTarifLocation());
        params.addValue("noJeu", detailLocation.getJeu().getNoJeu());
        params.addValue("noLigne", detailLocation.getNoLigne());
        namedParameterJdbcTemplate.update(sql, params);
        exemplaireJeuRepositroy.giveExemplaireToClient(detailLocation.getJeu().getNoJeu());
    }

    @Override
    public void delete(int id) {
        Optional<DetailLocation> detailLocationOptional = getById(id);
        if(detailLocationOptional.isPresent()) {
            DetailLocation detailLocation = detailLocationOptional.get();
            exemplaireJeuRepositroy.returnExemplaireToStore(detailLocation.getJeu().getNoJeu());
            String sql = "delete from detail_location where no_ligne = :id";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            namedParameterJdbcTemplate.update(sql, params);
        }
    }
}
