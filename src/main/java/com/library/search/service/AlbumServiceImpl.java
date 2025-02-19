package com.library.search.service;

import com.library.search.model.Album;
import com.library.search.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public void AlbumCreate() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/albums.csv"))) {

            while ((line = br.readLine())!=null) {
                String[] data = line.split(",");
                int price = ConvertIntoNumeric(data[4]);

                Album album = new Album();
                album.setName(data[1]);
                album.setArtist(data[2]);
                album.setGender(data[3]);
                album.setPrice(price);

                albumRepository.save(album);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int ConvertIntoNumeric(String xVal)
    {
        try
        {
            return Integer.parseInt(xVal);
        }
        catch(Exception ex)
        {
            return 0;
        }
    }

    @Override
    public Album delete(int id) {
        return null;
    }

    @Override
    public List<Album> findAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Album> pagedResult = albumRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Album>();
        }
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

    @Override
    public Optional<List<Album>> findByArtistOrName(String artist,String name) {
        Optional<List<Album>> opt = albumRepository.findByArtistOrName(artist,name);
        return opt;
    }

    @Override
    public Streamable<Album> findByArtistContaining(String artist) {
        return null;
    }
}