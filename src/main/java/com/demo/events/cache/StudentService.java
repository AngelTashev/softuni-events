package com.demo.events.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Cacheable("students")
    public List<Student> getAllStudents() {

        System.out.println("I'm doing complicated stuff to generate students!");

        return generateStudents();
    }

    @CachePut("students")
    public List<Student> updateAllStudents() {
        System.out.println("I'm updating all the students");
        return getAllStudents();
    }

    private List<Student> generateStudents() {
        Random random = new Random();
        Student pesho = new Student().setAge(20+random.nextInt(10)).setName("Pesho");
        Student anna = new Student().setAge(20+random.nextInt(10)).setName("Anna");

        return List.of(pesho, anna);
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    public void evictCache() {
        System.out.println("Evicting cache");
    }
}
