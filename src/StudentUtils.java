import java.io.*;
import java.util.HashMap;

public class StudentUtils {

    // Metod för att spara alla studenter till en fil
    public static void saveStudentsToFile(HashMap<String, Student> studentMap, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Student student : studentMap.values()) {
                // Spara varje student i filen på ett specifikt format
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Studenter har sparats till filen: " + fileName);
        } catch (IOException e) {
            System.out.println("Kunde inte spara till filen: " + e.getMessage());
        }
    }

    // Metod för att läsa in alla studenter från en fil
    public static HashMap<String, Student> loadStudentsFromFile(String fileName) {
        HashMap<String, Student> studentMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Splitta raden baserat på kommatecken
                String[] parts = line.split(",");

                //Ifall inputen är 3 delar(id,namn och betyg) kommer studenten läggas till i studentmap
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    String grade = parts[2];
                    studentMap.put(id, new Student(id, name, grade));
                }
            }
            System.out.println("Studenter har laddats från filen: " + fileName);
        } catch (IOException e) {
            System.out.println("Kunde inte läsa från filen: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Felaktigt format i filen: " + e.getMessage());
        }
        return studentMap;
    }

    public static HashMap<String, Student> readStudentsFromFile(String fileName) {
        HashMap<String, Student> studentMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Splitta raden baserat på kommatecken
                String[] parts = line.split(",");

                //Ifall inputen är 3 delar(id,namn och betyg) kommer studenten läggas till i studentmap
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    String grade = parts[2];
                    System.out.println(id + "," + name + "," + grade);
                }
            }
            System.out.println("Studenter har hämtats från filen: " + fileName);
        } catch (IOException e) {
            System.out.println("Kunde inte läsa från filen: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Felaktigt format i filen: " + e.getMessage());
        }
        return studentMap;
    }



}

