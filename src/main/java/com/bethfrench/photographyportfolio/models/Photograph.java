package com.bethfrench.photographyportfolio.models;

import com.bethfrench.photographyportfolio.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.nio.file.Path;
import java.util.UUID;


    @Entity
    public class Photograph {

        @Id
        private UUID uuid;

        @NotNull
        private String name;

        @NotNull
        private String mimeType;

        @NotNull
        public String color;

        @NotNull
        private int rating;

        public Photograph() {
            uuid = UUID.randomUUID();
        }

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Path path(StorageService storageService) {
            return storageService.load(uuid.toString());
        }

        public Resource loadAsResource(StorageService storageService) {
            return storageService.loadAsResource(uuid.toString());
        }

        public void update(StorageService storageService, MultipartFile newFile) {
            storageService.store(uuid.toString(), newFile);
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
