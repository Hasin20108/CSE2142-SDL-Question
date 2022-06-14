import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        // Check arguments
        if (args[0].equals("a")) {
            //this will print the list of all students
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentList = bufferReader.readLine();
                String names[] = studentList.split(", ");
                for (String name : names) {  
                    System.out.println(name);
                }
                bufferReader.close();
            } catch (Exception e) {
            
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            //this will print a random student
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentList = bufferReader.readLine();
                String names[] = studentList.split(", ");
                System.out.println(names[new Random().nextInt(4)]);
                bufferReader.close();
            } catch (Exception e) {
            
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            //this will add a student in the list
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferReader = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String name = args[0].substring(1);
                String dateformat = "dd/mm/yyyy-hh:mm:ss a";
                String formattedDate = new SimpleDateFormat(dateformat).format(new Date());
                bufferReader.write(", " + name + "\nList last updated on " + formattedDate);
                bufferReader.close();
            } catch (Exception e) {
            
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            //search for a student in the list 
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String studentList = bufferReader.readLine();
                String names[] = studentList.split(",");
                String name = args[0].substring(1);
                for (int idx = 0; idx < names.length; idx++) {
                    if (names[idx].equals(name)) {
                        System.out.println("We found it!");
                        break;
                    }
                }
                bufferReader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferReader.readLine();
                int count = 1;
                for (Character c : line.toCharArray()) {
                    if (c == ',') {
                        count++;
                    }
                }
                System.out.println(count + " word(s) found " + line.length());
                bufferReader.close();
            } catch (Exception e) {
            
            }
            System.out.println("Data Loaded.");
        }else{
            System.out.println("Error: This argument is not recognised.");
            
        }
    }
}
