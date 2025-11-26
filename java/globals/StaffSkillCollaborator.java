package globals;

import models.StaffSkills;

import java.util.ArrayList;
import java.util.List;

public class StaffSkillCollaborator {
    public static List<StaffSkills> populateStaffSkill(){
        List<StaffSkills> StaffSkills= new ArrayList<>();
        StaffSkills.clear();
        System.out.print(StaffSkills.toString());
        return StaffSkills;
    }
}
