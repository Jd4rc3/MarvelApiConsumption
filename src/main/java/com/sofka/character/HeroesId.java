package com.sofka.character;

public enum HeroId {
    HULK("1009351"), THOR("1009664"), IRONMAN("1009368"), SPIDERMAN("1011054"), CAPTAIN_AMERICA(
            "1009220");

    final String id;

    HeroId(String s) {
        this.id = s;
    }
}
