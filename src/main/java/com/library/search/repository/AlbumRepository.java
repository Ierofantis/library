package com.library.search.repository;

import com.library.search.model.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
    Optional<List<Album>> findByArtistOrName(String artist,String name);
}
