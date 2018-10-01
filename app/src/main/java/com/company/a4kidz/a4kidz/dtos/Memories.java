package com.company.a4kidz.a4kidz.dtos;

import java.util.List;

/**
 * Created by Fred Rueda on 1/10/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public class Memories{
    private int id;
    private String date;
    private List<Kids> kids;
    private int video_checked;
    private String caption;
    private List<Photos> photos;

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Kids> getKids() {
        return kids;
    }

    public void setKids(List<Kids> kids) {
        this.kids = kids;
    }

    public int getVideo_checked() {
        return video_checked;
    }

    public void setVideo_checked(int video_checked) {
        this.video_checked = video_checked;
    }

    @Override
    public String toString() {
        return "Memories{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", kids=" + kids +
                ", video_checked=" + video_checked +
                ", caption='" + caption + '\'' +
                ", photos=" + photos +
                '}';
    }

    public class Kids {

        private int id;
        private String name;
        private String lastname;
        private String photo;
        private String cc;
        private String gender;
        private int aftermoon;

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
                    '}';
        }
    }

    public class Photos{
        private int id;
        private String photo;
        private String thumbnail;
        private String created_at;

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

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        @Override
        public String toString() {
            return "Photos{" +
                    "id=" + id +
                    ", photo='" + photo + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", created_at='" + created_at + '\'' +
                    '}';
        }
    }

}
