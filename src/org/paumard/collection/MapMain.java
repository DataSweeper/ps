package org.paumard.collection;

import com.beust.jcommander.IValueValidator;
import org.paumard.collection.model.City;
import org.paumard.collection.model.Person;

import java.util.*;

public class MapMain {
    public static void main(String... args) {
        Person p1 = new Person("A", 1);
        Person p2 = new Person("B", 2);
        Person p3 = new Person("C", 3);
        Person p4 = new Person("D", 4);
        Person p5 = new Person("E", 11);
        Person p6 = new Person("F", 6);

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3,p4,p5,p6));

        City c1 = new City("Shanghai");
        City c2 = new City("New York");
        City c3 = new City("London");

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.putIfAbsent(c1, new ArrayList<>());
        map1.get(c1).add(p1);
        map1.computeIfAbsent(c2, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(c2, city -> new ArrayList<>()).add(p3);

        Map<City, List<Person>> map2 = new HashMap<>();
        map2.putIfAbsent(c1, new ArrayList<>());
        map2.get(c1).add(p4);
        map2.computeIfAbsent(c2, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(c2, city -> new ArrayList<>()).add(p6);

        map2.forEach(
                (key, value) -> {
                    map1.merge(
                            key, value,
                            ((people1, people2) -> {
                                people1.addAll(people2);
                                return people1;
                            })
                    );
                }
        );

        map1.forEach(
                (key, value) -> System.out.println(key + " -> " + value)
        );
    }
}
