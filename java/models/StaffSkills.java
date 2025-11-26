package models;

import java.time.LocalDate;
import java.util.UUID;

public class StaffSkills {
    private UUID skillID;
    private SkillStrength skillStrength;
    private LocalDate expiryDate;
    private String SkillName;
    private String Description;

    public StaffSkills (UUID skillID, String SkillName, String Description, SkillStrength skillStrength, LocalDate expiryDate) {
        this.skillID = skillID;
        this.skillStrength = skillStrength;
        this.expiryDate = expiryDate;
        this.SkillName=SkillName;
        this.Description=Description;
    }

    public UUID getSkillID(){
        return skillID;
    }

    public SkillStrength getSkillStrength(){
        return skillStrength;
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    public String getSkillName(){
        return SkillName;
    }

    public String getDescription(){
        return Description;
    }

    public void setSkillID(UUID skillID){
        this.skillID=skillID;
    }

    public void setSkillStrength(SkillStrength skillStrength){
        this.skillStrength=skillStrength;
    }

    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate=expiryDate;
    }

    public void setSkillName(String SkillName){
        this.SkillName=SkillName;
    }

    public void setDescription(String Description){
        this.Description=Description;
    }

    public String toString(){
        return String.format("%s, %s - %s (%s)", SkillName, Description, skillStrength, expiryDate);
    }
}
