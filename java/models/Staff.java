package models;

import java.util.List;
import java.util.UUID;

public class Staff {
    private UUID Id;
    private String role; // add StaffRole list
    private String firstname;
    private String surname;
    private String username;
    private String password;
    private String userRole;
    private List<StaffSkills> staffSkillsArrayList;

    public Staff(String role, String firstname, String surname, String username, String password, String userRole, List<StaffSkills> staffSkillsArray) {
        this.role = role;
        this.Id = UUID.randomUUID();
        this.userRole = userRole;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.staffSkillsArrayList = staffSkillsArray;
    }

    public UUID getStaffId(){
        return Id;
    }

    public String getStaffRole(){
        return role;
    }

    public String getStaffFirstname(){
        return firstname;
    }

    public String getStaffSurname(){
        return surname;
    }

    public String getStaffUserRole(){
        return userRole;
    }

    public String getStaffUsername(){ return username; }

    public String getStaffPassword(){ return password; }

    public List<StaffSkills> getStaffSkillsArray() {
        return staffSkillsArrayList;
    }

    public void setStaffId(UUID Id){
        this.Id=Id;
    }

    public void setStaffRole(String role){
        this.role=role;
    }

    public void setStaffFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setStaffSurname(String surname){
        this.surname = surname;
    }

    public void setStaffUsername(String username){
        this.username = username;
    }

    public void setStaffPassword(String password){ this.password = password; }

    public void setStaffUserRole(String userRole){ this.userRole = userRole; }

    public void setStaffSkillsArrayList(List<StaffSkills> staffSkillsArrayList) {
        this.staffSkillsArrayList = staffSkillsArrayList;
    }

    public String toString(){
        return String.format("%s %s (%s)", firstname, surname, role);
    }
}
