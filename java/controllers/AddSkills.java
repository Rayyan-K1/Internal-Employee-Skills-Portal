package controllers;

import globals.DependencyContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.SkillCategory;
import models.SkillStrength;
import service.SkillService;

import java.io.IOException;
import java.time.LocalDate;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddSkills {
    @FXML
    private TextField Description;
    @FXML
    private ComboBox SkillCategoryList;
    @FXML
    private ComboBox SkillStrengthList;

    private SkillService SkillServiceObj = new SkillService(DependencyContainer.getSkillRepository());

    public void initialize() {
        this.SkillStrengthList.getItems().setAll(SkillStrength.values());
        this.SkillCategoryList.getItems().setAll(SkillCategory.values());
    }
    @FXML
    private void AddSkillToDB(ActionEvent event) throws IOException {
        String SkillName = null;
        String SkillCategoryChoice = null;
        SkillStrength SkillStrengthChoice = null;
        try {
            SkillName =this.Description.getText();
            SkillCategoryChoice = this.SkillCategoryList.getValue().toString();
            SkillStrengthChoice = (SkillStrength) this.SkillStrengthList.getValue();
        } catch (NullPointerException e) {
        }
        try {
            if (SkillName.length() == 0 || SkillCategoryChoice.length() == 0 || SkillStrengthChoice == null) {
                showMessageDialog(null, "Please Complete All Fields");
            } else {
                SkillServiceObj.addSkill(SkillName, SkillCategoryChoice, LocalDate.now(), SkillStrengthChoice);
                clearForm();
            }
        } catch (NullPointerException e) {
            showMessageDialog(null, "Please Complete All Fields");
        }
    }

    private void clearForm(){
        Description.clear();
        SkillCategoryList.setValue(null);
    }

    }

