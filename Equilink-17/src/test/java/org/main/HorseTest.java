package org.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author nico-himself
 */
public class HorseTest {

  // validate horse constructors, ensure they protect against erroneous inputs
  @Test void testHorseConstructor() {
    assertAll(() -> {
      Horse horse = new Horse();
      assertNotNull(horse);
    },
        () -> {
      Horse horse = new Horse("Evan", true);
      assertNotNull(horse);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      Horse horse = new Horse(null, true);
    });
  }


  // validate getters and setters
  @Test void testHorseGettersSetters() {
    Horse horse = new Horse("Nico", true);
    assertAll(() -> {
      // check NPEs and IllegalArgumentExceptions
      assertThrows(IllegalArgumentException.class, () -> {
        horse.setHorseName(null);
      });

      assertDoesNotThrow(() -> {
        horse.setHorseName("Evan");
      });

      // the HealthInfo subclass method
      assertDoesNotThrow(() -> {
        horse.setThoroughbred(true);
      });

      // TODO: add more tests for other getters and setters

    });
  }

  // TODO: validate HealthInfo subclass

}
