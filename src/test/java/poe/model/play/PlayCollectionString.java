package poe.model.play;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayCollectionString {

    @Test
    void playWithList1() {
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Otter");
        animals.add("Cat");
        System.out.println("Size of the animals collection : " + animals.size());
        for (String animal : animals) {
            System.out.println("\t- " + animal);
        }
        String animal = animals.get(0);
        System.out.println("Animal at index 0 : " + animal);
    }

    @Test
    void playWithList2() {
        List<String> animals = new ArrayList<>();
        Collections.addAll(animals, "Dog", "Otter", "Bull");
        for (String animal : animals) {
            System.out.println("\t -> " + animal + " (Animal # " + animals.indexOf(animal) + ")");
        }
    }

    @Test
    void playWithList3() {
        // Since Java 11
        List<String> animals = List.of("Dog", "Bull", "Cat", "Otter", "Snake", "Mouse");
        // This is immutable
        // Following statement throws UnsupportedOperationException
        // animals.add("Panther");

        /**
         * Loops : Statements
         */

        for (String animal : animals) {
            System.out.println("\t -> " + animal.toUpperCase() + " (Animal at index # " + animals.indexOf(animal) + ") - foreach loop");
        }

        System.out.println("\t");

        for (int i = 0; i < animals.size(); i++) {
            System.out.println("\t _ " + animals.get(i) + " (Animal at index # " + animals.indexOf(animals.get(i)) + ") - fori loop");
        }

        System.out.println("\t");

        /**
         * Loops : Functionnal
         */

        // 1 .forEach(f)
        animals.forEach(a -> System.out.println("\t ~ " + a + " - Word with " + a.length() + " letters - " + " (Animal at index #" + animals.indexOf(a) + ") - forEach()"));

        // 2. .reduce, .map, .filter
        List<Integer> countLetters1 = animals.stream()
                .map(a -> a.length())
                .toList(); // Java 17
        System.out.println(countLetters1);

        // 3. Other pipeline
        List<Integer> countLetters2 = animals.stream()
                .filter(a -> a.endsWith("e"))
                .map(String::length)
                .toList();
        System.out.println(countLetters2);

        // 4. pipeline with reduce
        int totalCountLetters = animals.stream()
                .filter(a-> a.endsWith("e"))
                .mapToInt(String::length)
                        .sum();
        System.out.println("Total of letters from words ending with the letter 'e' : " + totalCountLetters);
    }


}
