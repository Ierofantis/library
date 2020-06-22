package com.library.search.service;

import com.library.search.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlbumService {
    public void AlbumCreate();
    public Album delete(int id);
    public List<Album> findAll();
    public Album update(Album album);
    public Optional<Album> findById(int id);
}
