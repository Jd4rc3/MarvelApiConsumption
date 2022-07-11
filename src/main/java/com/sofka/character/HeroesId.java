package com.sofka.character;

public enum HeroesId {
    HULK("1009351", Hulk.class), THOR("1009664", Thor.class), IRONMAN("1009368",
                                                                      IronMan.class), SPIDERMAN(
            "1011054", Spiderman.class), CAPTAIN_AMERICA("1009220", CaptainAmerica.class);

    public final String id;

    public final Class<? extends Hero> heroClass;

    HeroesId(String s, Class<? extends Hero> heroClass) {
        this.id = s;

        this.heroClass = heroClass;
    }
}
