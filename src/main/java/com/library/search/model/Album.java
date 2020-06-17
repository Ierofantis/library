package com.library.search.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    private String name;
    private String title;
    private String artist;
    private String gender;
    private Integer price;
}
