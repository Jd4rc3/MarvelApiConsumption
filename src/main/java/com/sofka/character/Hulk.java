package com.sofka.character;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.sofka.utilities.IOUtilities.browse;

@Slf4j
public class Hulk extends Hero{
    @Override
    public void introduceYourself() {
        log.info("Looks like " + this.getName() + " is angry \uD83D\uDE21 but anyway will tell us");
        log.info(this.getDescription());
    }

    @Override
    public void showYourPower() {
        log.info("👊💪\uD83D\uDE21 *Destroys something*");
    }

    @Override
    public void takeSelfie() throws IOException {
        log.info("Hulk screams and destroys 🤜📸");

        browse(getThumbnail().getFullPath());
    }
}
