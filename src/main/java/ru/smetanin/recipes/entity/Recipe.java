package ru.smetanin.recipes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity(name="recipe")
@Table(name="recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {

    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="time")
    private int time;

    @Column(name="count_of_portion")
    private int countOfPortion;

    @Column(name="date_publication")
    private LocalDateTime datePublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "USER_ID")
    private Users users;

}
