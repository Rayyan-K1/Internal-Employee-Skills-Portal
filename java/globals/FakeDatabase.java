package globals;

import models.Role;
import models.Skill;
import models.Staff;
import models.StaffSkills;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {
    private final static List<Skill> skills = SkillCollaborator.populateSkill();
    private final static List<Role> role = RoleCollaborator.populateRole();
    private static List<Staff> staff = StaffCollaborator.populateStaff();
    private final List<StaffSkills> staffSkills = StaffSkillCollaborator.populateStaffSkill();

    public FakeDatabase() {

    }

    public List<Skill> getSkills(){
        System.out.println(this.skills);
        return skills;
    }

    public List<StaffSkills> getStaffSkills() {
        return staffSkills;
    }

    public int deleteSkill(Object SkillDetails) {
        int index=0;
        for (Skill obj: skills) {
            if (obj.toString().equals(SkillDetails.toString())) {
                return index;
            } else {
                index++;
            }
        }
        return index;
    }

    public List<Staff> getStaff(String State){
        List<Staff> FilteredStaff = new ArrayList<>();
        if(State.contains("Developer")) {
            for (Staff staff : staff) {
                if (staff.getStaffRole().contains(State)) {
                    FilteredStaff.add(staff);
                }
            }
            return FilteredStaff;
        } else if(State.equals("Word") || State.equals("Java") || State.equals("Junit") || State.equals("Git")) {
            for (Staff staff: staff) {
                boolean hasSkill = false;
                try {
                    for (StaffSkills skill : staff.getStaffSkillsArray()) {
                        if (skill.getDescription().equals(State)) {
                            hasSkill = true;
                        }
                    }
                    if(hasSkill == true) {
                        FilteredStaff.add(staff);
                    }
                }catch (NullPointerException e) {

                }
            }
            return FilteredStaff;
        } else if(State.equals("None") || State.equals("Basic") || State.equals("Advanced") || State.equals("ExpertTrainer")) {
            for (Staff staff: staff) {
                boolean hasSkill = false;
                try {
                    for (StaffSkills skill : staff.getStaffSkillsArray()) {
                        if (skill.getSkillStrength().toString().equals(State)) {
                            hasSkill = true;
                        }
                    }
                    if(hasSkill == true) {
                        FilteredStaff.add(staff);
                    }
                }catch (NullPointerException e) {

                }
            }
            return FilteredStaff;
        }
        return staff;
    }
    public int deleteStaff(String StaffDetails) {
        int index=0;
        for (Staff obj: staff) {
            String Obj_Id = obj.getStaffId().toString();
            if (Obj_Id.equals(StaffDetails)) {
                return index;
            } else {
                index++;
            }
        }
        return index;
    }
    public int deleteStaffSkill(String SelectedItem) {
        int index=0;
        for (StaffSkills obj: staffSkills) {
            String Obj_Id = obj.getSkillID().toString();
            if (Obj_Id.equals(SelectedItem)) {
                return index;
            } else {
                index++;
            }
        }
        return index;
    }
    public List<Role> getAllJobRoles(){
        System.out.println(this.role);
        return this.role;
    }
}
