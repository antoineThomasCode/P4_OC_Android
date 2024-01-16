package com.antoinethomas.mareu.domain;

public class Participant {
    private static long participantIdIndex = 0;

    private long id;
    private String email;
    private String firstName;
    private String lastName;

    public Participant(String email, String firstName, String lastName) {
        this.id = participantIdIndex;
        participantIdIndex++;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static long getParticipantIdIndex() {
        return participantIdIndex;
    }

    public static void setParticipantIdIndex(long participantIdIndex) {
        Participant.participantIdIndex = participantIdIndex;
    }

    public long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
