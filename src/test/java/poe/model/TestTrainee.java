package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestTrainee {

    @Test
    void testDefaultConstructor() {
        Trainee trainee = new Trainee();
        System.out.println("Prénom du stagiraire lorsqu'il n'est pas défini : " + trainee.getFirstname());
        trainee.setFirstname("Anthony");
        System.out.println(trainee);
        System.out.println("Hashcode du stagiaire créée : " + trainee.hashCode());;
        System.out.println("Prénom du stagiaire : " + trainee.getFirstname());
    }

    @Test
    void severalInstances(){
        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        System.out.println(trainee1);
        System.out.println(trainee2);
    }

    @Test
    void testAllArgsConstructor(){
        LocalDate birthdate = LocalDate.of(1992,04,28);
        Trainee trainee = new Trainee("Anthony", "ANDRÉ", birthdate);
        System.out.println(trainee.getFirstname() + " " + trainee.getLastname() + " " + trainee.getBirthdate());
        assertEquals("Anthony", trainee.getFirstname(), "firstname");
        assertEquals("ANDRÉ", trainee.getLastname(), "lastname");
        assertEquals(birthdate, trainee.getBirthdate(), "birthdate");
    }

     @Test
    void testToString(){
        Trainee trainee = new Trainee("Jane", "Doe",  LocalDate.of(1992,04,28));
         System.out.println(trainee.toString());
     }

}