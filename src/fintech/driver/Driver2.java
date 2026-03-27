package fintech.driver;

import java.util.*;

/**
 * @author 12S24002 - Petra Naibaho
 */
public class Driver2 {

    static class Account {
        String name, username;
        double balance = 0.0;

        Account(String name, String username) {
            this.name = name;
            this.username = username;
        }

        void deposit(double amt) { balance += amt; }

        void withdraw(double amt) throws Exception {
            if (balance - amt < 0) throw new Exception();
            balance -= amt;
        }

        public String toString() {
            return username + "|" + name + "|" + String.format("%.1f", balance);
        }
    }

    public static void main(String[] _args) {

        Scanner source = new Scanner(System.in);
        Map<String, Account> accs = new LinkedHashMap<>();

        while (true) {
            String in = source.nextLine().trim();
            if (in.equals("---")) break;

            String[] p = in.split("#");

            if (p[0].equals("create-account")) {
                accs.put(p[2], new Account(p[1], p[2]));
            } 
            else if (p[0].equals("deposit")) {
                accs.get(p[1]).deposit(Double.parseDouble(p[2]));
            } 
            else if (p[0].equals("withdraw")) {
                try {
                    accs.get(p[1]).withdraw(Double.parseDouble(p[2]));
                } catch (Exception e) {}
            }
        }

        for (Account a : accs.values()) System.out.println(a);
        source.close();
    }
}