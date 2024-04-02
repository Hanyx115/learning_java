import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            int num = scanner.nextInt();
            numbers.add(num);
        }

        Collections.sort(numbers);

        System.out.println("Numbers in increasing order:");
        for (int num : numbers) {
            System.out.println(num);
        }

        scanner.close();
    }
}

class RemoveStringFromFile {
    public void remove() {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String stringToRemove = "lol";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(stringToRemove, "");
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Occurrences of \"" + stringToRemove + "\" removed successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class FileStatistics {
    public void q(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileStatistics <filename>");
            return;
        }

        String filename = args[0];
        try {
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            reader.close();

            System.out.println("Character count: " + charCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Line count: " + lineCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

class FileReadWrite {
    public void qq() {
        File file = new File("Test.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File 'Test.txt' created successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error creating the file: " + e.getMessage());
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < 100; i++) {
                writer.print((int)(Math.random() * 1000) + 1);
                if (i < 99) {
                    writer.print(" ");
                }
            }
            System.out.println("100 integers written to 'Test.txt' successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
            return;
        }

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            Collections.sort(numbers);

            System.out.println("Integers in increasing order:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}
