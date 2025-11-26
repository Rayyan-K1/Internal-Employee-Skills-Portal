package repositories;

import globals.FakeDatabase;
import models.StaffSkills;

import java.util.List;

public class StaffSkillRepository {
    private static FakeDatabase fakeDatabase;

    public StaffSkillRepository(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
    }

    public static List<StaffSkills> getAllStaffSkills() {
        return fakeDatabase.getStaffSkills();
    }

    public static List<StaffSkills> addStaffSkill(StaffSkills staffSkill){
            getAllStaffSkills().add(staffSkill);
            return getAllStaffSkills();
    }
    public List<StaffSkills> deleteSpecificStaff(String SelectedItem) {
        int index = fakeDatabase.deleteStaffSkill(SelectedItem);
        System.out.println(index);
        getAllStaffSkills().remove(index);
        return getAllStaffSkills();
    }
    public void deleteStaff(String SelectedItem) {
        deleteSpecificStaff(SelectedItem);
    }
}
