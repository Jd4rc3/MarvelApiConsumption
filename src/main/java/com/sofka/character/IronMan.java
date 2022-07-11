package com.sofka.character;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.sofka.utilities.IOUtilities.browse;

@Slf4j
public class IronMan extends Hero{
    @Override
    public void introduceYourself() {
        log.info(this.getDescription() + " \uD83E\uDD16" + "\uD83E\uDDBE");
    }

    @Override
    public void showYourPower() {
        log.info("Throws a ton of money!\uD83D\uDCB0");
    }

    @Override
    public void takeSelfie() throws IOException {
        log.info("\uD83D\uDCB8 \uD83E\uDD11");
        browse(this.getThumbnail().getFullPath());
    }
}
