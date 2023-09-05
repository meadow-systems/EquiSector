package org.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

public class Client {
  private String name;
  private final int clientID;
  private int age;
  private String[] addressList; // [Number Direction Street Name Suffix,
                                // Secondary Piece, City, State, Zip]
  private String phoneNumber;
  private String emailAddress;
  private ArrayList<Note> notes;
  private Date joinDate;
  private Horse[] horseList;
  private boolean signedRelease;

  // TODO: attributes – name, clientID, address [divided, by, mail, address, components]
  // phone number (integer with >= 9 sig figs), email address (a valid email address contains an @),
  // notes, join date
  public Client(String name) {
    if (name == null || name.isEmpty()) {
      //TODO: Implement Exception
    }
    this.name = name;
    this.clientID = new Random()
        .ints(900001, 100000)
        .distinct()
        .limit(1)
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }

  public String getName() {
    return this.name;
  }

  public int getClientID() {
    return this.clientID;
  }

  public int getAge() {
    return this.age;
  }

  public String[] getAddress() {
    return this.addressList;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public ArrayList<Note> getNotes() {
    return this.notes;
  }

  public Date getJoinDate() {
    return this.joinDate;
  }

  public Horse[] getHorseList() {
    return this.horseList;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      //TODO: Implement Exception
    }
    this.name = name;
  }

  public void setAge(int age) {
    if (age <= 0) {
      //TODO: Implement Exception
    }
    this.age = age;
  }

  public void setAddressList(String[] addressList) {
    for (int i = 0; i < addressList.length; i++) {
      if (addressList[i] == null || (addressList[i].isEmpty() && i != 1)) {
        //TODO: Implement Exception
      }
    }
    this.addressList = addressList;
  }

  public void setPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isEmpty()) {
      //TODO: Implement Exception
    }
    this.phoneNumber = phoneNumber;
  }

  public void setEmailAddress(String emailAddress) {
    if (emailAddress == null || emailAddress.isEmpty()) {
      //TODO: Implement Exception
    }
    this.emailAddress = emailAddress;
  }

  public void addNote(Note note) {
    if (note == null || note.getNote().isEmpty()) {
      //TODO: Implement Exception
    }
    this.notes.add(note);
  }

  public void removeNote(int noteID) {
    for (int i = 0; i < notes.size(); i++) {
      if (notes.get(i).getNoteID() == noteID) {
        notes.remove(i);
      }
    }
  }

  public void setNote(int noteID, String message) {
    Note note = fideNote(noteID);
    if (note != null) {
      note.setNote(message);
    }
  }











  public Note fideNote(int noteID) {
    for (int i = 0; i < notes.size(); i++) {
      if (notes.get(i).getNoteID() == noteID) {
        return notes.get(i);
      }
    }
    return null;
  }
}
