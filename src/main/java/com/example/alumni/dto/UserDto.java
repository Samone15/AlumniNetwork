package com.example.alumni.dto;

public class UserDto {
    String username;
    String email;
    String password;
    String fullname;

    public UserDto(Long long1, String string){

    }
    
    public UserDto(String username, String email, String password,String fullname){
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public UserDto() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname(){
        return this.fullname;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }
}
