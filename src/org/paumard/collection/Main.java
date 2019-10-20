package org.paumard.collection;

import org.paumard.collection.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("A", 1);
        Person p2 = new Person("B", 2);
        Person p3 = new Person("C", 3);
        Person p4 = new Person("D", 4);
        Person p5 = new Person("E", 11);
        Person p6 = new Person("F", 6);

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3,p4,p5,p6));

        people.removeIf(person -> person.getAge() < 3);
        people.replaceAll(person -> new Person(person.getName().toLowerCase(), person.getAge()));
        people.sort(Comparator.comparing(person -> person.getAge()));
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(person -> System.out.println(person));
    }
}
