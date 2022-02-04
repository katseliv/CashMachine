package com.dataart.cashmachine.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("mid_name")
    private String midName;

    @JsonProperty("last_name")
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
