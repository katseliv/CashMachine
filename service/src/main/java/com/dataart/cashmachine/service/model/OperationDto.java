package com.dataart.cashmachine.service.model;

import javax.validation.constraints.NotBlank;

public class OperationDto {

    private Integer id;

    @NotBlank(message = "is-blank")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
