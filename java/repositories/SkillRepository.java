package repositories;

import globals.FakeDatabase;
import models.Skill;
import models.Staff;

import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    private final FakeDatabase fakeDatabase;

    public SkillRepository(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
    }

    public List<Skill> getAllSkills(){
        return fakeDatabase.getSkills();
    }

    public List<Skill> deleteSpecificSkill(Object SkillDetails) {
        int index = fakeDatabase.deleteSkill(SkillDetails);
        System.out.println(index);
        getAllSkills().remove(index);
        return getAllSkills();
    }

    public void addSkill(Skill skill){
        if(!getAllSkills().contains(skill)){
            getAllSkills().add(skill);
        }
    }
    public void deleteSkill(Object SkillDetails) {
        deleteSpecificSkill(SkillDetails);
    }
}
