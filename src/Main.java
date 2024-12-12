import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\anton\\IdeaProjects\\Avancerad_JAVA24_Anton_Stansgard_Uppgift2\\students.txt";

        StudentManager manager = StudentManager.getInstance(); // Instansierar Singleton-instansen
        Scanner scanner = new Scanner(System.in);//Instansierar en ny scanner

        //Läser och laddar upp data från textfilen till hashmapen
        manager.loadFromFile(fileName);

        boolean running = true;

        while (running) {
           //Meny för användaren
            System.out.println("\nMeny:");
            System.out.println("1. Lägg till en student");
            System.out.println("2. Spara alla studenter till fil");
            System.out.println("3. Visa alla sparade studenter");
            System.out.println("4. Sök efter student med id ");
            System.out.println("5. Läs studenter från fil");
            System.out.println("6. Avsluta");
            System.out.print("Välj ett alternativ: ");

            int choice = 0;

            try {
                choice = scanner.nextInt(); // Försöker läsa ett heltal
            } catch (java.util.InputMismatchException e) {
                System.out.println("Fel: Ange endast siffror!");
                scanner.nextLine(); // Rensar felaktig inmatning
                continue; // Hoppa till nästa iteration av loopen
            }
            switch (choice) {
                case 1:
                   //Ifall första alternativet blir vald kommer metoden addstudent utföras
                    manager.addStudent();
                    break;

                case 2:
                    manager.saveToFile(fileName);
                    break;

                case 3:
                    //Metoden displayAllStudents kommer köras när alternativ 3 blir vald
                    manager.displayAllStudents();
                    break;

                case 4:
                    //Metoden searchStudentById kommer utföras ifall val 2 blir vald
                    manager.searchStudentById();
                    break;

                case 5:
                    manager.readFromFile(fileName);
                    break;

                case 6:
                   //Programmet avslutas
                    System.out.println("Avslutar programmet...");
                    running = false;
                    break;
            }

        }
        scanner.close();
    }
}