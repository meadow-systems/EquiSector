package org.main;

import java.util.ArrayList;

public class HealthRecord {

    private String healthRecordTitle;

    private ArrayList<String> notes = new ArrayList<>();

    public HealthRecord(String healthRecordTitle,  ArrayList<String> notes){
        this.healthRecordTitle = healthRecordTitle;
        this.notes = notes;
    }

    public String getHealthRecordTitle(){
        return this.healthRecordTitle;
    }

    public ArrayList<String> getNotes(){
        return this.notes;
    }

    public void setHealthRecordTitle(String healthRecordTitle) {
        if(healthRecordTitle == null){
            throw new IllegalArgumentException("The health record title can't be null😟 you fucking clown");
        }
        this.healthRecordTitle = healthRecordTitle;
    }

    public void addNotes(ArrayList<String> notes){
        this.notes.addAll(notes);
    }
}
