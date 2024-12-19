import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Exceptions {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Use Scanner to get user input. The resource is auto-closed because of try-with-resources.
        try (Scanner scanner = new Scanner(System.in)) {
            
            // IOException example
            try {
                System.out.println("\n(IOException example).");
                // Attempt to open a file that does not exist
                File file = new File("nonexistentfile.txt");
                // Use Scanner to read from the file
                try (Scanner fileReader = new Scanner(file)) { // This will throw FileNotFoundException if the file doesn't exist
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine()); // Read and print each line in the file
                    }
                }
            } catch (FileNotFoundException e) {
                // Handle the case where the file does not exist
                System.out.println("\nIOException caught: " + e.getMessage());
            }

            // FileNotFoundException example
            try {
                System.out.println("\n(FileNotFoundException example).");
                // Attempt to open a non-existent file for reading
                @SuppressWarnings("unused")
                FileInputStream file = new FileInputStream("missingfile.txt"); // Throws FileNotFoundException
            } catch (FileNotFoundException e) {
                // Handle FileNotFoundException and print an error message
                System.out.println("\nFileNotFoundException caught: " + e.getMessage());
            }

            // EOFException example
            try {
                System.out.println("\n(EOFException example).");
                // Attempt to read beyond the end of a file
                DataInputStream input = new DataInputStream(new FileInputStream("example.txt"));
                while (true) {
                    input.readByte(); // This will throw EOFException when end of file is reached
                }
            } catch (EOFException e) {
                // Handle the EOFException when the end of the file is reached
                System.out.println("EOFException caught: Reached end of file.");
            } catch (IOException e) {
                // Handle any other IOExceptions that may occur
                System.out.println("\nIOException caught during EOF simulation: " + e.getMessage());
            }

            // SQLException example
            try {
                System.out.println("\n (SQLException example).");
                // Attempt to connect to a non-existent database
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/nonexistentdb", "root", "password");
            } catch (SQLException e) {
                // Handle the SQLException and print an error message
                System.out.println("SQLException caught: " + e.getMessage());
            }

            // ClassNotFoundException example
            try {
                // Attempt to load a non-existent class
                Class.forName("NonExistentClass"); // This will throw ClassNotFoundException
            } catch (ClassNotFoundException e) {
                // Handle ClassNotFoundException and print an error message
                System.out.println("\nClassNotFoundException caught: " + e.getMessage());
            }

            // ArithmeticException example
            try {
                System.out.print("\nEnter a number to divide by zero: ");
                int num = scanner.nextInt(); // Get input from the user
                int result = num / 0; // This will throw ArithmeticException (division by zero)
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handle ArithmeticException and print an error message
                System.out.println("ArithmeticException caught: Division by zero is not allowed.");
            } catch (Exception e) {
                // Handle any other general exceptions that may occur
                System.out.println("General exception caught: " + e.getMessage());
            }

        } // The scanner resource is automatically closed at the end of the try-with-resources block
    }
}
