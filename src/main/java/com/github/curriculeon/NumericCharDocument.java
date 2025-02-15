package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class NumericCharDocument extends Document {
    public NumericCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if(!contentToBeWritten.matches(".*\\d+.*")) throw new IllegalArgumentException();
        super.write(contentToBeWritten);
    }

    private Boolean isNumeric(String s) {
        return null;
    }
}
