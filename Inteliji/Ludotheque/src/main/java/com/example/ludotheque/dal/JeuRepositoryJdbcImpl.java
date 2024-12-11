package com.example.ludotheque.dal;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.bo.Genre;
import com.example.ludotheque.bo.Image;
import com.example.ludotheque.bo.Jeu;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.*;

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
    @Transactional
    public void add(Jeu jeu) {
        Integer idImage = jeu.getImage() != null ? jeu.getImage().getId() : null;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into jeu (titre, reference, description, tarif_journee, age_min, duree, id_image) VALUES (:titre, :reference, :description, :tarifJournee, :ageMin, :duree, :idImage)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("titre", jeu.getTitre());
        params.addValue("reference", jeu.getReference());
        params.addValue("description", jeu.getDescription());
        params.addValue("tarifJournee", jeu.getTarifJournee());
        params.addValue("ageMin", jeu.getAgeMin());
        params.addValue("duree", jeu.getDuree());
        params.addValue("idImage", idImage);


        namedParameterJdbcTemplate.update(sql, params, keyHolder);
        List<Genre> genres = jeu.getGenres();
        if (!genres.isEmpty()) {
            genres.forEach(e -> {
                MapSqlParameterSource paramsGenre = new MapSqlParameterSource();
                paramsGenre.addValue("no_jeu", keyHolder.getKeys().get("no_jeu"));
                paramsGenre.addValue("no_genre", e.getNoGenre());
                String sql2 = "insert into jeu_genre (no_jeu, no_genre) VALUES (:no_jeu, :no_genre)";
                namedParameterJdbcTemplate.update(sql2, paramsGenre);
            });
        }
    }

    @Override
    public List<Jeu> getAll() {
        String sql = "select j.no_jeu, j.titre, j.reference, j.description, j.tarif_journee, j.age_min, j.duree, " +
                "g.no_genre, g.libelle, ej.no_exemplaire, ej.codebarre, ej.louable, ej.no_jeu, i.id, i.data, i.file_name, i.mime_type from jeu j LEFT JOIN jeu_genre jg ON jg.no_jeu = j.no_jeu " +
                "LEFT JOIN genres g ON jg.no_genre = g.no_genre LEFT JOIN exemplaire_jeu ej ON ej.no_jeu = j.no_jeu LEFT JOIN image i ON j.id_image = i.id";

        Map<Integer, Jeu> jeuxMap = new HashMap<>();

        List<Jeu> jeux = namedParameterJdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {

            int jeuId = rs.getInt("no_jeu");

            if (!jeuxMap.containsKey(jeuId)) {
                Jeu j = new Jeu();
                j.setNoJeu(jeuId);
                j.setTitre(rs.getString("titre"));
                j.setReference(rs.getInt("reference"));
                j.setDescription(rs.getString("description"));
                j.setTarifJournee(rs.getFloat("tarif_journee"));
                j.setAgeMin(rs.getInt("age_min"));
                j.setDuree(rs.getInt("duree"));
                j.setGenres(new ArrayList<>());

                jeuxMap.put(jeuId, j);
            }

            int idImage = rs.getInt("id");

            if(!rs.wasNull()) {
                Image image = new Image();
                image.setId(idImage);
                image.setData(rs.getBytes("data"));
                image.setMimeType(rs.getString("mime_type"));
                image.setFileName(rs.getString("file_name"));
                jeuxMap.get(jeuId).setImage(image);
            }


            int noGenre = rs.getInt("no_genre");
            boolean genreExist = jeuxMap.get(jeuId).getGenres().stream()
                    .anyMatch(genre -> genre.getNoGenre() == noGenre);
            if(!rs.wasNull() && !genreExist) {
                Genre genre = new Genre();
                genre.setNoGenre(rs.getInt("no_genre"));
                genre.setLibelle(rs.getString("libelle"));
                jeuxMap.get(jeuId).setGenre(genre);
            }

            int noExemplaire = rs.getInt("no_exemplaire");
            boolean exists =  jeuxMap.get(jeuId).getExemplaires().stream()
                    .anyMatch(exemplaire -> exemplaire.getNoExemplaire() == noExemplaire);
            if(!rs.wasNull() && !exists) {
                ExemplaireJeu exemplaire = new ExemplaireJeu();
                exemplaire.setNoExemplaire(rs.getInt("no_exemplaire"));
                exemplaire.setNoJeu(rs.getInt("no_jeu"));
                exemplaire.setCodeBarre(rs.getString("codebarre"));
                exemplaire.setLouable(rs.getBoolean("louable"));

                jeuxMap.get(jeuId).setExemplaire(exemplaire);
            }
            return null;
        });
        return new ArrayList<>(jeuxMap.values());
    }

    @Override
    public Optional<Jeu> getById(int id) {

        String sql = "select j.no_jeu, j.titre, j.reference, j.description, j.tarif_journee, j.age_min, j.duree, " +
                "g.no_genre, g.libelle, ej.no_exemplaire, ej.codebarre, ej.louable, ej.no_jeu, i.id, i.data, i.file_name, i.mime_type  from jeu j LEFT JOIN jeu_genre jg ON jg.no_jeu = j.no_jeu " +
                "LEFT JOIN genres g ON jg.no_genre = g.no_genre  LEFT JOIN exemplaire_jeu ej ON ej.no_jeu = j.no_jeu LEFT JOIN image i ON j.id_image = i.id where j.no_jeu=:id" ;

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        Jeu jeu = namedParameterJdbcTemplate.queryForObject(sql, params, (ResultSet rs, int rowNum) -> {
                    Jeu j = new Jeu();
                    j.setNoJeu(rs.getInt("no_jeu"));
                    j.setTitre(rs.getString("titre"));
                    j.setReference(rs.getInt("reference"));
                    j.setDescription(rs.getString("description"));
                    j.setTarifJournee(rs.getFloat("tarif_journee"));
                    j.setAgeMin(rs.getInt("age_min"));
                    j.setDuree(rs.getInt("duree"));
                    j.setGenres(new ArrayList<>());

            int idImage = rs.getInt("id");

            if(!rs.wasNull()) {
                Image image = new Image();
                image.setId(idImage);
                image.setData(rs.getBytes("data"));
                image.setMimeType(rs.getString("mime_type"));
                image.setFileName(rs.getString("file_name"));
                j.setImage(image);
            }

                    do {
                        int noGenre = rs.getInt("no_genre");
                        boolean genreExist = j.getGenres().stream()
                                .anyMatch(genre -> genre.getNoGenre() == noGenre);
                        if(!rs.wasNull() && !genreExist) {
                            Genre genre = new Genre();
                            genre.setNoGenre(rs.getInt("no_genre"));
                            genre.setLibelle(rs.getString("libelle"));

                            j.setGenre(genre);
                        }

                        int noExemplaire = rs.getInt("no_exemplaire");

                        boolean exemplaireExist = j.getExemplaires().stream()
                                .anyMatch(exemplaire -> exemplaire.getNoExemplaire() == noExemplaire);
                        if(!rs.wasNull() && !exemplaireExist) {
                            ExemplaireJeu exemplaire = new ExemplaireJeu();
                            exemplaire.setNoExemplaire(rs.getInt("no_exemplaire"));
                            exemplaire.setNoJeu(rs.getInt("no_jeu"));
                            exemplaire.setCodeBarre(rs.getString("codebarre"));
                            exemplaire.setLouable(rs.getBoolean("louable"));

                            j.setExemplaire(exemplaire);
                        }
                    } while (rs.next());

                    return j;
                });

        return Optional.ofNullable(jeu);
    }

    @Override
    @Transactional
    public void update(Jeu jeu) {
        Integer idImage = jeu.getImage() != null ? jeu.getImage().getId() : null;
        String sql = "update jeu SET titre = :titre, reference = :reference, description = :description, tarif_journee = :tarifJournee, age_min = :ageMin, duree = :duree, id_image= :idImage where no_jeu= :noJeu";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("noJeu", jeu.getNoJeu());
        params.addValue("titre", jeu.getTitre());
        params.addValue("reference", jeu.getReference());
        params.addValue("description", jeu.getDescription());
        params.addValue("tarifJournee", jeu.getTarifJournee());
        params.addValue("ageMin", jeu.getAgeMin());
        params.addValue("duree", jeu.getDuree());
        params.addValue("idImage", idImage);
        namedParameterJdbcTemplate.update(sql,params);

        int jeuId = jeu.getNoJeu();

        MapSqlParameterSource paramsGenre = new MapSqlParameterSource();
        paramsGenre.addValue("no_jeu", jeuId);
        String sqlDelete = "delete from jeu_genre where no_jeu = :no_jeu";
        namedParameterJdbcTemplate.update(sqlDelete, paramsGenre);

        jeu.getGenres().forEach(el -> {
            MapSqlParameterSource paramsInsert = new MapSqlParameterSource();
            paramsInsert.addValue("no_jeu", jeuId);
            paramsInsert.addValue("no_genre", el.getNoGenre());
            String sql2 = "insert into jeu_genre (no_jeu, no_genre) VALUES  (:no_jeu, :no_genre)";
            namedParameterJdbcTemplate.update(sql2, paramsInsert);
        });
    }


    @Override
    public void delete(int id) {
        String sql = "delete from jeu where no_jeu = :no_jeu";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("no_jeu", id);
        namedParameterJdbcTemplate.update(sql, params);
    }


    @Override
    public List<Jeu> getAllWithFilters(String filter) {
        StringBuilder sql = new StringBuilder();
        sql.append("select j.no_jeu, j.titre, j.reference, j.description, j.tarif_journee, j.age_min, j.duree, " +
                "g.no_genre, g.libelle, ej.no_exemplaire, ej.codebarre, ej.louable, ej.no_jeu, i.id, i.data, i.file_name, i.mime_type from jeu j LEFT JOIN jeu_genre jg ON jg.no_jeu = j.no_jeu " +
                "LEFT JOIN genres g ON jg.no_genre = g.no_genre LEFT JOIN exemplaire_jeu ej ON ej.no_jeu = j.no_jeu LEFT JOIN image i ON j.id_image = i.id ");

        if(filter != null && !filter.isEmpty()) {
            sql.append("WHERE lower(titre || description) LIKE " + "'%").append(filter.toLowerCase()).append("%'");
        }

        Map<Integer, Jeu> jeuxMap = new HashMap<>();

        List<Jeu> jeux = namedParameterJdbcTemplate.query(sql.toString(), (ResultSet rs, int rowNum) -> {

            int jeuId = rs.getInt("no_jeu");

            if (!jeuxMap.containsKey(jeuId)) {
                Jeu j = new Jeu();
                j.setNoJeu(jeuId);
                j.setTitre(rs.getString("titre"));
                j.setReference(rs.getInt("reference"));
                j.setDescription(rs.getString("description"));
                j.setTarifJournee(rs.getFloat("tarif_journee"));
                j.setAgeMin(rs.getInt("age_min"));
                j.setDuree(rs.getInt("duree"));
                j.setGenres(new ArrayList<>());

                jeuxMap.put(jeuId, j);
            }

            int idImage = rs.getInt("id");

            if(!rs.wasNull()) {
                Image image = new Image();
                image.setId(idImage);
                image.setData(rs.getBytes("data"));
                image.setMimeType(rs.getString("mime_type"));
                image.setFileName(rs.getString("file_name"));
                jeuxMap.get(jeuId).setImage(image);
            }

            int noGenre = rs.getInt("no_genre");
            boolean genreExist = jeuxMap.get(jeuId).getGenres().stream()
                    .anyMatch(genre -> genre.getNoGenre() == noGenre);
            if(!rs.wasNull() && !genreExist) {
                Genre genre = new Genre();
                genre.setNoGenre(rs.getInt("no_genre"));
                genre.setLibelle(rs.getString("libelle"));
                jeuxMap.get(jeuId).setGenre(genre);
            }

            int noExemplaire = rs.getInt("no_exemplaire");
            boolean exists =  jeuxMap.get(jeuId).getExemplaires().stream()
                    .anyMatch(exemplaire -> exemplaire.getNoExemplaire() == noExemplaire);
            if(!rs.wasNull() && !exists) {
                ExemplaireJeu exemplaire = new ExemplaireJeu();
                exemplaire.setNoExemplaire(rs.getInt("no_exemplaire"));
                exemplaire.setNoJeu(rs.getInt("no_jeu"));
                exemplaire.setCodeBarre(rs.getString("codebarre"));
                exemplaire.setLouable(rs.getBoolean("louable"));

                jeuxMap.get(jeuId).setExemplaire(exemplaire);
            }
            return null;
        });
        return new ArrayList<>(jeuxMap.values());
    }
}
