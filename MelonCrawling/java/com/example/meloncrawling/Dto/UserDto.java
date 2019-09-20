package com.example.meloncrawling.Dto;

/**
 * User 객체 클래스
 */
public class UserDto {

    private String id;
    private String pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserDto(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
}
