package com.sofka;

import com.sofka.character.Hero;
import com.sofka.character.HeroesId;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.sofka.utilities.IOUtilities.deserializeHero;
import static com.sofka.utilities.IOUtilities.requestBuilder;

@Slf4j
public class HttpClientWrapper {
    OkHttpClient client = new OkHttpClient();

    public Map<String, Hero> getHeroes() throws NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {

        Map<String, Hero> heroes = new HashMap<>();

        for (HeroesId hero : HeroesId.values()) {
            String json = getJson(hero.id);

            Hero internetHero = deserializeHero(json, hero.heroClass.getConstructor().newInstance());

            assert internetHero != null;
            heroes.put(internetHero.getName(), internetHero);
        }

        return heroes;
    }

    public String getJson(String id) {
        Response response = null;
        Request request = requestBuilder(id);

        try {
            response = client.newCall(request).execute();
        } catch (NullPointerException | IOException e) {
            log.error("We couldn't connect to the server", e);
            System.exit(1);
        }

        try {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            log.error("We couldn't read the response", e);
        }

        return null;
    }
}
