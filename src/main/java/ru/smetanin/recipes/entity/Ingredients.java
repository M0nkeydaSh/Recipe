package ru.smetanin.recipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="ingredients")
@Table(name="ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredients {

    @Id
    private String id;

    @Column(name="name")
    private String name;


}
