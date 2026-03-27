package fintech.driver;

import java.util.*;

/**
 * @author 12S24002 - Petra Naibaho
 */
public class Driver3 {

    static class A {
        String n, u;
        double b = 0;

        A(String n, String u) { this.n = n; this.u = u; }

        void d(double x) { b += x; }

        void w(double x) throws Exception { if (b < x) throw new Exception(); b -= x; }

        void t(double x, A y) throws Exception { if (b < x) throw new Exception(); b -= x; y.b += x; }

        public String toString() { return u + "|" + n + "|" + String.format("%.1f", b); }
    }

    public static void main(String[] _args) {
        Scanner s = new Scanner(System.in);
        Map<String, A> m = new LinkedHashMap<>();

        while (true) {
            String[] p = s.nextLine().trim().split("#");
            if (p[0].equals("---")) break;

            if (p[0].equals("create-account")) m.put(p[2], new A(p[1], p[2]));
            else if (p[0].equals("deposit")) m.get(p[1]).d(Double.parseDouble(p[2]));
            else if (p[0].equals("withdraw")) try { m.get(p[1]).w(Double.parseDouble(p[2])); } catch (Exception e) {}
            else if (p[0].equals("transfer")) try { m.get(p[1]).t(Double.parseDouble(p[3]), m.get(p[2])); } catch (Exception e) {}
        }

        for (A a : m.values()) System.out.println(a);
        s.close();
    }
}