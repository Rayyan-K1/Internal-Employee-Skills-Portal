package globals;

import models.Skill;
import models.SkillStrength;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SkillCollaborator {
    public static List<Skill> populateSkill(){
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill( "Word", "Office365", LocalDate.now(), SkillStrength.None));
        skills.add(new Skill( "Java", "Programming", LocalDate.now(), SkillStrength.Basic));
        skills.add(new Skill( "Junit", "Testing-Tools", LocalDate.now(), SkillStrength.Advanced));
        skills.add(new Skill( "Git", "Version-Control", LocalDate.now(), SkillStrength.ExpertTrainer));
        return skills;
    }
}
