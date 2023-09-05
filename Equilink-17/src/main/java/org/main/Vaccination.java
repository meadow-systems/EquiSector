package org.main;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

public class Vaccination {
    private final int vaccinationID;
    private String vaccinationName;
    private Date dateRecieved;

    public Vaccination() {
        this.vaccinationID = new Random()
                .ints(10001, 20000)
                .distinct()
                .limit(1)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Vaccination(String vaccinationName, Date dateRecieved) {
        this();
        if(vaccinationName == null){
            throw new IllegalArgumentException("The passed in vaccination Name is invalid.");
        }
        this.vaccinationName = vaccinationName;
        if(dateRecieved == null){
            throw new IllegalArgumentException("The passed in dateRecieved is invalid");
        }
        this.dateRecieved = dateRecieved;
    }

    public String getVaccinationName() {
        return this.vaccinationName;
    }

    public Date getDateRecieved() {
        return this.getDateRecieved();
    }
}
