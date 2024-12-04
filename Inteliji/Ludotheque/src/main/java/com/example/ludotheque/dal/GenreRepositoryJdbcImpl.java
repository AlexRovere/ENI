package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Genre;
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
public class GenreRepositoryJdbcImpl implements IGenreRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public GenreRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public void add(Genre genre) {
        String sql = "insert into genres (libelle) VALUES (:libelle)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(genre));
    }

    @Override
    public List<Genre> getAll() {
        String sql = "select no_genre, libelle from genres";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public Optional<Genre> getById(int id) {
        String sql = "select no_genre, libelle from genres where no_genre= ?";
       Genre genre = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Genre g = new Genre();
           g.setNoGenre(rs.getInt("no_genre"));
           g.setLibelle(rs.getString("libelle"));
           return g;
        }, id);

        return Optional.ofNullable(genre);
    }

    @Override
    public void update(Genre genre) {
    String sql = "update genres SET libelle= :libelle" ;
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(genre));
    }

    @Override
    public void delete(int id) {
    String sql = "delete from genres where no_genre = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
    namedParameterJdbcTemplate.update(sql, params);
    }
}
