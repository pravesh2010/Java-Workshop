package com.java8.Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    int id;
    String name;
    int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Main{
    public static void main(String[] args) {

        List<Person> people= createPeople();
        System.out.println(people.stream().collect(Collectors.
                toMap(person->person.getId(),person -> person)));

        System.out.println( people.stream()
                .collect(Collectors.groupingBy(Person::getAge)));

        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList()))));


    }

    private static List<Person> createPeople() {
        return Arrays.asList(
                new Person(1, "Ashish",30),
                new Person(2, "Sumit",32),
                new Person(3, "Sanjay",38),
                new Person(4, "Vijay",30),
                new Person(5, "Ajay",30),
                new Person(6, "Ravi",32)
        );
    }
}


