package models;

import java.time.LocalDate;

public class Skill {
    private String description;
    private String category;
    private LocalDate expiryDate;
    private SkillStrength skillStrength;

    public Skill(String description, String category, LocalDate expiryDate, SkillStrength skillStrength){ //add date once fixed
        this.description = description;
        this.category = category;
        this.skillStrength = skillStrength;
        this.expiryDate = expiryDate;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCategory(){
        return this.category;
    }

    public SkillStrength getSkillStrength(){
        return this.skillStrength;
    }

    public LocalDate getExpiryDate(){
        return this.expiryDate;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public void setSkillStrength(SkillStrength skillStrength){
        this.skillStrength=skillStrength;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String toString(){
        return String.format("%s %s", this.description, this.category, this.skillStrength, this.expiryDate);
    }
}
