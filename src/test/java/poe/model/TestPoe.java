package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestPoe {

    @Test
    void testToString() {
        Poe poe = new Poe();
        poe.setTitle("POEI");
        LocalDate beginDate = LocalDate.of(2022, 10, 24);
        LocalDate endDate = LocalDate.of(2023, 1, 27);
        poe.setBeginDate(beginDate);
        poe.setEndDate(endDate);
        poe.setPoeType(PoeType.POEI);
        assertEquals("POE : POEI, 2022-10-24 -> 2023-01-27, POEI, Liste des stagiaires : []", poe.toString(), "Poe toString");
    }

    @Test
    void defaultConstructor() {
        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getPoeType());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
        assertTrue(poe.getTrainees().isEmpty(), "trainees is an empty collection");
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2022, 10, 24);
        LocalDate endDate = LocalDate.of(2023, 1, 27);
        List<Trainee> trainees = new ArrayList<>();
        Poe poe = new Poe("POEI", beginDate, endDate, PoeType.POEI, trainees);
        assertSame(trainees, poe.getTrainees(), "trainees");
        assertEquals("POE : POEI, 2022-10-24 -> 2023-01-27, POEI, Liste des stagiaires : " + poe.getTrainees(), poe.toString(), "Poe toString");
    }

    @Test
    void testAddTrainee() {
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee = Trainee.builder()
                .firstname("Ed")
                .lastname("Chebest")
                .birthdate(LocalDate.of(1922, 4, 28))
                .build();
        poe.addTrainee(trainee);
        System.out.println(poe);
        // assertSame(trainee, poe.getTrainees().get(0), "trainee add to poe");
        assertTrue(poe.getTrainees().contains(trainee), "trainee "+ trainee.getFirstname() + " " + trainee.getLastname() + " is in POE");
    }

    @Test
    void testAddTraineesCollection() {
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee1 = Trainee.builder()
                .firstname("Ed")
                .lastname("Chebest")
                .birthdate(LocalDate.of(1922, 4, 28))
                .build();
        Trainee trainee2 = Trainee.builder()
                .firstname("Joël")
                .lastname("Reblochon")
                .birthdate(LocalDate.of(1954, 5, 22))
                .build();
        Set<Trainee> trainees = Set.of(trainee1, trainee2);
        poe.addAllTrainees(trainees);
        System.out.println(poe);
//        assertTrue(poe.getTrainees().containsAll(trainees));
        assertAll(trainees.stream()
                .map(trainee -> () -> assertTrue(poe.getTrainees().contains(trainee), "trainee " + trainee.getFirstname() + " " + trainee.getLastname())));
    }

    @Test
    void testAddTraineesVarArgs() {
        //given
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();
        Trainee trainee1 = Trainee.builder()
                .firstname("Ed")
                .lastname("Chebest")
                .birthdate(LocalDate.of(1922, 4, 28))
                .build();
        Trainee trainee2 = Trainee.builder()
                .firstname("Joël")
                .lastname("Reblochon")
                .birthdate(LocalDate.of(1954, 5, 22))
                .build();
        //when
        poe.addAllTrainees(trainee1, trainee2);
        //then
        assertAll(Stream.of(trainee1, trainee2)
                .map(trainee -> () -> assertTrue(poe.getTrainees().contains(trainee), "trainee " + trainee.getFirstname() + " " + trainee.getLastname())));
    }


}

