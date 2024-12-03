package com.example.ludotheque.dal;

import com.example.ludotheque.bo.GenreJeu;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class GenreJeuRepositoryJdbcImpl implements IGenreJeuRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public GenreJeuRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public void add(GenreJeu genreJeu) {
        String sql = "insert into genres (libelle) VALUES (:libelle)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(genreJeu));
    }

    @Override
    public List<GenreJeu> getAll() {
        String sql = "select no_genre, libelle from genres";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GenreJeu.class));
    }

    @Override
    public Optional<GenreJeu> getById(int id) {
        String sql = "select no_genre, libelle from genres where no_genre= ?";
       GenreJeu genreJeu = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            GenreJeu genre = new GenreJeu();
           genre.setNoGenre(rs.getInt("no_genre"));
           genre.setLibelle(rs.getString("libelle"));
           return genre;
        }, id);

        return Optional.ofNullable(genreJeu);
    }

    @Override
    public void update(GenreJeu genreJeu) {
    String sql = "update genres SET libelle= :libelle" ;
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(genreJeu));
    }

    @Override
    public void delete(int id) {
    String sql = "delete from genres where no_genre = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
    namedParameterJdbcTemplate.update(sql, params);
    }
}
