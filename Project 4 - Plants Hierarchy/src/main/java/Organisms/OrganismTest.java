package Organisms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OrganismTest {
    @Test
    void testVenusFlyTrap() {
        VenusFlyTrap venusFlyTrap = new VenusFlyTrap(
                "Magnoliopsida",
                "Caryophyllales",
                "Droseraceae",
                "Dionaea",
                "Dionaea muscipula",
                "Venus Fly Trap",
                false,
                2.5);

        Assertions.assertEquals("Venus Fly Trap", venusFlyTrap.getName());
        Assertions.assertEquals("Dionaea muscipula", venusFlyTrap.getSpecies());
    }

    @Test
    void testAnt() {
        Ant ant = new Ant(
                "Insecta",
                "Hymenoptera",
                "Formicidae",
                "Solenopsis",
                "Solenopsis invicta",
                "Fire Ant",
                false,
                "Worker");

        Assertions.assertEquals("Fire Ant", ant.getName());
        Assertions.assertEquals("Worker", ant.getCaste());
    }

    @Test
    void testAardvark() {
        Aardvark aardvark = new Aardvark(
                "Mammalia",
                "Tubulidentata",
                "Orycteropodidae",
                "Orycteropus",
                "Orycteropus afer",
                "Aardvark",
                false,
                "Grassland",
                5.5);

        Assertions.assertEquals("Aardvark", aardvark.getName());
        Assertions.assertEquals("Grassland", aardvark.getHabitat());
    }

    @Test
    void testVenusFlyTrapConsumesAnt() {
        VenusFlyTrap venusFlyTrap = new VenusFlyTrap(
                "Magnoliopsida",
                "Caryophyllales",
                "Droseraceae",
                "Dionaea",
                "Dionaea muscipula",
                "Venus Fly Trap",
                false,
                2.5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        venusFlyTrap.consumeAnt();

        System.setOut(System.out);

        Assertions.assertEquals("Venus Fly Trap consumes an ant with its traps if gets lucky.\n".trim(), outContent.toString().trim());
    }

    @Test
    void testAardvarkConsumesAnt() {
        Aardvark aardvark = new Aardvark(
                "Mammalia",
                "Tubulidentata",
                "Orycteropodidae",
                "Orycteropus",
                "Orycteropus afer",
                "Aardvark",
                false,
                "Grassland",
                5.5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        aardvark.consumeAnt();

        System.setOut(System.out);

        Assertions.assertEquals("Aardvark eats some ants.\n".trim(), outContent.toString().trim());
    }
}
