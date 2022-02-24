package com.colorly.backend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnoreProperties({ "email" })
    @ManyToOne(targetEntity = User.class)
    private User owner;

    @JsonIgnore
    @ManyToMany(targetEntity = User.class)
    private Set<User> likers;

    @ManyToMany(targetEntity = Item.class)
    private Set<Item> items;

    public Integer getId() {
        return id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }
    
    public Set<User> getLikers() {
        return likers;
    }
    
    public void setLikers(Set<User> likers) {
        this.likers = likers;
    }
    
    public Integer getLikes() {
        return likers.size();
    }

    public void addLiker(User liker) {
        likers.add(liker);
    }

    public void removeLiker(User liker) {
        likers.remove(liker);
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
