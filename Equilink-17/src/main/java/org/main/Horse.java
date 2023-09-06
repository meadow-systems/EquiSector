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

    private boolean isMale;
    private boolean isThoroughbred;
    private int age;
    private Date foalDate;
    private ArrayList<Vaccination> vaccinationsList;
    private ArrayList<HealthRecord> healthRecordsList;

  }// ... end HealthInfo subclass

  private String horseName; // name of the horse
  private final int horseID; // unique ID of the horse
  private ArrayList<Client> owner; // owner(s) of the horse
  private HealthInfo horseHealthInfo; // health information concerning the horse
  private ArrayList<Client> owners;

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
    this.horseHealthInfo = new HealthInfo();
  }

  /**
   * @param horseName the name of the Horse
   * @param isMale true if male, false otherwise
   */
  public Horse(String horseName, boolean isMale) {
    this();
    if (horseName == null) {
      throw new IllegalArgumentException("Sorry buddy, you have to input something for the 🐴 name.🙁🙁🙁🙁");
    }
    this.horseName = horseName;
    this.horseHealthInfo.isMale = isMale;
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

  public ArrayList<Client> getOwner() { return this.owner; }

  /**
   * @return the horse's Health info
   */
  public HealthInfo getHorseHealthInfo() {
    return this.horseHealthInfo;
  }

  public boolean isMale() {
    return this.horseHealthInfo.isMale;
  }

  public boolean isThoroughbred() {
    return this.horseHealthInfo.isThoroughbred;
  }

  public int getAge() {
    return this.horseHealthInfo.age;
  }

  public void setThoroughbred(boolean isThoroughbred) {
    this.horseHealthInfo.isThoroughbred = isThoroughbred;
  }

  public Date getFoalDate() {
    return this.horseHealthInfo.foalDate;
  }

  public ArrayList<Vaccination> getVaccinationsList() {
    return this.horseHealthInfo.vaccinationsList;
  }

  public ArrayList<HealthRecord> getHealthRecordsList() {
    return this.horseHealthInfo.healthRecordsList;
  }

  public ArrayList<Client> getOwners() {
    return this.owners;
  }

  public void setMale(boolean isMale) {
    this.horseHealthInfo.isMale = isMale;
  }

  public void setAge(int age) {
    if (age <= 0){
      throw new IllegalArgumentException("The age you wish to set cannot be 0 or negative.");
    }
    this.horseHealthInfo.age = age;
  }

  public void setFoalDate(Date foalDate) {
    Date today = new Date();
    if (foalDate == null) {
      throw new IllegalArgumentException("Foal date cannot be null for horse with ID: " + horseID);
    }
    if (foalDate.after(today)) {
      throw new IllegalArgumentException("Foal date cannot be in the future for horse with ID: " + horseID);
    }
    this.horseHealthInfo.foalDate = foalDate;
  }

  public void setVaccinationsList(ArrayList<Vaccination> vaccinationsList) {
    if (vaccinationsList == null) {
      throw new IllegalArgumentException("The passed in vaccinations List cannot be null.");
    }
    this.horseHealthInfo.vaccinationsList = vaccinationsList;
  }

  public void setHealthRecordsList(ArrayList<HealthRecord> healthRecordsList) {
    if(healthRecordsList == null){
      throw new IllegalArgumentException("The passed in health records list cannot be null.");
    }
    this.horseHealthInfo.healthRecordsList = healthRecordsList;
  }

  public void addVaccination(Vaccination vaccination) {
    if (vaccination == null) {
      throw new IllegalArgumentException("The passed in vaccination cannot be null.");
    }
    this.horseHealthInfo.vaccinationsList.add(vaccination);
  }

  public void addHealthRecord(HealthRecord healthRecord){
    if (healthRecord == null) {
      throw new IllegalArgumentException("The passed in health record cannot be null.");
    }
    this.horseHealthInfo.healthRecordsList.add(healthRecord);
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

  public void addOwner(Client owner) {
    if (owner == null) {
      throw new IllegalArgumentException("🍕");
    }
    this.owners.add(owner);
  }

  public void removeOwner(int ownerID) {
    if (ownerID < 0 || ownerID < 90001 || ownerID > 100000) {
      //TODO: Implement Exception
    }
    for (int i = 0; i < owners.size(); i++) {
      if (owners.get(i).getClientID() == ownerID) {
        owners.remove(i);
      }
    }
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
