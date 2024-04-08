package org.example.task2;

public record Person(String name, int age, org.example.task2.Person.Position position) {
    enum Position {ENGINEER, DIRECTOR, MANAGER}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
