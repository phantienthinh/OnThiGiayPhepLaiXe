package com.onthi.laixe.onthigiaypheplaixe.models;

public class BienBao {
    private int id;
    private String title;
    private String text;
    private String loai;
    private String image;

    public BienBao(int id, String title, String text, String loai, String image) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.loai = loai;
        this.image = image;
    }

    public BienBao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BienBao{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", loai='" + loai + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
