package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Mostafa
 */
public class Practice {

    public static class Student extends java.lang.Object{
        public String name;
        public int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

    }

    public static void main(String[] args) {
        Collection set = new HashSet();
        set.add(new Student("Ahmed",  25));
        set.add(new Student("Ahmed2",  25));
        set.add(new Student("Ahmed3",  25));

        System.out.println(set.contains(new Student("Ahmed3", 25)));


        List<Student> students = new ArrayList();

        students.add(new Student("Ahmed",  25));
        students.add(new Student("Ahmed2",  25));
        students.add(new Student("Ahmed3",  25));
        System.out.println(students.contains(new Student("Ahmed3", 25)));


        Map<String, Student> map = new HashMap<>();
        map.put("ahmed", new Student());



        // loop
        // loop over map
        // test queue // oven bread queue
        // test stack (google: ArrayDeque as map) java.util.Stack (pop, push) plates
        // look at linkedlist O(1) for remove others do shift for remove



    }
}
