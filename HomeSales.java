package lab9;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program demonstrates how exception handlers can be used to recover from
 * errors.
 */
public class HomeSales {

    public static void main(String[] args) {
        String filename = "C:\\Users\\pasip\\Desktop\\GoodSalesData.txt";
        int months = 0;

        //double oneMonth;
        double totalSales = 0.0;
        double averageSales;

        // Attempt to open the file by calling the open-file method.
        Scanner inputFile = openFile(filename);

        // If the openFile method returned null, then the file was not found. Get a new file name.
        Scanner kbd = new Scanner(System.in);
        while (inputFile == null) {
            System.out.println("File not found. Enter different file name");
            String input = kbd.next();
            inputFile = openFile(input);
        }
        kbd.close();

        // Process the contents of the file.
        ArrayList<Double> numberList = new ArrayList<Double>();
        while (inputFile.hasNext()) {
            //@TODO add error handling when processing the string input
          

              try{
              
              numberList.add(inputFile.nextDouble());
              months++;

            }catch(Exception e){
                
               inputFile.nextLine();
                System.out.println("Non- numeric data found in the file- the invalid record will be skipped"); 
                continue;
            }
             
        }

        inputFile.close();

        for (double i = 0; i < numberList.size(); i++) {
            totalSales += numberList.get((int) i);
        }

        // Calculate the average.
        averageSales = totalSales / months;

        // Display the results.
        System.out.printf("Number of months: %d\n"
                + "Total Sales: $%,.2f\n"
                + "Average Sales: $%,.2f",
                months, totalSales, averageSales);
        System.exit(0);
    }

    /**
     * The openFile method opens the specified file and returns a reference to a
     * Scanner object.
     *
     * @param filename The name of the file to open.
     * @return A Scanner reference, if the file exists Otherwise, null is
     * returned.
     */
    public static Scanner openFile(String filename) {
        Scanner scan;

        //@TODO: fix unhandled exception
        File file = new File(filename);
        try {
            scan = new Scanner(file);

        } catch (FileNotFoundException ex) {
            return null;
        }

        return scan;
    }
}
