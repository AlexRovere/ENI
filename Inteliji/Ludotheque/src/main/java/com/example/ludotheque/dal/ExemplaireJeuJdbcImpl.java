package com.example.ludotheque.dal;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.bo.Location;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class ExemplaireJeuJdbcImpl implements IExemplaireJeuRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public ExemplaireJeuJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public void add(ExemplaireJeu exemplaireJeu) {
        String sql = "insert into exemplaire_jeu (codebarre, louable, no_jeu) VALUES (:codeBarre, :louable, :noJeu)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(exemplaireJeu));
    }

    @Override
    public List<ExemplaireJeu> getAll() {
        String sql = "select codebarre, louable, no_jeu from exemplaire_jeu";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ExemplaireJeu.class));
    }

    @Override
    public Optional<ExemplaireJeu> getById(int id) {
        String sql = "select no_exemplaire, codebarre, louable, no_jeu from exemplaire_jeu where no_exemplaire= ?";
       ExemplaireJeu exemplaireJeu = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            ExemplaireJeu e = new ExemplaireJeu();
           e.setNoExemplaire(rs.getInt("no_exemplaire"));
           e.setLouable(rs.getBoolean("louable"));
           e.setNoJeu(rs.getInt("no_jeu"));
           e.setCodeBarre(rs.getString("codebarre"));
           return e;
        }, id);

        return Optional.ofNullable(exemplaireJeu);
    }

    @Override
    public void update(ExemplaireJeu exemplaireJeu) {
        String sql = "update exemplaire_jeu SET codebarre= :codeBarre, louable = :louable where no_exemplaire=:noExemplaire";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codeBarre", exemplaireJeu.getCodeBarre());
        params.addValue("louable", exemplaireJeu.getLouable());
        params.addValue("noExemplaire", exemplaireJeu.getNoExemplaire());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from exemplaire_jeu where no_exemplaire = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void returnAllExemplaireToStoreFromLocation (Location location) {
        String sql = "update exemplaire_jeu  SET louable = true from locations l left join detail_location dl ON l.no_location = dl.no_location\n" +
                "LEFT JOIN jeu j ON j.no_jeu = dl.no_jeu LEFT JOIN exemplaire_jeu ej ON ej.no_jeu = j.no_jeu  where l.no_location = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", location.getNoLocation());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void giveExemplaireToClient (int noJeu) {
        String sql = "WITH cte AS (SELECT ej.no_exemplaire FROM exemplaire_jeu ej WHERE ej.louable = true AND ej.no_jeu = :id LIMIT 1) UPDATE exemplaire_jeu ej SET louable = false FROM cte WHERE ej.no_exemplaire = cte.no_exemplaire";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", noJeu);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void returnExemplaireToStore (int noJeu) {
        String sql = "WITH cte AS (SELECT ej.no_exemplaire FROM exemplaire_jeu ej WHERE ej.louable = false AND ej.no_jeu = :id LIMIT 1) UPDATE exemplaire_jeu ej SET louable = true FROM cte WHERE ej.no_exemplaire = cte.no_exemplaire";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", noJeu);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
