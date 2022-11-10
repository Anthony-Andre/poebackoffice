package poe.model.play;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalLong;

public class PlayCollectionPoe {

    static List<Poe> poeList;

    @BeforeAll
    static void initData() {
         poeList = List.of(
                new Poe(
                        "Java Fullstack",
                        LocalDate.of(2022, 10, 24),
                        LocalDate.of(2023, 1, 27),
                        PoeType.POEI),
                new Poe(
                        "Java Fullstack",
                        LocalDate.of(2022, 11, 2),
                        LocalDate.of(2023, 2, 3),
                        PoeType.POEC),
                new Poe(
                        "Consultant DevOps",
                        LocalDate.of(2022, 6, 13),
                        LocalDate.of(2022, 9, 16),
                        PoeType.POEC
                ),
                new Poe(
                        "Consultant Cyber Securité",
                        LocalDate.of(2021, 9, 13),
                        LocalDate.of(2021, 11, 16),
                        PoeType.POEI
                ),
                new Poe(
                        "Consultant SAP",
                        LocalDate.of(2022, 4, 13),
                        LocalDate.of(2022, 8, 16),
                        PoeType.POEI
                ),
                new Poe(
                        "Consultant BI",
                        LocalDate.of(2022, 9, 24),
                        LocalDate.of(2022, 11, 23),
                        PoeType.POEI
                )
        );
    }

    @Test
    void averagePoeDuration() {

        double averageDuration = poeList.stream()
                // .skip(1) // permet de passer un certains nombre d'éléments
                // .limit(3) // permet de sélectionner un certains nombre d'éléments
                .mapToLong(p -> ChronoUnit.DAYS.between(
                        p.getBeginDate(),
                        p.getEndDate()
                ))
               // .peek(d -> System.out.println("DEBUG: POE Duration "+ d)) // Permet de debuguer pendant le processus
                .average()
                .getAsDouble();
        System.out.println("Average duration of the POE : " + averageDuration + " days");

    }

    @Test
    void countPOEI(){
        long listPOEI = poeList.stream()
                .filter(p ->p.getPoeType() == PoeType.POEI)
                .count();
        System.out.println("Number of POEI : " + listPOEI);
    }

}

