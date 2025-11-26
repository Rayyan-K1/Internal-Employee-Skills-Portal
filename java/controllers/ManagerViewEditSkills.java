package controllers;

import globals.DependencyContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Skill;
import models.SkillStrength;
import service.SkillService;

import java.time.LocalDate;

import static javax.swing.JOptionPane.showMessageDialog;

public class ManagerViewEditSkills extends AddSkills {
    @FXML
    private ListView ViewEditSkills;
    @FXML
    private Button SaveEditedSkill;
    @FXML
    private Button EditSkills;
    @FXML
    private TextField SkillDescription;
    @FXML
    private TextField SkillCategory;
    @FXML
    private ChoiceBox SkillStrengthLevel;
    @FXML
    private DatePicker ExpiryDate;

    private SkillService SkillServiceObj = new SkillService(DependencyContainer.getSkillRepository());

        public void initialize() {
            this.showList();
        }
        private void showList() {
            ObservableList SkillsServiceItems = FXCollections.observableArrayList(this.SkillServiceObj.allSkills());
            this.ViewEditSkills.setItems(SkillsServiceItems);
            this.ViewEditSkills.refresh();
            SkillStrengthLevel.getItems().setAll(SkillStrength.values());
        }
        @FXML
        private void DeleteSkill() {
            Object SelectedSkill = null;
            try {
                SelectedSkill = this.ViewEditSkills.getSelectionModel().getSelectedItem();
            } catch (NullPointerException e) {
                showMessageDialog(null, "Please select a skill");
            }
            if(SelectedSkill == null) {
                showMessageDialog(null, "Please select a skill");
            } else {
                SkillServiceObj.deleteSkill(SelectedSkill);
                this.showList();
                this.SkillDescription.clear();
                this.SkillCategory.clear();
                this.SkillStrengthLevel.getSelectionModel().clearSelection();
            }
        }
        @FXML
        private void selectItem() {
            Skill SelectedSkill = (Skill) this.ViewEditSkills.getSelectionModel().getSelectedItem();
            this.SkillDescription.setText(SelectedSkill.getDescription());
            this.SkillCategory.setText(SelectedSkill.getCategory());
            this.ExpiryDate.setValue(SelectedSkill.getExpiryDate());
            switch(SelectedSkill.getSkillStrength()) {
                case None:
                    this.SkillStrengthLevel.getSelectionModel().select(0);
                    break;
                case Basic:
                    this.SkillStrengthLevel.getSelectionModel().select(1);
                    break;
                case Advanced:
                    this.SkillStrengthLevel.getSelectionModel().select(2);
                    break;
                case ExpertTrainer:
                    this.SkillStrengthLevel.getSelectionModel().select(3);
                    break;
                default:
                    this.SkillStrengthLevel.getSelectionModel().select(0);
            }
        }
        @FXML
        private void EditSkill() {
            Skill SelectedSkill = null;
            try {
                SelectedSkill = (Skill) this.ViewEditSkills.getSelectionModel().getSelectedItem();
            } catch (NullPointerException e) {
                showMessageDialog(null, "Please select a skill");
            }
            if(SelectedSkill == null) {
                showMessageDialog(null, "Please select a skill");
            } else {
                this.EditSkills.setDisable(true);
                this.SaveEditedSkill.setDisable(false);
                this.SkillDescription.setDisable(false);
                this.SkillCategory.setDisable(false);
                this.ExpiryDate.setDisable(false);
                this.SkillStrengthLevel.setDisable(false);
            }
        }
        @FXML
        private void SubmitEditedSkill() {
            Skill SelectedSkill = null;
            String Description = null;
            String Category = null;
            LocalDate ExpiryDate = null;
            SkillStrength ChosenSkillStrength = null;
            try {
                SelectedSkill = (Skill) this.ViewEditSkills.getSelectionModel().getSelectedItem();
                Description = this.SkillDescription.getText();
                Category = this.SkillCategory.getText();
                ExpiryDate = this.ExpiryDate.getValue();
                ChosenSkillStrength = (SkillStrength) this.SkillStrengthLevel.getValue();
            } catch(NullPointerException e) {
                showMessageDialog(null, "Please select a skill");
            }
            if(SelectedSkill == null) {
                showMessageDialog(null, "Please select a skill");
            } else if(Description.length() == 0 || Category.length() == 0 || ExpiryDate == null || ChosenSkillStrength == null) {
                showMessageDialog(null, "Please Complete All Fields");
            } else {
                SelectedSkill.setDescription(Description);
                SelectedSkill.setCategory(Category);
                SelectedSkill.setExpiryDate(ExpiryDate);
                SelectedSkill.setSkillStrength(ChosenSkillStrength);
                this.showList();
                this.SkillDescription.setDisable(true);
                this.SkillCategory.setDisable(true);
                this.ExpiryDate.setDisable(true);
                this.SkillStrengthLevel.setDisable(true);
                this.EditSkills.setDisable(false);
                this.SaveEditedSkill.setDisable(true);
            }
        }
    }

