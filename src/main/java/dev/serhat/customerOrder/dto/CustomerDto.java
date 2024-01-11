package dev.serhat.customerOrder.dto;



public class CustomerDto {

    private String Id;
    private String name;
    private String username;

    public CustomerDto(String id, String name, String username) {
        Id = id;
        this.name = name;
        this.username = username;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
