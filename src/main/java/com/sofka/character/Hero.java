package com.sofka.character;

import lombok.Data;

@Data
public abstract class Hero implements Greet, ShowYou {
    private Long id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    public abstract void showYourPower();
}
