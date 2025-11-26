package models;

public class Role {
    private String role;

    public Role(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

//    public void setRole(String role){
//        this.role=role;
//    }

    public String toString(){
        return String.format("%s", this.role);
    }
}
