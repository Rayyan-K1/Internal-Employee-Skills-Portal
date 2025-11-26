package globals;

import models.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffCollaborator {
    public static List<Staff> populateStaff() {
        List<Staff> staff = new ArrayList<>();
        staff.add(new Staff("Junior Developer", "admin", "istrator", "admin", "admin", "Manager", null));
        staff.add(new Staff("Junior Developer", "computer", "phile", "user", "user", "User", null));
        return staff;
    }

}