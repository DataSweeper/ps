package org.paumard.lambda;

import org.paumard.lambda.model.Person;

import java.util.function.Function;

public class MainComparator {

    public static void main(String... args) {
        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getFirstName();
        Function<Person, String> f3 = p -> p.getLastName();

        Comparator<Person> comparator = Comparator.comparing(p -> p.getAge());
        Comparator<Person> cmpFirst = Comparator.comparing(Person::getFirstName);

        Comparator<Person> cmpPredicate = Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getLastName).thenComparing(Person::getAge);

    }
}
