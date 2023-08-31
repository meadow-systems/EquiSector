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
    private boolean isThoroughbred;
    private int age;
    private Date foalDate;
    private ArrayList<Vaccination> vaccinationsList;
    private ArrayList<HealthRecord> healthRecordsList;

    public HealthInfo(boolean isMale) {
      this.isMale = isMale;
    }

    public boolean isMale() {
      return isMale;
    }

    public boolean isThoroughbred() {
      return isThoroughbred;
    }

    public int getAge() {
      return age;
    }

    public Date getFoalDate() {
      return foalDate;
    }

    public ArrayList<Vaccination> getVaccinationsList() {
      return vaccinationsList;
    }

    public ArrayList<HealthRecord> getHealthRecordsList() {
      return healthRecordsList;
    }

    public void setThoroughbred(boolean isThoroughbred) {
      this.isThoroughbred = isThoroughbred;
    }

    public void setAge(int age) {
      if (age <= 0){
        throw new IllegalArgumentException("The age you wish to set cannot be 0 or negative.");
      }
      this.age = age;
    }

    public void setFoalDate(Date foalDate) {
      Date today = new Date();
      if (foalDate == null) {
        throw new IllegalArgumentException("Foal date cannot be null for horse with ID: " + horseID);
      }
      if (foalDate.after(today)) {
        throw new IllegalArgumentException("Foal date cannot be in the future for horse with ID: " + horseID);
      }
      this.foalDate = foalDate;
    }

    public void setVaccinationsList(ArrayList<Vaccination> vaccinationsList) {
      if (vaccinationsList == null) {
        throw new IllegalArgumentException("The passed in vaccinations List cannot be null.");
      }
      this.vaccinationsList = vaccinationsList;
    }

    public void setHealthRecordsList(ArrayList<HealthRecord> healthRecordsList) {
      if(healthRecordsList == null){
        throw new IllegalArgumentException("The passed in health records list cannot be null.");
      }
      this.healthRecordsList = healthRecordsList;
    }

    public void addVaccination(Vaccination vaccination) {
      if (vaccination == null) {
        throw new IllegalArgumentException("The passed in vaccination cannot be null.");
      }
      this.vaccinationsList.add(vaccination);
    }

    public void addHealthRecord(HealthRecord healthRecord){
      if (healthRecord == null) {
        throw new IllegalArgumentException("The passed in health record cannot be null.");
      }
      this.healthRecordsList.add(healthRecord);
    }
  }// ... end HealthInfo subclass

  private String horseName; // name of the horse
  private int horseID; // unique ID of the horse
  private HealthInfo horseHealthInfo; // health information concerning the horse

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
   * @param horseName the name of the Horse
   * @param isMale true if male, false otherwise
   */
  public Horse(String horseName, boolean isMale) {
    this();
    this.horseName = horseName;
    this.horseHealthInfo = new HealthInfo(isMale);
  }

  /**
   * Getter for the horse's ID
   * @return the horse ID
   */
  public int getHorseID() {
    return horseID;
  }

  /**
   * Getter for the horse's Name
   * @return the horse's Name
   */
  public String getHorseName() {
    return this.horseName;
  }

  /**
   * Getter for the horse's Health Info
   * @return the horse's Name
   */
  public HealthInfo getHorseHealthInfo() {
    return horseHealthInfo;
  }

  /**
   * Setter for the horse's name
   * @param horseName The horse's new name
   */
  public void setHorseName(String horseName) {
    if (horseName == null) {
      throw new IllegalArgumentException("Sorry buddy, you have to input something for the 🐴 name.🙁🙁🙁🙁");
    }
    this.horseName = horseName;
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
