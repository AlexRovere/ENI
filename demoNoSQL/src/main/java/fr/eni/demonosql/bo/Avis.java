package fr.eni.demonosql.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "reviews")
public class Avis {
    @Id
    private String id;

    @Field(name = "pedagogical_note")
    private int notePedagogie;

    @Field(name = "pedagogical_commentary")
    private String commentairePedagogie;

    @Field(name = "course_note")
    private int noteCours;

    @Field(name = "course_commentary")
    private String commentaireCours;

}

