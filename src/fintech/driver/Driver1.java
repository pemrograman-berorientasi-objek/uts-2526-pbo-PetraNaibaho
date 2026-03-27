package fintech.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S24002 - Petra Naibaho
 */
public class Driver1 {

    
    static class Account {
        private String username;
        private String name;
        private double balance;

        public Account(String name, String username) {
            this.name = name;
            this.username = username;
            this.balance = 0.0;
        }

        public String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return username + "|" + name + "|" + String.format("%.1f", balance);
        }
    }

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine().trim();

            
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");

            if (parts[0].equals("create-account")) {
                String name = parts[1];
                String username = parts[2];

                accounts.add(new Account(name, username));
            }
        }

       
        for (Account acc : accounts) {
            System.out.println(acc);
        }

        scanner.close();
    }
}

