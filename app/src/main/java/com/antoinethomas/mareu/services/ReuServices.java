package com.antoinethomas.mareu.services;

import androidx.annotation.Nullable;

import com.antoinethomas.mareu.domain.Meeting;

import java.util.List;

public interface ReuServices {

    // data disponibles
    // début réunion -> Timestamp
    // Fin réunion -> Timestamp
    List<Meeting> getMeetings();

    List<Meeting> getMeetingById();

    /**
     * Deletes a Meeting
     * @param meeting
     */
    void deleteMeeting(Meeting meeting);

}


