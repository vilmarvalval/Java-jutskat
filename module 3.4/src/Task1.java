//Task 1: Read a CSV file from the network location
//There is a network file (https://users.metropolia.fi/~jarkkov/temploki.csv)
// where we have periodical temperature measurements at 10 minutes interval.
// Create an application which reads the file, reads the 'UlkoTalo' column,
// and calculates the average temperature for the 1st day of January 2023.

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        // first, create the url
        URL myUrl;
        String line;
        String[] columnNames = new String[0];
        ArrayList<Double> temps = new ArrayList<>();
        boolean header = true;
        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            // open the connection and get the input stream
            // it will automatically generate HTTP GET-request
            InputStream istream = myUrl.openStream();

            // jump to character streams
            InputStreamReader istreamreader = new InputStreamReader(istream);

            // and to buffered reader for efficiency
            BufferedReader reader = new BufferedReader(istreamreader);

            do {
                line = reader.readLine();
                if (line != null) {
                    if (header) {
                        // first row of the file contains names of columns
                        columnNames = line.split(";");
                        header = false;
                    } else {
                        // just print data lines with column names
                        String[] columns = line.split(";");

                        /*for (int i = 0; i < columnNames.length; i++)
                            System.out.print(columnNames[i] + ": " + columns[i] + ", ");
                        System.out.println();*/

                        StringBuilder response = new StringBuilder();
                        String date;
                        String[] format;
                        for (int i = 0; i < columnNames.length; i++) {
                            // split 'Aika' column into date and time
                            date = columns[0].split(" ")[0];
                            // check if date is 1st of January
                            if (columnNames[i].equals("UlkoTalo") && date.equals("01.01.2023")) {
                                response.append(columnNames[0]).append(": ").append(columns[0]).append(", ").append(columnNames[1]).append(": ").append(columns[1]);
                                System.out.println(response);

                                //replace that pesky comma with a full stop
                                format = columns[1].split(",");
                                System.out.println(format[0]+"."+format[1]);
                                temps.add(Double.parseDouble(format[0]+"."+format[1]));
                            }
                            if (date.equals("01.02.2023"))
                                break;
                        }
                    }
                }
            } while (line != null);
            System.out.println(temps);
            double avg=0;
            for (int i = 1; i < temps.size(); i++) {
                avg+=temps.get(i);
            }
            avg/=temps.size();
            System.out.printf("Average temperature in 1st of January: %.2f°C%n",avg);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}