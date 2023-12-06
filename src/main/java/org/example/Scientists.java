package org.example;

public class Scientists {
    private String name;
    private Integer age;
    private String address;

    //Get y Set
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() {return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    //Constructor
    public Scientists (String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
