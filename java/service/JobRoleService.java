package service;

import models.Role;
import repositories.JobRoleRepository;

import java.util.List;

public class JobRoleService {
    private final JobRoleRepository jobRoleRepository;
    public JobRoleService(JobRoleRepository jobRoleRepository){
        this.jobRoleRepository = jobRoleRepository;
    }

    public List<Role> allRoles() {
        return this.jobRoleRepository.getAllJobRoles();
    }
}
