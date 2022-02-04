package com.dataart.cashmachine.service.model.create_dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardCreateDto {

    @NotNull(message = "email.is-null")
    private Long id;

    @JsonProperty("is_blocked")
    private Boolean isBlocked;

    @NotBlank(message = "password.is-blank")
    @Size(min = 4, message = "password.too-short")
    @Size(max = 4, message = "password.long")
    private String pincode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
