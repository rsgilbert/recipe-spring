package net.passioncloud.recipe.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // large object
    private String notes;

    @OneToOne
    private Recipe recipe;


}
