package com.example.recyclerview;

public class Restaurant {
    private String name, description, contact, location, ratings;
    //private  int ratings;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String contact ,String rating, String location) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.ratings = rating;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRatings() {
        return this.ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getLocation(){ return  location;  }

    public void setLocation(String location){ this.location=location; }


}
