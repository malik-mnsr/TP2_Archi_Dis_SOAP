package com.example.model;
public class Agency {
    private int agencyId;
    private String username;
    private String password;
    private String name;

    // Constructor
    public Agency(int agencyId, String username, String password, String name) {
        this.agencyId = agencyId;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getters and Setters
    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override toString() for easy debugging and printing
    @Override
    public String toString() {
        return "Agency{" +
                "agencyId=" + agencyId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
