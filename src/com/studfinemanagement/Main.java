package com.studfinemanagement;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT FINE MANAGEMENT =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    loginUser();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void registerUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Role (admin/cashier/student): ");
        String role = sc.nextLine();

        Users user = new Users(id, username, password, role);
        Database.usersList.add(user);

        System.out.println("User Registered Successfully!");
    }

    static void loginUser() {
        sc.nextLine();
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        for (Users user : Database.usersList) {

            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {

                System.out.println("Login Successful!");

                switch (user.getRole().toLowerCase()) {

                    case "admin":
                        adminMenu();
                        break;

                    case "cashier":
                        cashierMenu();
                        break;

                    case "student":
                        studentMenu(user.getId());
                        break;
                }
                return;
            }
        }
        System.out.println("Invalid Credentials!");
    }
    
    static void adminMenu() {

        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. View All Payments");
            System.out.println("2. Add Payment");
            System.out.println("3. Delete Payment");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Payment p : Database.paymentList)
                        System.out.println(p);
                    break;

                case 2:
                    addPayment();
                    break;

                case 3:
                    deletePayment();
                    break;

                case 4:
                    return;
            }
        }
    }

    static void cashierMenu() {

        while (true) {
            System.out.println("\n--- CASHIER MENU ---");
            System.out.println("1. Add Payment");
            System.out.println("2. Delete Payment");
            System.out.println("3. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPayment();
                    break;

                case 2:
                    deletePayment();
                    break;

                case 3:
                    return;
            }
        }
    }

    static void studentMenu(int userId) {

        while (true) {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. View Transactions");
            System.out.println("2. View Balance");
            System.out.println("3. Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Payment p : Database.paymentList) {
                        if (p.getStudentId() == userId)
                            System.out.println(p);
                    }
                    break;
                case 2:
                    int totalPaid = 0;

                    for (Payment p : Database.paymentList) {
                        if (p.getStudentId() == userId) {
                            totalPaid += p.getAmount();
                        }
                    }

                    System.out.println("Total Fine Amount Paid: ₹" + totalPaid);
                    break;

                case 3:
                    return;
            }
        }
    }

    static void addPayment() {

        System.out.print("Payment ID: ");
        int pid = sc.nextInt();

        System.out.print("Student ID: ");
        int sid = sc.nextInt();

        System.out.print("Fine ID: ");
        int fid = sc.nextInt();

        System.out.print("Amount: ");
        int amt = sc.nextInt();

        Payment payment = new Payment(pid, sid, fid, amt, LocalDate.now());
        Database.paymentList.add(payment);

        System.out.println("Payment Added Successfully!");
    }

    static void deletePayment() {

        System.out.print("Enter Payment ID to delete: ");
        int pid = sc.nextInt();

        Database.paymentList.removeIf(p -> p.getPaymentId() == pid);

        System.out.println("Payment Deleted!");
    }
}