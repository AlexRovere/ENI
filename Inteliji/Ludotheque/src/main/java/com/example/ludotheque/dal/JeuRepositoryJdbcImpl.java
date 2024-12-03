package com.example.ludotheque.dal;

import com.example.ludotheque.bo.GenreJeu;
import com.example.ludotheque.bo.Jeu;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JeuRepositoryJdbcImpl implements IJeuRepository {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public JeuRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void add(Jeu jeu) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into jeu (titre, reference, description, tarif_journee, age_min, duree) VALUES (:titre, :reference, :description, :tarifJournee, :ageMin, :duree)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(jeu), keyHolder);
        List<GenreJeu> genres = jeu.getGenres();
        if(!genres.isEmpty()) {
            genres.forEach(e -> {
                MapSqlParameterSource params = new MapSqlParameterSource();
                params.addValue("no_jeu", keyHolder.getKeys().get("no_jeu"));
                params.addValue("no_genre", e.getNoGenre());
                String sql2 =  "insert into jeu_genre (no_jeu, no_genre) VALUES (:no_jeu, :no_genre)";
                namedParameterJdbcTemplate.update(sql2,params);
            });
        }
    }

    @Override
    public List<Jeu> getAll() {
        String sql = "select j.no_jeu, j.titre, j.reference, j.description, j.tarif_journee, j.age_min, j.duree, " +
                "g.no_genre, g.libelle from jeu j LEFT JOIN jeu_genre jg ON jg.no_jeu = j.no_jeu " +
                "LEFT JOIN genres g ON jg.no_genre = g.no_genre";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Jeu jeu = new Jeu();
            jeu.setNoJeu(rs.getInt("no_jeu"));
            jeu.setTitre(rs.getString("titre"));
            jeu.setReference(rs.getInt("reference"));
            jeu.setDescription(rs.getString("description"));
            jeu.setTarifJournee(rs.getInt("tarif_journee"));
            jeu.setAgeMin(rs.getInt("age_min"));
            jeu.setDuree(rs.getInt("duree"));


            // Gestion de l'association
            List<GenreJeu> genres = new ArrayList<>();

            if(rs.getInt(rs.getInt("no_genre") != null)) {

            }

            System.out.println(rs.getInt("no_genre"));
            GenreJeu genre = new GenreJeu();
            genre.setNoGenre(rs.getInt("no_genre"));
            genre.setLibelle(rs.getString("libelle"));
            genres.add(genre);

//            Jeu previousJeu = null;
//            if (previousJeu != null && previousJeu.getNoJeu() != jeu.getNoJeu()) {
//                jeu.setGenres(genres);
//            }
//            previousJeu = jeu;
    return jeu;
        });
    }

    @Override
    public Optional<Jeu> getById(int id) {
        String sql = "select j.no_jeu, j.titre, j.reference, j.description, j.tarif_journee, j.age_min, j.duree, " +
                "g.no_genre, g.libelle from jeu j LEFT JOIN jeu_genre jg ON jg.no_jeu = j.no_jeu " +
                "LEFT JOIN genres g ON jg.no_genre = g.no_genre where code_jeu=:id";
        Jeu jeu = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Jeu j = new Jeu();
            j.setNoJeu(rs.getInt("no_jeu"));
            j.setTitre(rs.getString("titre"));
            j.setReference(rs.getInt("reference"));
            j.setDescription(rs.getString("description"));
            j.setTarifJournee(rs.getInt("tarif_journee"));
            j.setAgeMin(rs.getInt("age_min"));
            j.setDuree(rs.getInt("duree"));

            // Gestion de l'association
            List<GenreJeu> genres = new ArrayList<>();

            do {
                GenreJeu genre = new GenreJeu();
                genre.setNoGenre(rs.getInt("no_genre"));
                genre.setLibelle(rs.getString("libelle"));
                genres.add(genre);
            } while (rs.next() && rs.getInt("no_jeu") == j.getNoJeu());

            j.setGenres(genres);

            return j;
        }, id);
        return Optional.ofNullable(jeu);
    }

    @Override
    public void update(Jeu jeu) {
        String sql = "update jeu SET titre = :titre, reference = :reference, description = :description, tarif_journee = :tarifJournee, age_min = :ageMin, duree = :duree" ;
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(jeu));
    }


    @Override
    public void delete(int id) {
        String sql = "delete from jeu where no_jeu = :no_jeu";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("no_jeu", id);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
