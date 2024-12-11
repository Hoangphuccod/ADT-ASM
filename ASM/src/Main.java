import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Generate Random Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = Double.parseDouble(scanner.nextLine());
                    management.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter Student ID to Edit: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = Double.parseDouble(scanner.nextLine());
                    management.editStudent(id, newName, marks);
                    break;
                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    id = scanner.nextLine();
                    management.deleteStudent(id);
                    break;
                case 4:
                    System.out.print("Enter Student ID to Search: ");
                    id = scanner.nextLine();
                    management.searchStudent(id);
                    break;
                case 5:
                    management.displayStudents();
                    break;
                case 6:
                    System.out.print("Enter number of students to generate: ");
                    int count = Integer.parseInt(scanner.nextLine());
                    management.generateRandomStudents(count);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }
}