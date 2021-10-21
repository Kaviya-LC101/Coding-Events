package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;

    @NotBlank(message="Name Required")
    @Size(min=3,max=50, message="Name must be between 3 and and 50 characters")
    private String name;

    @Size(max=500, message="Description too long!")
   private String description;

    @NotBlank(message="Email Required")
    @Email(message="Invalid email.Try again")
    private String contactEmail;

    @NotBlank(message="Event place cannot be blank. Place required")
    private String eventPlace;

    @AssertTrue(message="Attendees must Register. Please check the box")
    private boolean requiredRegistration;

    @Positive(message="Please Enter valid number.Minimum number of attendees must be 1")
    private int numberOfAttendees;

    public Event(String name , String description, String contactEmail, String eventPlace, boolean requiredRegistration,
                 int numberOfAttendees) {
        this.name = name;
        this.description=description;
        this.contactEmail=contactEmail;
        this.eventPlace=eventPlace;
        this.requiredRegistration=requiredRegistration;
        this.numberOfAttendees=numberOfAttendees;

    }

    public Event(){
        this.id=nextId;
        nextId++;
    }

    public int getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public boolean getRequiredRegistration() {
        return requiredRegistration;
    }

    public void setRequiredRegistration(boolean requiredRegistration) {
        this.requiredRegistration = requiredRegistration;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
