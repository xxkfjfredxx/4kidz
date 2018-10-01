package com.company.a4kidz.a4kidz.dtos;

/**
 * Created by Fred Rueda on 26/09/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class Kids {

    private int id;
    private String name;
    private String lastname;
    private String photo;
    private String cc;
    private String gender;
    private int aftermoon;
    private Groupx groupx;
    private Pivot pivot;
    private Location location;

    private class Groupx{
        private int id;
        private Director director;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Kids.Director getDirector() {
            return director;
        }

        public void setDirector(Kids.Director director) {
            this.director = director;
        }

        @Override
        public String toString() {
            return "groupx{" +
                    "id=" + id +
                    ", director=" + director +
                    '}';
        }
    }

    private class Director{
        private int id;
        private String name;
        private String lastname;
        private String photo;
        private String email;
        private String phone;
        private int role;

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

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "director{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", photo='" + photo + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", role=" + role +
                    '}';
        }
    }

    private class Pivot{
        private int user_id;
        private int kid_id;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getKid_id() {
            return kid_id;
        }

        public void setKid_id(int kid_id) {
            this.kid_id = kid_id;
        }

        @Override
        public String toString() {
            return "pivot{" +
                    "user_id=" + user_id +
                    ", kid_id=" + kid_id +
                    '}';
        }
    }

    private class Location{
        private int id;
        private String name;
        private DayCare daycare;

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

        public DayCare getDaycare() {
            return daycare;
        }

        public void setDaycare(DayCare daycare) {
            this.daycare = daycare;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", daycare=" + daycare +
                    '}';
        }
    }

    private class DayCare{
        private int id;
        private String photo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        @Override
        public String toString() {
            return "DayCare{" +
                    "id=" + id +
                    ", photo='" + photo + '\'' +
                    '}';
        }
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAftermoon() {
        return aftermoon;
    }

    public void setAftermoon(int aftermoon) {
        this.aftermoon = aftermoon;
    }

    public Groupx getGroupx() {
        return groupx;
    }

    public void setGroupx(Groupx groupx) {
        this.groupx = groupx;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Kids{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", photo='" + photo + '\'' +
                ", cc='" + cc + '\'' +
                ", gender='" + gender + '\'' +
                ", aftermoon=" + aftermoon +
                ", groupx=" + groupx +
                ", pivot=" + pivot +
                ", location=" + location +
                '}';
    }
}
