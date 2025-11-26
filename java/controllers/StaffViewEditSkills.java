package controllers;

import globals.DependencyContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.SkillStrength;
import models.Staff;
import models.StaffSkills;
import service.SkillService;
import service.StaffService;
import service.StaffSkillsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.swing.JOptionPane.showMessageDialog;

public class StaffViewEditSkills extends StaffLogInController {
    @FXML
    private ListView ListSkills;
    @FXML
    private TextField Skill;
    @FXML
    private TextField Description;
    @FXML
    private DatePicker ExpiryDate;
    @FXML
    private ChoiceBox SkillStrengthList;
    @FXML
    private ListView UserSkills;
    private List<StaffSkills> StaffSkillsArrayList;
    private List<StaffSkills> StaffSkillsHolder = new ArrayList<>();

    private StaffSkillsService staffSkillsObj = new StaffSkillsService(DependencyContainer.getStaffSkillRepository());
    private SkillService skillsObj = new SkillService(DependencyContainer.getSkillRepository());
    private StaffService staffObj = new StaffService(DependencyContainer.getStaffRepository());

    public void initialize() {
        this.showList();
    }

    private void showList() {
        ObservableList SkillsServiceItems = FXCollections.observableArrayList(this.skillsObj.allSkills());
        this.ListSkills.setItems(SkillsServiceItems);
        this.SkillStrengthList.getItems().setAll(SkillStrength.values());
        StaffLogInController staffLogInController = new StaffLogInController();
        Staff StaffData = staffLogInController.getLoggedInUser();
        this.StaffSkillsArrayList = StaffData.getStaffSkillsArray();
        try {
//            for (StaffSkills StaffSkill : this.StaffSkillsArrayList) {
//                this.UserSkills.getItems().add(StaffSkill);
//            }
        this.UserSkills.getItems().setAll(this.StaffSkillsArrayList);
        } catch (NullPointerException e) {

        }
    }
    @FXML
    private void selectListItemFromAllSkills() {
        models.Skill SelectedItem = (models.Skill) this.ListSkills.getSelectionModel().getSelectedItem();
        this.Skill.setText(SelectedItem.getCategory());
        this.Description.setText(SelectedItem.getDescription());
        this.ExpiryDate.setValue(SelectedItem.getExpiryDate());
        switch(SelectedItem.getSkillStrength()) {
            case None:
                this.SkillStrengthList.getSelectionModel().select(0);
                break;
            case Basic:
                this.SkillStrengthList.getSelectionModel().select(1);
                break;
            case Advanced:
                this.SkillStrengthList.getSelectionModel().select(2);
                break;
            case ExpertTrainer:
                this.SkillStrengthList.getSelectionModel().select(3);
                break;
            default:
                this.SkillStrengthList.getSelectionModel().select(0);
        }
    }
    @FXML
    private void returnSkillsArray() {
        String SkillChoice = null;
        String DescriptionChoice = null;
        String SkillStrengthLevel = null;
        LocalDate expiryDate = null;
        try {
            SkillChoice = this.Skill.getText();
            DescriptionChoice = this.Description.getText();
            SkillStrengthLevel = this.SkillStrengthList.getValue().toString();
            expiryDate = this.ExpiryDate.getValue();
        } catch(NullPointerException e) {

        }
            if(expiryDate == null || SkillStrengthLevel.length() == 0) {
                showMessageDialog(null, "Please Complete All Fields");
            } else {
                StaffSkills StaffSkillsObj = new StaffSkills(UUID.randomUUID(), SkillChoice, DescriptionChoice, SkillStrength.valueOf(SkillStrengthLevel), expiryDate);
                StaffSkillsHolder.add(StaffSkillsObj);
                this.StaffSkillsArrayList = StaffSkillsHolder;
                this.addSkillsToStaffMember();
            }
    }
    private void addSkillsToStaffMember() {
        String SkillStrength = this.SkillStrengthList.getValue().toString();
        LocalDate ExpiryDate = this.ExpiryDate.getValue();;
        StaffLogInController staffLogInController = new StaffLogInController();
        Staff StaffData = staffLogInController.getLoggedInUser();
        StaffData.setStaffSkillsArrayList(this.StaffSkillsArrayList);
        this.showList();
    }
    @FXML
    private void deleteListItem() {
        try {
        StaffSkills SelectedItem = (StaffSkills) this.UserSkills.getSelectionModel().getSelectedItem();
        this.StaffSkillsArrayList.remove(SelectedItem);
        this.showList();
        } catch (NullPointerException e) {
            showMessageDialog(null, "Please Select An Allocated Skill");
        }
    }
}
