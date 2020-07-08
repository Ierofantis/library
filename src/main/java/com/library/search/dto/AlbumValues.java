package com.library.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumValues {
    private String name;
    private String artist;
    private String gender;
    private Integer price;
}
