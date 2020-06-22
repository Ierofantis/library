package com.library.search.service;

import com.library.search.model.Album;
import com.library.search.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
