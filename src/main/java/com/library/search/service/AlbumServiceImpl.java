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
                //System.out.println(br.readLine());
                String[] data = line.split(",");
                System.out.println(data[1]);
                Album album = new Album();
                //album.setId(Integer.valueOf(data[0]));
               album.setName(data[1]);
//                album.setArtist(data[2]);
//                album.setGender(data[3]);
               // album.setPrice(Integer.valueOf(data[4]));

                albumRepository.save(album);
            }
//            return result;
        } catch (IOException e) {
            e.printStackTrace();
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
