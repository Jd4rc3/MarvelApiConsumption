package com.sofka.character;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.sofka.utilities.IOUtilities.browse;

@Slf4j
public class CaptainAmerica extends Hero {
    @Override
    public void showYourPower() {
        log.info("🇺🇸🏊🏋🏃 *He tells us a joke and nobody understands it*");
    }

    @Override
    public void introduceYourself() {
        log.info(this.getDescription() + " 🇺🇸");
    }

    @Override
    public void takeSelfie() throws IOException {
        log.info("Ok here we go 😁🤹📸");

        browse(getThumbnail().getFullPath());
    }
}
