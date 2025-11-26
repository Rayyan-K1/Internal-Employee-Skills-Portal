package globals;

import models.Skill;
import repositories.JobRoleRepository;
import repositories.SkillRepository;
import repositories.StaffRepository;
import repositories.StaffSkillRepository;

public class DependencyContainer {
    private static SkillRepository skillRepository;
    private static StaffRepository staffRepository;
    private static JobRoleRepository jobRoleRepository;
    private static StaffSkillRepository staffSkillRepository;

    public DependencyContainer(SkillRepository skillRepository, StaffRepository staffRepository, JobRoleRepository jobRoleRepository, StaffSkillRepository staffSkillRepository){
        this.staffRepository = staffRepository;
        this.skillRepository = skillRepository;
        this.jobRoleRepository = jobRoleRepository;
        this.staffSkillRepository = staffSkillRepository;
    }
    public static final SkillRepository getSkillRepository(){
        return skillRepository;
    }
    public static final StaffRepository getStaffRepository() { return staffRepository; }
    public static final JobRoleRepository getJobRoleRepository() { return jobRoleRepository; }
    public static final StaffSkillRepository getStaffSkillRepository() { return staffSkillRepository; }
}
