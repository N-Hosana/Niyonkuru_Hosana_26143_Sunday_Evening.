import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Exceptions {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // IOException example
        try (Scanner scanner = new Scanner(System.in)) {
            // IOException example
            try {
                System.out.println("\n(IOException example).");
                // Using Scanner to read the file
                File file = new File("nonexistentfile.txt");
                try (Scanner fileReader = new Scanner(file) // This will throw FileNotFoundException if the file doesn't exist
                        ) {
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\nIOException caught: " + e.getMessage());  // Handles both FileNotFoundException and general IOExceptions
            }
            // FileNotFoundException example
            try {
                System.out.println("\n(FileNotFoundException example).");
                @SuppressWarnings("unused")
                FileInputStream file = new FileInputStream("missingfile.txt");
            } catch (FileNotFoundException e) {
                System.out.println("\nFileNotFoundException caught: " + e.getMessage());
            }
            // EOFException example
            try {
                System.out.println("\n(EOFException example).");
                DataInputStream input = new DataInputStream(new FileInputStream("example.txt"));
                while (true) {
                    input.readByte(); // Intentionally reading beyond file content
                }
            } catch (EOFException e) {
                System.out.println("EOFException caught: Reached end of file.");
            } catch (IOException e) {
                System.out.println("\nIOException caught during EOF simulation: " + e.getMessage());
            }
            // SQLException example
            try {
                System.out.println("\n (SQLException example).");
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/nonexistentdb", "root", "password");
            } catch (SQLException e) {
                System.out.println("SQLException caught: " + e.getMessage());
            }
            // ClassNotFoundException example
            try {
                
                Class.forName("NonExistentClass");
            } catch (ClassNotFoundException e) {
                System.out.println("\nClassNotFoundException caught: " + e.getMessage());
            }
            // ArithmeticException example
            try {
                System.out.print("\nEnter a number to divide by zero: ");
                int num = scanner.nextInt();
                int result = num / 0; // This will throw ArithmeticException
                System.out.println("Result: " + result);
            }catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught: Division by zero is not allowed.");
            }catch (Exception e) {
                System.out.println("General exception caught: " + e.getMessage());
            }
            }
        }
            // Close the scanner after use    }
}
