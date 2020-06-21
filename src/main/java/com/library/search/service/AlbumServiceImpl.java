package com.library.search.service;

import com.library.search.model.Album;
import com.library.search.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album create(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album delete(int id) {
        return null;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album update(Album album) {
        return null;
    }

    @Override
    public Optional<Album> findById(int id){
        Optional<Album> opt = albumRepository.findById(id);
        return opt;
    }
}
