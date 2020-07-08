package com.library.search.service;

import com.library.search.model.Album;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlbumService {
    public void AlbumCreate();
    public Album delete(int id);
    public List<Album> findAll(Integer pageNo, Integer pageSize, String sortBy);
    public Album update(Album album);
    public Optional<Album> findById(int id);
    public Optional<List<Album>> findByArtistOrName(String artist,String name);
    Streamable<Album> findByArtistContaining(String artist);
}
