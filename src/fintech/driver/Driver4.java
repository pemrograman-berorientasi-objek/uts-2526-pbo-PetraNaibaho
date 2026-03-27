package fintech.driver;

import java.util.*;

/**
 * @author 12S24002 - Petra Naibaho
 */
public class Driver4 {

    static class A {
        String n, u;
        double b = 0;
        List<String> t = new ArrayList<>();

        A(String n, String u) { this.n = n; this.u = u; }

        public String toString() {
            return u + "|" + n + "|" + String.format("%.1f", b);
        }
    }

    public static void main(String[] _args) {

        Scanner source = new Scanner(System.in);
        Map<String, A> m = new LinkedHashMap<>();

        while (true) {
            String in = source.nextLine().trim();
            if (in.equals("---")) break;

            String[] p = in.split("#");

            if (p[0].equals("create-account")) {
                m.put(p[2], new A(p[1], p[2]));
            }

            else if (p[0].equals("deposit")) {
                A a = m.get(p[1]);
                double x = Double.parseDouble(p[2]);
                a.b += x;
                a.t.add("deposit|" + p[1] + "|" + x + "|" + p[3] + "|" + p[4]);
            }

            else if (p[0].equals("withdraw")) {
                A a = m.get(p[1]);
                double x = Double.parseDouble(p[2]);
                if (a.b >= x) {
                    a.b -= x;
                    a.t.add("withdraw|" + p[1] + "|" + x + "|" + p[3] + "|" + p[4]);
                }
            }

            else if (p[0].equals("transfer")) {
                A from = m.get(p[1]), to = m.get(p[2]);
                double x = Double.parseDouble(p[3]);
                if (from.b >= x) {
                    from.b -= x; 
                    to.b += x;
                    String tr = "transfer|" + p[1] + "|" + p[2] + "|" + x + "|" + p[4] + "|" + p[5];
                    from.t.add(tr);
                    to.t.add(tr);
                }
            }

            else if (p[0].equals("show-account")) {
                A a = m.get(p[1]);
                System.out.println(a);
                Collections.sort(a.t); // sort sederhana (string)
                for (String tr : a.t) System.out.println(tr);
            }
        }

        source.close();
    }
}