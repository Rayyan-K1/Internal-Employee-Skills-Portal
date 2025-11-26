package models;

import java.util.UUID;

public class UserRole {
    private UUID Id;
    private String role;

    public UserRole(UUID Id, String role){
        this.Id = Id;
        this.role = role;
    }

    public UUID getRoleId(){
        return Id;
    }

    public String getRole(){
        return role;
    }

    public void setRoleId(UUID Id){
        this.Id=Id;
    }

    public void setRole(String role){
        this.role=role;
    }

    public String toString(){
        return String.format("%s %s", Id, role);
    }
}

