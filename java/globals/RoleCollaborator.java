package globals;

import models.Role;
import models.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleCollaborator {
    public static List<Role> populateRole(){
        List<Role> role = new ArrayList<>();
        role.add(new Role("Junior Developer"));
        role.add(new Role("Mid-Level Developer"));
        role.add(new Role("Senior Developer"));
        return role;
    }
}
