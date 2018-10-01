package com.company.a4kidz.a4kidz.dtos;

import java.util.List;

/**
 * Created by Fred Rueda on 26/09/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class ResponseLoginDTO {

    private int id;
    private String email;
    private String name;
    private String lastname;
    private int role;
    private String phone;
    private String photo;
    private int daycare;
    private int location;
    private String token;
    private List<Kids> kids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDaycare() {
        return daycare;
    }

    public void setDaycare(int daycare) {
        this.daycare = daycare;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Kids> getKids() {
        return kids;
    }

    public void setKids(List<Kids> kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return "ResponseLoginDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", daycare=" + daycare +
                ", location=" + location +
                ", token='" + token + '\'' +
                ", kids=" + kids +
                '}';
    }
}
