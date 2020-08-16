package com.example.mad;

public class guest {

    private int id;
    private String name,gender,type,invitation,telno,address,email;
    private long started,finished;
    public guest(){
    }
    public guest(int id, String name, String gender, String type, String invitation, String telno, String address, String email, long started, long finished) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;

        this.invitation = invitation;
        this.telno = telno;
        this.address = address;
        this.email = email;
        this.started = started;
        this.finished = finished;
    }

    public guest(String name, String gender, String type,  String invitation, String telno, String address, String email, long started, long finished) {
        this.name = name;
        this.gender = gender;
        this.type = type;

        this.invitation = invitation;
        this.telno = telno;
        this.address = address;
        this.email = email;
        this.started = started;
        this.finished = finished;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
