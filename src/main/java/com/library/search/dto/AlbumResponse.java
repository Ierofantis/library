package com.library.search.dto;

import com.library.search.model.Album;

import java.util.List;

public class AlbumResponse {

        private List<Album> data;

        public List<Album> getData() {
            return data;
        }

        public void setData(List<Album> data) {
            this.data = data;
        }

}
