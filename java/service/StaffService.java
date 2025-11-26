package service;

import models.Staff;
import models.StaffSkills;
import repositories.StaffRepository;

import java.util.List;

public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> allStaff(String State) {
        return this.staffRepository.getAllStaff(State);
    }

    public void addStaff(String firstName, String surname, String username, String password, String jobRole, String UserRole, List<StaffSkills> StaffSkillsArrayList) throws IllegalArgumentException {
            Staff staff = createStaffFromParams(firstName, surname, username, password, jobRole, UserRole, StaffSkillsArrayList);
            staffRepository.addStaffSubmit(staff);
    }

    private static Staff createStaffFromParams(String firstName, String surname, String username, String password, String jobRole, String UserRole, List<StaffSkills> StaffSkillsArrayList) {
        return new Staff(jobRole, firstName, surname, username, password, UserRole, StaffSkillsArrayList);
    }

    public void deleteStaff(String StaffDetails) {
        staffRepository.deleteStaff(StaffDetails);
    }
}
