package com.sofka.character;

import lombok.Data;

@Data
public class Thumbnail {
    private String path;
    private String extension;

    public Thumbnail(String path, String extension) {
        this.path      = path;
        this.extension = extension;
    }

    public String getFullPath() {
        return path + "." + extension;
    }
}
