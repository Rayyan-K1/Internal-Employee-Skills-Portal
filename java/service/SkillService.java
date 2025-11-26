package service;

import models.Skill;
import models.SkillStrength;
import repositories.SkillRepository;

import java.time.LocalDate;
import java.util.List;

//import java.time.LocalDate;

public class SkillService {
    private final SkillRepository skillRepository;
    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public List<Skill> allSkills() {
        return this.skillRepository.getAllSkills();
    }

    public void addSkill(String description, String category, LocalDate expiryDate, SkillStrength skillStrength) throws IllegalArgumentException {
        Skill skill = createSkillFromParams(description, category, expiryDate, skillStrength);
        System.out.println("SkillService " + skill);
        skillRepository.addSkill(skill);
    }

    private static Skill createSkillFromParams(String description, String category, LocalDate expiryDate, SkillStrength skillStrength) {
        return new Skill(description, category, expiryDate, skillStrength);
    }

    public void deleteSkill(Object SkillsDetails) {
        System.out.println("Got to the Second Skills part");
        skillRepository.deleteSkill(SkillsDetails);
    }
}
