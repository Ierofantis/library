package com.library.search.dto;

import java.util.List;

public class AlbumResponse {

        private List<AlbumValues> data;

        public List<AlbumValues> getData() {
            return data;
        }

        public void setData(List<AlbumValues> data) {
            this.data = data;
        }

}
