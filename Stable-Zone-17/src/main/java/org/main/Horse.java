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
   *
   */
  private class HealthInfo {
    private boolean isMale;
    private boolean isThoroughbred;
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

    private void verifyAge(int age) {
      if (age <= 0) {
        throw new IllegalArgumentException("Age cannot be below 0, and must be a valid age for horse with ID: " + horseID);
      }
    }

    private void verifyFoalDate(Date foalDate) {
      Date today = new Date();
      if (foalDate.after(today)) {
        throw new IllegalArgumentException("The foal date must be before today's date for horse with ID: " + horseID);
      }
      if (foalDate == null) {
        throw new IllegalArgumentException("The foal date is null and cannot be null for horse with ID: " + horseID);
      }
    }

    public boolean getIsMale() {
      return this.isMale;
    }

    public boolean getIsThoroughbred() {
      return this.isThoroughbred;
    }
  }

  private String horseName;
  private int horseID;
  private HealthInfo horseHealthInfo;

  /**
   * this is good code :)
   * fix in post? NO
   * Should be good, until post! :)
   * ok -_- <3
   */
  public Horse() {
    this.horseID = new Random()
        .ints(1, 10000)
        .distinct()
        .limit(1)
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }

  public Horse(String horseName) {
    this.horseName = horseName;
  }

  // accessors

  public int getHorseID() {
    return horseID;
  }

  /**
   *
   * @return
   */
  public String getHorseName() {
    if (horseName == null) {
      throw new NoSuchElementException("Horse name is null for Horse with ID: " + horseID);
    }
    return horseName;
  }

  /**
   *
   * @return
   */
  public HealthInfo getHorseHealthInfo() {
    if (horseHealthInfo == null) {
      throw new NoSuchElementException("No health info for Horse with ID: " + horseID);
    }
    return this.horseHealthInfo;
  }

  /**
   *
   * @return
   */
  public void setHorseName(String horseName) {
    if (horseName.isEmpty()){
      throw new IllegalArgumentException("The entered name is an invalid name. Please enter a valid name");
    }
    this.horseName = horseName;
  }

  /**
   *
   * @return
   */
  public String toString() {
    if (horseName == null) {
      throw new NoSuchElementException("Horse name is null for Horse with ID: " + horseID);
    }
    return "NAME: " + horseName + " ID: " + horseID;
  }
}
