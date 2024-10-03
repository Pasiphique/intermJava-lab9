package lab9;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab9 {

    public static void main(String[] args) {

       
        try {

            File file = new File("C:\\Users\\pasip\\Desktop\\Rectangles.txt");
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String parts[] = line.split(", ");
                if (!parts[0].equals("Rectangle")) {
                    continue;
                }
                try {

                    String color = parts[1];
                    int length = Integer.parseInt(parts[2].strip());
                    int width = Integer.parseInt(parts[3].strip());

                    Square shape = new Square(width, length, color);
                    System.out.println(shape.toString());
                    
                    
                } catch (Exception e) {
                    System.out.println("invalid");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}