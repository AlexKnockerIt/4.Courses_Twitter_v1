package lesson_File;

import java.io.*;
import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");


//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(file.getAbsolutePath());//Адрес файла



//        FileWriter writer = new FileWriter(file);
//        writer.append("asd\n");
//        writer.append("asd\n");
//        writer.append("asd\n");
//        writer.close();

        FileReader reader = new FileReader("text.txt");
        Scanner line = new Scanner(reader);
        while (line.hasNext()){
            System.out.println(line.nextLine());
        }

        reader.close();
    }
}
