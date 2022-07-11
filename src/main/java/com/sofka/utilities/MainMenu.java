package com.sofka.utilities;

import com.sofka.HttpClientWrapper;
import com.sofka.character.Hero;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.sofka.utilities.IOUtilities.menuMaker;

@Slf4j
public class MainMenu {
    public void showHeroMenu(Hero selectedHero) throws IOException {

        Integer option = menuMaker("Ask your superhero for something",
                                   new String[]{"Show your power", "Introduce yourself",
                                           "Give me" + " a photo", "Exit"});

        switch (option) {
            case 1 -> selectedHero.showYourPower();
            case 2 -> selectedHero.introduceYourself();
            case 3 -> selectedHero.takeSelfie();
            case 4 -> System.exit(0);
            default -> log.error("Invalid option");
        }
    }

    public void show() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, IOException {
        HttpClientWrapper httpClient = new HttpClientWrapper();
        Map<String, Hero> heroes = httpClient.getHeroes();

        Integer option = menuMaker("Select a hero to know more about him",
                                   new String[]{"Hulk \uD83D\uDE21", "Spider Man 🕷",
                                           "Captain " + "America 🇺🇸", "Thor \uD83D\uDD28 ⚡",
                                           "Iron Man " + "\uD83E\uDDBE", "Exit"});

        switch (option) {
            case 1 -> showHeroMenu(heroes.get("Hulk"));
            case 2 -> showHeroMenu(heroes.get("Spider-Man (1602)"));
            case 3 -> showHeroMenu(heroes.get("Captain America"));
            case 4 -> showHeroMenu(heroes.get("Iron Man"));
            case 5 -> showHeroMenu(heroes.get("Thor"));
            case 6 -> System.exit(0);
            default -> log.error("invalid option");
        }
    show();
    }
}
