package poe.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PoeTest {

    @Test
    void testToString() {
        Poe poe = new Poe();
        poe.setTitle("POEI");
        LocalDate beginDate = LocalDate.of(2022, 10, 24);
        LocalDate endDate = LocalDate.of(2023, 1, 27);
        poe.setBeginDate(beginDate);
        poe.setEndDate(endDate);
        poe.setPoeType(PoeType.POEI);
        assertEquals("POE : POEI, 2022-10-24 -> 2023-01-27, POEI", poe.toString(), "Poe toString");
    }

    @Test
    void defaultConstructor() {
        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getPoeType());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2022, 10, 24);
        LocalDate endDate = LocalDate.of(2023, 1, 27);
        Poe poe = new Poe("POEI", beginDate, endDate, PoeType.POEI);
        assertEquals("POE : POEI, 2022-10-24 -> 2023-01-27, POEI", poe.toString(), "Poe toString");
    }

}

