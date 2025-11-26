package repositories;

import globals.FakeDatabase;
import models.Role;
import models.Staff;

import java.util.List;

public class JobRoleRepository {
    private final FakeDatabase fakeDatabase;

    public JobRoleRepository(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
    }

    public List<Role> getAllJobRoles(){
        return this.fakeDatabase.getAllJobRoles();
    }
}
