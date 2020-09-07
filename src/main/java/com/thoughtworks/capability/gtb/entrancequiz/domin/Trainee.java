package com.thoughtworks.capability.gtb.entrancequiz.domin;

public class Trainee {
    private Integer id;
    private String name;

    public Trainee(Integer id, String name ) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
