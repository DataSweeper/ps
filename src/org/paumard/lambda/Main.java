package org.paumard.lambda;
public class Main {
    public static void main(String[] args) {
        Predicate<String> p1 = p -> p.length() < 20;
        Predicate<String> p2 = p -> p.length() > 4;
        System.out.println(p1.test("Hello"));

        Predicate<String> p3 = p1.and(p2);
        System.out.println(p3.test("hello world"));

        Predicate<String> p4 = Predicate.isEqueal("yes");
        System.out.println(p4.test("yes"));
        System.out.println(p4.test("no"));

        Predicate<Integer> p5 = Predicate.isEqueal(1);
        System.out.println(p5.test(1));
        System.out.println(p5.test(0));
    }
}
