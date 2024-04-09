import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find student by last name");
            System.out.println("3. Find and edit student by full name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            // Enter student list
            if (option == 1) {
                System.out.print("Enter the number of students: ");
                int numberOfStudents = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numberOfStudents; i++) {
                    System.out.print("Enter the first name of student " + (i + 1) + ": ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter the last name of student " + (i + 1) + ": ");
                    String lastName = scanner.nextLine();

                    students.add(new Student(firstName, lastName));
                }

                System.out.println("Students list entered successfully.");

            // Find student by their last name
            } else if (option == 2) {
                System.out.print("Enter the last name to search for: ");
                String searchLastName = scanner.nextLine();
                boolean found = false;
                for (Student student : students) {
                    if (student.getLastName().equalsIgnoreCase(searchLastName)) {
                        System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
                        found = true;
                    }// Student name is found
                }

                if (!found) {
                    System.out.println("Student not found");
                }// In case the student name can't be found

            // Find and edit student by full name
            } else if (option == 3) {
                System.out.print("Enter the full name of the student to edit: ");
                String searchFullName = scanner.nextLine();
                boolean found = false;

                for (Student student : students) {
                    String fullName = student.getFirstName() + " " + student.getLastName();
                    if (fullName.equalsIgnoreCase(searchFullName)) {
                        System.out.println("Student found: " + fullName);
                        System.out.print("Enter the new first name: ");
                        String updatedFirstName = scanner.nextLine();
                        System.out.print("Enter the new last name: ");
                        String updatedLastName = scanner.nextLine();
                        student.setFirstName(updatedFirstName);
                        student.setLastName(updatedLastName);
                        System.out.println("Student information updated successfully!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found");
                }// Student name is not found

            //Option to exit
            } else if (option == 4) {
                break; //Exit the program
            }
        }

        scanner.close();
    }
}

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}