package com.videoBox.model;

import javax.persistence.*;
@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String comment;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] video;

    private String videoPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Post(){
    }

    public Post(String comment){
        this.comment = comment;
    }
}
