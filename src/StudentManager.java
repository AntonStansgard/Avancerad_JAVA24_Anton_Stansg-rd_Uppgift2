import java.util.HashMap;
import java.util.Scanner;

public class StudentManager {
    private static StudentManager instance; // Singleton-instans
    private HashMap<String, Student> studentMap; // Lagrar studenter i minnet

    // Privat konstruktor för att förhindra direkt instansiering
    private StudentManager() {
        studentMap = new HashMap<>();
    }

    //Metod för att få den enda instansen av klassen
    public static StudentManager getInstance() {

        //Ifall det inte finns en instans så skapar vi en ny
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    // Metod för att lägga till en student
    public void addStudent() {
        //Instansierar en ny scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange studentens ID:");

        int StudentId = 0;

        while (StudentId == 0) {
            try {
                StudentId = scanner.nextInt(); // Försöker läsa ett heltal
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Fel: Ange endast siffror!");
                scanner.nextLine(); // Rensar felaktig inmatning
            }
        }
        // Gör om integer till sträng
        String id = Integer.toString(StudentId);

        // Kontrollera om ID redan finns
        if (studentMap.containsKey(id)) {
          System.out.println("En student med ID " + id + " finns redan!");
          return;
        }

        System.out.println("Ange studentens namn:");
        String name = "";

        while (true) {
            try {
                name = scanner.nextLine();

                // Försöker konvertera till ett heltal
                Integer.parseInt(name); // Detta kastar ett NumberFormatException om input inte är ett heltal

                // Om ingen exception kastas är input ett heltal
                System.out.println("Ogiltig inmatning, försök igen. Ett namn kan inte vara ett heltal.");
            } catch (NumberFormatException e) {
                // Om exception kastas är input inte ett heltal
                System.out.println("Du angav: " + name);
                break;
            }
        }


        System.out.println("Ange studentens betyg:");
        String grade = "";

        while (true) {
            try {
                grade = scanner.nextLine();

                // Försöker konvertera till ett heltal
                Integer.parseInt(grade); // Detta kastar ett NumberFormatException om input inte är ett heltal

                // Om ingen exception kastas är input ett heltal
                System.out.println("Ogiltig inmatning, försök igen. Betyget kan inte vara ett heltal.");
            } catch (NumberFormatException e) {
                // Om exception kastas är input inte ett heltal
                System.out.println("Du angav: " + grade);
                break;
            }
        }

        // Skapa och lägg till studenten id
        Student newStudent = new Student(id, name, grade);
        studentMap.put(id, newStudent);

            System.out.println("Studenten har lagts till: " + newStudent.getId() + ", " + newStudent.getName() + ", " + newStudent.getGrade());
        }

    // Metod för att söka efter en student med ID
    public void searchStudentById() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange studentens ID för att söka:");
        String id = scanner.nextLine();

        if (studentMap.containsKey(id)) {

            Student student = studentMap.get(id); // Hämta studenten från HashMap
            System.out.println("Student hittad: Namn: " + student.getName() + ", Betyg: " + student.getGrade());


        } else {
            System.out.println("Ingen student med ID: " + id + " hittades.");
        }
    }

    // Metod för att visa alla studenter
    public void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("Inga studenter finns i systemet.");
        } else {
            System.out.println("Lista över alla studenter:");
            for (Student student : studentMap.values()) {
                System.out.println("Id :" + student.getId() + ", Namn :" + student.getName() + ", Betyg :" + student.getGrade());

            }
        }
    }

    // Spara alla studenter till en fil
    public void saveToFile(String fileName) {
        StudentUtils.saveStudentsToFile(studentMap, fileName);
    }

    // Läs in studenter från en fil och lägg i minnet
    public void loadFromFile(String fileName) {
        studentMap = StudentUtils.loadStudentsFromFile(fileName);
    }

    // Läs in studenter från en fil
    public void readFromFile(String fileName) {
        studentMap = StudentUtils.readStudentsFromFile(fileName);
    }

}


