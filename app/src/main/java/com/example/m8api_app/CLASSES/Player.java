package com.example.m8api_app.CLASSES;

import java.io.Serializable;

public class Player implements Serializable {
    public String playerName;
    public int age;
    public String position;
    public int shirtNo;
    public int goal;

    public Player(){
    }

    public Player(String playerName, int age, String position, int shirtNo, int goal) {
        this.playerName = playerName;
        this.age = age;
        this.position = position;
        this.shirtNo = shirtNo;
        this.goal = goal;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNo() {
        return shirtNo;
    }

    public void setShirtNo(int shirtNo) {
        this.shirtNo = shirtNo;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

}