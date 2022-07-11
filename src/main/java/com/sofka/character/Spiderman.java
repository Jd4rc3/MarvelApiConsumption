package com.sofka.character;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.sofka.utilities.IOUtilities.browse;

@Slf4j
public class Spiderman extends Hero {
    @Override
    public void showYourPower() {
        log.info("🕷🕸 *Got stuck at roof*");
    }

    @Override
    public void introduceYourself() {
        log.info("Looks like " + this.getName() + " is shy 😳");
    }

    @Override
    public void takeSelfie() throws IOException {
        log.info("Ok here we go 🕷📸");

        browse(getThumbnail().getFullPath());
    }
}
