package service;

import models.SkillStrength;
import models.StaffSkills;
import repositories.StaffSkillRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class StaffSkillsService {
    private StaffSkillRepository staffSkillsRepository = null;

    public StaffSkillsService(StaffSkillRepository staffSkillRepository) {
        this.staffSkillsRepository = staffSkillRepository;
    }

    public List<StaffSkills> allStaffSkills() {
        return this.staffSkillsRepository.getAllStaffSkills();
    }

    public List<StaffSkills> addStaffSkill(String SkillName, String Description, SkillStrength skillStrength, LocalDate expiryDate) throws IllegalArgumentException {
        StaffSkills staffSkill = createSkillFromParams(SkillName, Description, skillStrength, expiryDate);
        return StaffSkillRepository.addStaffSkill(staffSkill);

    }

    private static StaffSkills createSkillFromParams(String SkillName, String Description, SkillStrength skillStrength, LocalDate expiryDate) {
        return new StaffSkills(UUID.randomUUID(), SkillName, Description, skillStrength, expiryDate);
    }

    public void deleteStaffSkill(String SelectedItem) {
        staffSkillsRepository.deleteStaff(SelectedItem);
    }

}
