package com.sofka.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.character.Hero;
import com.sofka.character.Thumbnail;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

@Slf4j
public class IOUtilities {
    private IOUtilities() {}

    public static void browse(String url) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("bash", "-c", "xdg-open \"" + url + "\" & disown");

        processBuilder.start();
    }

    public static Request requestBuilder(String id) {
        var configs = getConfigs();
        String timestamp = configs.get("timestamp");
        String publicKey = configs.get("publicKey");
        String hash = configs.get("hash");

        String url = "http://gateway.marvel.com/v1/public/characters/" + id + "?ts=" + timestamp
                + "&apikey=" + publicKey + "&hash=" + hash;

        return new Request.Builder().url(url).build();
    }

    public static Hero deserializeHero(String json, Hero hero) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;

        try {
            jsonNode = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            log.error("Something went wrong while deserializing the hero", e);
            return null;
        }

        JsonNode unwrappedHero = jsonNode.get("data").get("results").get(0);

        hero.setId(unwrappedHero.get("id").asLong());
        hero.setName(unwrappedHero.get("name").asText());
        hero.setDescription(unwrappedHero.get("description").asText());
        hero.setThumbnail(new Thumbnail(unwrappedHero.get("thumbnail").get("path").asText(),
                                        unwrappedHero.get("thumbnail").get("extension").asText()));

        return hero;
    }

    public static Map<String, String> getConfigs() {
        File file = new File("src/main/resources/application.properties");
        HashMap<String, String> configs = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                var splitLine = line.trim().split("=");
                var key = splitLine[0];
                var value = splitLine[1];
                configs.put(key, value);
            }

            return configs;
        } catch (IOException e) {
            log.error("File not found", e);
            System.exit(1);
        }

        return configs;
    }

    public static int menuMaker(String title, String[] options) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        while (true) {
            try {
                log.info(title);

                for (String option : options) {
                    log.info(String.format("%d. %s", counter++, option));
                }

                int selection = Integer.parseInt(scanner.next());

                if (selection > options.length || selection <= 0) {
                    throw new InputMismatchException();
                }

                return selection;

            } catch (InputMismatchException | NumberFormatException e) {
                counter = 1;

                if (e instanceof InputMismatchException) {
                    log.info(
                            "Invalid option please type a number between 1 and  " + options.length);
                } else {
                    log.info("Invalid option please try again");
                }
            }
        }
    }
}
