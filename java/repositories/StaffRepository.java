package repositories;

import globals.FakeDatabase;
import models.Staff;

import java.util.List;
import java.util.UUID;

public class StaffRepository {
    private static FakeDatabase fakeDatabase;

    public StaffRepository(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
    }

    public static List<Staff> getAllStaff(String State){
        return fakeDatabase.getStaff(State);
    }
    public List<Staff> deleteSpecificStaff(String StaffDetails) {
        int index = fakeDatabase.deleteStaff(StaffDetails);
        getAllStaff("All").remove(index);
        return getAllStaff("All");
    }

    public static void addStaffSubmit(Staff staff){
        getAllStaff("All").add(staff);
    }
    public static void editStaffSubmit(Staff staff, UUID id){
        List<Staff> allStaff = getAllStaff("All");
        System.out.println(allStaff);
        for (Staff role: allStaff) {
            String[] staffHolder = role.toString().split(" ");
            if(staffHolder[0].equals(id.toString())) {
                getAllStaff("All").remove(role);
                getAllStaff("All").add(staff);
            }
        }
        System.out.println(getAllStaff("All"));
    }
    public void deleteStaff(String StaffDetails) {
        deleteSpecificStaff(StaffDetails);
    }
    }

