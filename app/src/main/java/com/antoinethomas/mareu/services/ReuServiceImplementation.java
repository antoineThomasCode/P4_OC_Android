package com.antoinethomas.mareu.services;

import com.antoinethomas.mareu.domain.Meeting;

import java.util.ArrayList;
import java.util.List;

public class ReuServiceImplementation implements ReuServices {
    private final List<Meeting> meetings;

    public ReuServiceImplementation() {
        meetings = new ArrayList<>();
        meetings.add(new Meeting());
        meetings.add(new Meeting());
        meetings.add(new Meeting());
        meetings.add(new Meeting());
    }

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }
}
