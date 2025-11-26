package routers;

public enum RouteNames {
    HOME("FXMLMain.fxml"),
    MANAGER_LOGIN("RootLoginPage.fxml"),
    STAFF_LOGIN("StaffLogIn.fxml"),
    MANAGER_MAIN_MENU("ManagerLandingPage.fxml"),
    STAFF_MAIN_MENU("StaffMainMenu.fxml"),
    VIEW_EDIT_STAFF("ManagerViewEditStaff.fxml"),
    ADD_STAFF("AddStaff.fxml"),
    VIEW_EDIT_SKILLS("ManagerViewEditSkills.fxml"),
    ADD_SKILL("AddSkills.fxml"),
    STAFF_DETAILS("StaffViewEditDetails.fxml"),
    STAFF_SKILLS("StaffViewEditSkills.fxml");

    public final String location;
    private final String VIEW_PATH = "/views/";

    RouteNames(String location) {
        this.location = VIEW_PATH + location;
    }
}
