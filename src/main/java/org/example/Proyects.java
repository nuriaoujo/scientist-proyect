package org.example;

import java.util.List;
import java.util.Scanner;

public class Proyects {
    private String name;
    private String department;
    private Integer budget;
    private Integer duration;
    private Scientists scientists;
    private List<String>scientistsList;

    //Get y Set
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Integer getBudget() { return budget; }
    public void setBudget(Integer budget) { this.budget = budget; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Scientists getScientists() { return scientists; }
    public void setScientists(Scientists scientists) { this.scientists = scientists; }

    public List<String>getScientistsList() { return scientistsList; }
    public void setScientistsList(List<String>scientistsList) { this.scientistsList = scientistsList; }

    //Constructor
    public Proyects (String name, String department, Integer budget, Integer duration, List<String>scientistsList) {
        this.name = name;
        this.department = department;
        this.budget = budget;
        this.duration = duration;
        this.scientistsList = scientistsList;
    }
}
