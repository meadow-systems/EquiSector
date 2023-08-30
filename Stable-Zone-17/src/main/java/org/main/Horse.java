package org.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.lang.IllegalArgumentException;

/**
 * The Horse class
 */
public class Horse {

  /**
   * The HealthInfo class, a subclass of Horse which contains the health information of the
   * Horse object.
   */
  private class HealthInfo {
    private final boolean isMale;
    private final boolean isThoroughbred;
    private int age;
    private Date foalDate;
    private ArrayList<Vaccination> vaccinationsList;
    private ArrayList<HealthRecord> healthRecordsList;

//    public HealthInfo(boolean isMale) {
//      verifyMale(isMale);
//      this.isMale = isMale;
//      isThoroughbred = false;
//    }
//
//    public HealthInfo(boolean isMale, boolean isThoroughbred) {
//      verifyMale(isMale);
//      verifyThoroughbred(isThoroughbred);
//      this.isMale = isMale;
//      this.isThoroughbred = isThoroughbred;
//    }
//
//    public HealthInfo(boolean isMale, boolean isThoroughbred, int age) {
//      verifyMale(isMale);
//      verifyThoroughbred(isThoroughbred);
//      verifyAge(age);
//      this.isMale = isMale;
//      this.isThoroughbred = isThoroughbred;
//      this.age = age;
//    }

    public HealthInfo(boolean isMale, boolean isThoroughbred, int age, Date foalDate) {
      verifyAge(age);
      verifyFoalDate(foalDate);
      this.isMale = isMale;
      this.isThoroughbred = isThoroughbred;
      this.age = age;
      this.foalDate = foalDate;

    }

    /**
     * @param age the age to verify
     * @throws IllegalArgumentException if the age is nonsensical
     */
    private void verifyAge(int age) {
      if (age <= 0) {
        throw new IllegalArgumentException(
            "Age cannot be below 0, and must be a valid age for horse with ID: " + horseID);
      }
    }

    /**
     * @param foalDate the foal date to verify
     * @throws IllegalArgumentException if the foal date is null or in the future
     */
    private void verifyFoalDate(Date foalDate) {
      Date today = new Date();

      if (foalDate == null) {
        throw new IllegalArgumentException("Foal date cannot be null for horse with ID: " + horseID);
      }

      if (foalDate.after(today)) {
        throw new IllegalArgumentException("Foal date cannot be in the future for horse with ID: " + horseID);
      }
    }

    /**
     * @return true if the Horse is male, false otherwise
     */
    public boolean getIsMale() {
      return this.isMale;
    }

    /**
     * @return true if the Horse is a thoroughbred, false otherwise
     */
    public boolean getIsThoroughbred() {
      return this.isThoroughbred;
    }
  } // ... end HealthInfo subclass

  private String horseName; // name of the horse
  private int horseID; // unique ID of the horse
  private HealthInfo horseHealthInfo; // health information concerning the horse

  // constructors
  // TODO: Integrate HealthInfo into constructor ->  horseHealthInfo = new HealthInfo(isMale, isThoroughbred, age, foalDate)

  /**
   * Default constructor for Horse
   */
  public Horse() {
    this.horseID = new Random()
        .ints(1, 10000)
        .distinct()
        .limit(1)
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }

  /**
   * Constructor for Horse + name
   * @param horseName the name of the horse
   */
  public Horse(String horseName) {
    super();
    this.horseName = horseName;
  }

  // TODO: Accessors and mutators for HealthInfo

  public int getHorseID() {
    return horseID;
  }

  /**
   * @return a String representation of the Horse object TODO: Revise this method
   */
  public String toString() {
    if (horseName == null) {
      throw new NoSuchElementException("Horse name is null for Horse with ID: " + horseID);
    }
    return "NAME: " + horseName + " ID: " + horseID;
  }
}
