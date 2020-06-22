package com.library.search.model;

import lombok.*;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name;
    private String artist;
    private String gender;
    private Integer price;
}
