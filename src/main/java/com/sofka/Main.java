package com.sofka;

import com.sofka.utilities.MainMenu;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
           new MainMenu().show();

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }
}