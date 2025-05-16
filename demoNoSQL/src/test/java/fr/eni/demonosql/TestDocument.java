package fr.eni.demonosql;

import fr.eni.demonosql.bo.Avis;
import fr.eni.demonosql.dal.AvisRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestDocument {

    @Autowired
    AvisRepository avisRepository;

    @BeforeEach
    public void beforeEach() {
        avisRepository.deleteAll();
    }


    @Test
    void test01_save_avis_sans_commentaire_cours() {
        Avis avis = Avis
                .builder()
                .notePedagogie(4)
                .commentairePedagogie("commentaire sur la pédagogie")
                .noteCours(3)
                .build();
        Avis avisDB = avisRepository.save(avis);

        //Vérifier que l'identifiant n'est pas nul
        assertThat(avisDB.getId()).isNotNull();
        assertThat(avisDB.getId()).isNotBlank();

        //Vérifier que l'attribut commentaireCours est nul
        assertThat(avisDB.getCommentaireCours()).isNull();

        log.info(avisDB.toString());
    }

    @Test
    void test02_save_avis_tous_attributs() {
        Avis avis = Avis
                .builder()
                .notePedagogie(4)
                .commentairePedagogie("commentaire sur la pédagogie")
                .noteCours(3)
                .commentaireCours("commentaire sur le cours")
                .build();
        Avis avisDB = avisRepository.save(avis);

        //Vérifier que l'identifiant n'est pas nul
        assertThat(avisDB.getId()).isNotNull();
        assertThat(avisDB.getId()).isNotBlank();

        //Vérifier que tous les attributs sont remplis et non nuls
        assertThat(avisDB.getNotePedagogie()).isNotNull();
        assertThat(avisDB.getNotePedagogie()).isEqualTo(4);
        assertThat(avisDB.getCommentairePedagogie()).isNotNull();
        assertThat(avisDB.getNoteCours()).isNotNull();
        assertThat(avisDB.getNoteCours()).isEqualTo(3);
        assertThat(avisDB.getCommentaireCours()).isNotNull();

        log.info(avisDB.toString());
    }

    @Test
    void test03_findAll_avis() {
        Avis avis = Avis
                .builder()
                .notePedagogie(4)
                .commentairePedagogie("commentaire sur la pédagogie")
                .noteCours(3)
                .commentaireCours("commentaire sur le cours")
                .build();
        Avis avisDB = avisRepository.save(avis);

        //Act
        List<Avis> listeAvis = avisRepository.findAll();

        //Assert
        assertThat(listeAvis).isNotNull();
        assertThat(listeAvis).isNotEmpty();
        assertThat(listeAvis.size()).isEqualTo(1);
        log.info(listeAvis.toString());
    }

}
