package fr.eni.springApi.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, length = 50)
    private String name;

    @NonNull
    @Column(nullable = false, length = 50)
    private String firstname;

    @Column(length = 10, unique = true)
    private String phone;

    @Transient
    Integer age;

    @OneToOne(cascade = CascadeType.PERSIST)
    Adress adress;

}
