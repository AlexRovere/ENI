package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.bo.Location;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Primary
@Repository
public class LocationRepositoryJdbcImpl implements ILocationRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public LocationRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
    }

    @Override
    public List<Location> getAll() {
        String sql = "select l.no_location, l.date_debut_location, l.paye, l.prix_total, l.no_client, c.no_client, c.nom, c.prenom from locations l left join clients c on c.no_client = l.no_client";

        Map<Integer, Location> locationMap = new HashMap<>();

        List<Location> locations = namedParameterJdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {

            int locationId = rs.getInt("no_location");

            if (!locationMap.containsKey(locationId)) {
                Location l = new Location();
                l.setNoLocation(locationId);
                l.setDateDebutLocation(rs.getDate("date_debut_location").toLocalDate());
                l.setPaye(rs.getBoolean("paye"));
                l.setPrixTotal(rs.getFloat("prix_total"));

                Client c = new Client();
                c.setNoClient(rs.getInt("no_client"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));

                l.setClient(c);

                locationMap.put(locationId, l);
            }
            return null;

        });

        return new ArrayList<>(locationMap.values());
    }

    @Override
    public Optional<Location> getById(int id) {
        String sql = "select l.no_location, l.date_debut_location, l.paye, l.prix_total, l.no_client, c.no_client, c.nom, c.prenom from locations l left join clients c on c.no_client = l.no_client where no_location=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
       Location location = namedParameterJdbcTemplate.queryForObject(sql,params,  (ResultSet rs, int rowNum) -> {
           Location l = new Location();
           l.setNoLocation(rs.getInt("no_location"));
           l.setDateDebutLocation(rs.getDate("date_debut_location").toLocalDate());
           l.setPaye(rs.getBoolean("paye"));
           l.setPrixTotal(rs.getFloat("prix_total"));

           Client c = new Client();
           c.setNoClient(rs.getInt("no_client"));
           c.setNom(rs.getString("nom"));
           c.setPrenom(rs.getString("prenom"));

           l.setClient(c);

           return l;
       });

           return Optional.ofNullable(location);
    }

    @Override
    public void update(Location location) {
    String sql = "update locations SET date_debut_location= :dateDebutLocation, paye= :paye, prix_total= :prixTotal, no_client= :noClient where no_location= :noLocation" ;
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("dateDebutLocation", location.getDateDebutLocation());
        params.addValue("paye", location.getPaye());
        params.addValue("prixTotal", location.getPrixTotal());
        params.addValue("noClient", location.getClient().getNoClient());
        params.addValue("noLocation", location.getNoLocation());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(int id) {
    String sql = "delete from locations where no_location = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
    namedParameterJdbcTemplate.update(sql, params);
    }
}
