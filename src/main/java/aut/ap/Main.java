package aut.ap;


import aut.ap.framework.SingletonSessionFactory;
import aut.ap.model.User;
import aut.ap.service.UserService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.print("[L]ogin, [S]ign up: ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("s") || choice.equals("sign up")) {

            System.out.print("First Name: ");
            String firstname = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastname = scanner.nextLine();

            System.out.print("Age: ");
            int age;

            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age input! Please enter a number.");
                return;
            }

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            try {
                userService.persist(firstname, lastname, age, email, password);
                System.out.println("Registration successful!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else if (choice.equals("l") || choice.equals("login")) {

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            try {
                User user = UserService.login(email, password);
                if (user != null) {
                    System.out.println("Welcome, " + user.getFirstname() + " " + user.getLastname() + "!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Exit!");
        }

        SingletonSessionFactory.close();
    }
}