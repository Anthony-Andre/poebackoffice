package poe.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TestPoeType {

    @Test
    void testLitteralPOEI(){
        PoeType poeType = PoeType.POEI;
        System.out.println(poeType);
        assertEquals("POEI", poeType.toString());
    }

    @ParameterizedTest
    @EnumSource(PoeType.class)
    void testAllLitterals(PoeType poeType){
        System.out.println(poeType);
    }
}