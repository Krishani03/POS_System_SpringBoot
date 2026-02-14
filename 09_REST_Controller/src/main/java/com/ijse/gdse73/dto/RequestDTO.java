package com.ijse.gdse73.dto;

public class RequestDTO {
    private String id;
    private String name;

    public RequestDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public RequestDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
