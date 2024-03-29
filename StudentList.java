import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    private static String[] getNames() throws Exception {
        BufferedReader bufferReader = new BufferedReader( new InputStreamReader ( new FileInputStream ( Constant.StudentList)));
        String studentList = bufferReader.readLine();
        String names[] = studentList.split(",");
        bufferReader.close();
        return names;
    }

    public static void main(String[] args) throws Exception{ 
        if(args[0].equals(Constant.ShowAll)) {
            // this will print the list of all students
            System.out.println(Constant.load);
            String names[] = getNames();
            for (String name : names) {
                System.out.println(name);
            }
            System.out.println(Constant.loaded);
        }else if (args[0].equals(Constant.ShowRandom)) {
            //this will print a random student
            System.out.println(Constant.load);
            String names[] = getNames();
            System.out.println(names[new Random().nextInt(names.length)]);
            System.out.println(Constant.loaded);
        }else if (args[0].contains(Constant.Add)) {
            //this will add a student in the list
            System.out.println(Constant.load);
            try {
                BufferedWriter bufferReader = new BufferedWriter(
                        new FileWriter(Constant.StudentList, true));
                String name = new String();
                for(String arg: args){
                    if(arg != args[0])
                    name = name +" "+ arg;
                }
                String formattedDate = new SimpleDateFormat(Constant.dateFormat).format(new Date());
                bufferReader.write("," +name);
                bufferReader.close();
                System.out.println("\nList last updated on " + formattedDate);
            } catch (Exception e) {

            }
            System.out.println(Constant.loaded);
        }else if (args[0].contains(Constant.Search)) {
            //search for a student in the list
            System.out.println(Constant.load);
            String names[] = getNames() ;
            String name = args[0].substring(1);
          
            for (int idx = 0; idx < names.length; idx++) {
                if (names[idx].equals(name)) {
                    System.out.println(Constant.Found);
                    break;
                }
            }
            System.out.println(Constant.loaded);
        }else if (args[0].contains(Constant.Count)) {
            // Count student quantity
            System.out.println(Constant.load);
            String[] names = getNames();
            System.out.println("Students found :  " + names.length );
            System.out.println(Constant.loaded);
        
        }else{
            // Print error massege 
            System.out.println(Constant.error);
        }
    }
}

