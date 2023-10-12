package se.lexicon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {
    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.print("Enter your input: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        int choice=0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter your input (a number): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
        scanner.nextLine(); // Consume the newline character
        return choice;
    }



}
