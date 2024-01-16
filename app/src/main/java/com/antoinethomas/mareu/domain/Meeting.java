package com.antoinethomas.mareu.domain;

import java.sql.Timestamp;
import java.util.List;

public class Meeting {

    private  static long meetingIdIndex;
    /** Identifier */
    private long id;

    /** Full title */
    private String title;

    /** start date */
    private long timestampStart;

    /** duration meeting */
    private long durationInMinutes;

    /** owner id  */
    private int ownerId;

    /** participants */
    private List<Long> participantsId;

    /** Room */
    private int roomId;

    /** Description */
    private String description;

    public Meeting(String title, long timestampStart, long durationInMinutes, int ownerId, List<Long> participantsId, int roomId, String description) {
        this.id = meetingIdIndex;
        meetingIdIndex++;
        this.title = title;
        this.timestampStart = timestampStart;
        this.durationInMinutes = durationInMinutes;
        this.ownerId = ownerId;
        this.participantsId = participantsId;
        this.roomId = roomId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(long timestampStart) {
        this.timestampStart = timestampStart;
    }

    public long getDuration() {
        return durationInMinutes;
    }

    public void setDuration(long duration) {
        this.durationInMinutes = duration;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(List<Long> participantsId) {
        this.participantsId = participantsId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


