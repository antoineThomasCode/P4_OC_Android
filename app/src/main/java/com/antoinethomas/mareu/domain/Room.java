package com.antoinethomas.mareu.domain;

public class Room {
    private static long roomIdIndex = 0 ;
    private long id;
    private String name;
    private String color;
    private String location;

    public Room(String name, String color, String location) {
        this.id = roomIdIndex;
        roomIdIndex++;
        this.name = name;
        this.color = color;
        this.location = location;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
