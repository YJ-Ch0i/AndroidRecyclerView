package com.example.meloncrawling.Dto;

/**
 * Music 객체 클래스
 */
public class MusicDto {
    private String imgSoruce; //프로필사진 링크
    private String title; //노래 제목
    private String singer; //가수명
    private String Album; //앨범명
    private int rank;

    public String getImgSoruce() {
        return imgSoruce;
    }

    public void setImgSoruce(String imgSoruce) {
        this.imgSoruce = imgSoruce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public MusicDto(){}
    public MusicDto(String imgSoruce, String title, String singer, String album, int rank) {
        this.imgSoruce = imgSoruce;
        this.title = title;
        this.singer = singer;
        Album = album;
        this.rank = rank;
    }
}
