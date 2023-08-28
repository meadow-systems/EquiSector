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
    private int horseID;
    private Date foalDate;
    private ArrayList<Vaccination> vaccinationsList;
    private ArrayList<HealthRecord> healthRecordsList;

    public HealthInfo(int horseID) {
      this.horseID = horseID;
    }

    public HealthInfo(boolean isMale, int age, boolean isThoroughbred) {
      this.isMale = isMale;
      this.age = age;
      this.isThoroughbred = isThoroughbred;
    }

    public boolean getIsMale() {
      return this.isMale;
    }

    public boolean getIsThoroughbred() {
      return this.isThoroughbred;
    }

    public int getAge() {
      return this.age;
    }

    public Date getFoalDate() {
      return this.foalDate;
    }
  }

  private String horseName;
  private int horseID;
  private HealthInfo horseHealthInfo;

  /**
   * this is good code :)
   * fix in post? NO
   * Should be good, until post! :)
   * ok -_-
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
