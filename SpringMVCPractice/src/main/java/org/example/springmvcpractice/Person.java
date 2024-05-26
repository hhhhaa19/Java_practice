package org.example.springmvcpractice;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-26
 * Time: 1:16
 */
public class Person {
    Integer id;
    String name;
    int age;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public Person(int age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
