package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
       if (contentToBeWritten.matches(".*[a-zA-Z\\d].*")) throw new IllegalArgumentException();
        super.write(contentToBeWritten);
    }

    private Boolean isSpecialCharacters(String s) {
        return null;
    }
}
