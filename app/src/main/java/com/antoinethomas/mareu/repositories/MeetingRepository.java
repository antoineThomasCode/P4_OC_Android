package com.antoinethomas.mareu.repositories;

import com.antoinethomas.mareu.domain.Meeting;
import com.antoinethomas.mareu.domain.Participant;
import com.antoinethomas.mareu.domain.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRepository {

    private static MeetingRepository instance;
    private List<Meeting> meetings = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    private MeetingRepository() {
        rooms.add(new Room( "Montpellier", "#67fdcf", "6F") );
        rooms.add(new Room( "Lille", "#f59a4b", "7F") );
        rooms.add(new Room( "Lyon", "#e2c797", "2F") );
        rooms.add(new Room( "Marseille", "#a067b3", "10F") );
        rooms.add(new Room( "Bordeaux", "#684904", "5F") );
        rooms.add(new Room( "Bordeaux", "#263a70", "9F") );
        rooms.add(new Room( "Reims", "#e834e6", "8F") );
        rooms.add(new Room( "Montpellier", "#255b69", "3F") );
        rooms.add(new Room( "Strasbourg", "#e4980b", "7F") );
        rooms.add(new Room( "Nantes", "#f359d3", "1F") );


        participants.add(new Participant("dlmuqu@wqxthd.com", "Jadxsp", "Maltra"));
        participants.add(new Participant("cpvuhw@lzpvzw.com", "Hekglc", "Ovscju"));
        participants.add(new Participant("bjrina@iaywgv.com", "Idieow", "Qczezc"));
        participants.add(new Participant("ixuuzv@afvygj.com", "Coonsv", "Kdbanq"));
        participants.add(new Participant("hntrwo@fjzxrd.com", "Dhnpwy", "Ozdlww"));
        participants.add(new Participant("ihgemk@zykcdb.com", "Jqpedd", "Gqrcdf"));
        participants.add(new Participant("jnugdp@dpsqar.com", "Mssnck", "Qelffo"));
        participants.add(new Participant("iezjin@jfdqvc.com", "Fscqie", "Xisegc"));
        participants.add(new Participant("bmxgvg@teyejy.com", "Kbtzlk", "Rmgjhr"));
        participants.add(new Participant("ytrdrr@ysaebl.com", "Rkeady", "Jwdlpd"));


        meetings.add(new Meeting("Regular Forum", 1604084932, 120, 1, Arrays.asList(1L, 7L, 5L, 1L), 2,"Strategic planning for the next quarter"));
        meetings.add(new Meeting("Project Meeting", 1539176804, 60, 5, Arrays.asList(1L, 1L, 8L, 9L), 5,"Evaluation of recent market trends"));
        meetings.add(new Meeting("Planning Summit", 1620879336, 120, 3, Arrays.asList(2L, 6L, 4L, 3L), 4,"Strategic planning for the next quarter"));
        meetings.add(new Meeting("Regular Conference", 1602268060, 90, 5, Arrays.asList(3L, 10L, 4L, 7L), 4,"Review of team performance and goals"));
        meetings.add(new Meeting("Planning Forum", 1532883843, 90, 5, Arrays.asList(3L, 5L, 10L, 9L), 1,"Training on new software and tools"));
        meetings.add(new Meeting("Team Forum", 1635958251, 120, 9, Arrays.asList(8L, 3L, 1L, 4L), 3,"Evaluation of recent market trends"));
        meetings.add(new Meeting("Regular Gathering", 1673776693, 30, 10, Arrays.asList(5L, 5L, 8L, 6L), 1,"Strategic planning for the next quarter"));
        meetings.add(new Meeting("Team Gathering", 1640709674, 60, 5, Arrays.asList(4L, 10L, 4L, 7L), 4,"Review of team performance and goals"));
        meetings.add(new Meeting("Project Forum", 1516676860, 90, 4, Arrays.asList(4L, 5L, 10L, 3L), 3,"Training on new software and tools"));
        meetings.add(new Meeting("Important Gathering", 1645786465, 60, 2, Arrays.asList(5L, 4L, 4L, 6L), 1,"Discussing project milestones and deadlines"));

    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public static MeetingRepository getInstance() {
        if (instance == null) {
            instance = new MeetingRepository();
        }
        return instance;
    }
}
