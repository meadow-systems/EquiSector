package org.main;

import java.util.NoSuchElementException;
import java.util.Random;

public class Note {

  private int noteID;
  private String note;

  public Note() {
    this.noteID = new Random()
        .ints(20001, 30000)
        .distinct()
        .limit(1)
        .findFirst()
        .orElseThrow(NoSuchElementException::new);
  }

  public Note(String note){
    this.note = note;
  }

  public void setNote(String newNote){
    this.note = newNote;
  }

  public String getNote(){
    return note;
  }

  public int getNoteID(){
    return noteID;
  }

}
