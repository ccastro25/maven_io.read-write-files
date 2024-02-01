package com.github.curriculeon;




import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private  FileWriter fileWriter;
    private  File file;

    Scanner scanner ;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file,false);
        scanner = new Scanner(file);
    }

    @Override
    public void write(String contentToBeWritten) {

        try {
            this.fileWriter.write(contentToBeWritten);
            this.fileWriter.close();
        } catch (IOException e) {
           System.err.println(e.toString());
        }
    }

    @Override

    public void write(Integer lineNumber, String valueToBeWritten) {
        String result = "";

        int count=0;
        while (scanner.hasNextLine()) {

            String nl = scanner.nextLine();
            result += nl + "\n";
            if (count == lineNumber) {
                result = result.replace(nl, valueToBeWritten);
            }
            count++;
        }

        try
        {
            fileWriter = new FileWriter(this.file);
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String read(Integer lineNumber) {
       String result ="";
       int count =0;
        while( scanner.hasNextLine()){
            String nl = scanner.nextLine();
            result = nl;
            if(count ==lineNumber) break;
            count++;
        }
        return result;
    }

    @Override
    public String read()  {

        String result = "";

        while( scanner.hasNextLine()){
            String nl = scanner.nextLine();
            result += nl + "\n";
        }
        result= result.substring(0, result.length() -1 );
        return result;
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
        String result = "";


        while (scanner.hasNextLine()) {

            String nl = scanner.nextLine();
            result += nl + "\n";
        }
        result = result.replace(stringToReplace, replacementString);
        try
        {
            fileWriter = new FileWriter(this.file);
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void overWrite(String content)
    {
        try
        {
            fileWriter = new FileWriter(this.file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> toList() {
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public String toString() {
        String result = "";

        while( scanner.hasNextLine()){
            String nl = scanner.nextLine();
            result += nl ;
        }
        return file.toString()+"{"+result+"}";
    }
}
