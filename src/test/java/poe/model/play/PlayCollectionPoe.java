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
                Poe.builder()
                        .title("Java Fullstack")
                        .beginDate(LocalDate.of(2022, 10, 24))
                        .endDate(LocalDate.of(2023, 1, 27))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Java Fullstack")
                        .beginDate(LocalDate.of(2022, 11, 2))
                        .endDate(LocalDate.of(2023, 2, 3))
                        .poeType(PoeType.POEC)
                        .build(),
                Poe.builder()
                        .title("Consultant DevOps")
                        .beginDate(LocalDate.of(2022, 6, 13))
                        .endDate(LocalDate.of(2022, 9, 16))
                        .poeType(PoeType.POEC)
                        .build(),
                Poe.builder()
                        .title("Consultant Cyber Securité")
                        .beginDate(LocalDate.of(2021, 9, 13))
                        .endDate(LocalDate.of(2021, 11, 16))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Consultant SAP")
                        .beginDate(LocalDate.of(2022, 4, 13))
                        .endDate(LocalDate.of(2022, 8, 16))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Consultant BI")
                        .beginDate(LocalDate.of(2022, 9, 24))
                        .endDate(LocalDate.of(2022, 11, 23))
                        .poeType(PoeType.POEI)
                        .build()
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
    void countPOEI() {
        long listPOEI = poeList.stream()
                .filter(p -> p.getPoeType() == PoeType.POEI)
                .count();
        System.out.println("Number of POEI : " + listPOEI);
    }

}

