package com.sofka.character;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.sofka.utilities.IOUtilities.browse;

@Slf4j
public class Thor extends Hero{
    @Override
    public void showYourPower() {
        log.info("I am Thor, I can fly!\uD83D\uDEE9️. Look my hammer!\uD83D\uDD28");
    }

    @Override
    public void introduceYourself() {
        log.info(this.getDescription() + " \uD83C\uDF7A");
    }

    @Override
    public void takeSelfie() throws IOException {
        log.info("\uD83D\uDE0A ⚡");
        browse(this.getThumbnail().getFullPath());
    }
}
