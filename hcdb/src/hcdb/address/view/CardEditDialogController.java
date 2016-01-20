package hcdb.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import hcdb.address.model.Card;



public class CardEditDialogController {

    @FXML
    private TextField playerNameField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField seriesField;
    @FXML
    private TextField seasonField;
    @FXML
    private TextField valueField;
    @FXML
    private CheckBox rookieField;
    @FXML
    private CheckBox autographField;
    @FXML
    private CheckBox jerseyField;
    @FXML
    private CheckBox equipmentField;

    private Stage dialogStage;
    private Card card;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setCard(Card card) {
        this.card = card;

        playerNameField.setText(card.getplayerName());
        companyField.setText(card.getCompany());
        seriesField.setText(card.getSeries());
        seasonField.setText(Integer.toString(card.getSeason()));
        valueField.setText(Integer.toString(card.getValue()));
        rookieField.setSelected(card.getRookie());
    	String memorabilia = card.getMemorabilia();
    	autographField.setSelected(false);
    	jerseyField.setSelected(false);
    	equipmentField.setSelected(false);
    	if (memorabilia == "Autograph, Jersey, Equipment") {
        	autographField.setSelected(true);
        	jerseyField.setSelected(true);
        	equipmentField.setSelected(true);
    	}
    	else if (memorabilia == "Autograph, Jersey") {
    		autographField.setSelected(true);
        	jerseyField.setSelected(true);
    	}
    	else if (memorabilia == "Autograph, Equipment") {
    		autographField.setSelected(true);
        	equipmentField.setSelected(true);
		}
    	else if (memorabilia == "Jersey, Equipment") {
    		jerseyField.setSelected(true);
        	equipmentField.setSelected(true);
    	}
    	else if (memorabilia == "Autograph") {
    		autographField.setSelected(true);
    	}
    	else if (memorabilia == "Jersey") {
    		jerseyField.setSelected(true);
    	}
    	else if (memorabilia == "Equipment") {
    		equipmentField.setSelected(true);
    	}
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            card.setPlayerName(playerNameField.getText());
            card.setCompany(companyField.getText());
            card.setSeries(seriesField.getText());
            card.setSeason(Integer.parseInt(seasonField.getText()));
            card.setValue(Integer.parseInt(valueField.getText()));
            card.setRookie(rookieField.isSelected());
            // autograph, jersey, equipment
            String memorabilia = "";
            boolean autograph = autographField.isSelected();
            boolean jersey = jerseyField.isSelected();
            boolean equipment = equipmentField.isSelected();
	    	if (autograph && jersey && equipment) {
	    		memorabilia = "Autograph, Jersey, Equipment";
	    	}
	    	else if (autograph && jersey && !equipment) {
	    		memorabilia = "Autograph, Jersey";
	    	}
	    	else if (autograph && !jersey && equipment) {
	    		memorabilia = "Autograph, Equipment";
			}
	    	else if (!autograph && jersey && equipment) {
	    		memorabilia = "Jersey, Equipment";
	    	}
	    	else if (autograph && !jersey && !equipment) {
	    		memorabilia = "Autograph";
	    	}
	    	else if (!autograph && jersey && !equipment) {
	    		memorabilia = "Jersey";
	    	}
	    	else if (!autograph && !jersey && equipment) {
	    		memorabilia = "Equipment";
	    	}
	    	else {
	    		memorabilia = "None";
	    	}
            card.setMemorabilia(memorabilia);
            

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (playerNameField.getText() == null || playerNameField.getText().length() == 0) {
            errorMessage += "No valid player name!\n"; 
        }
        if (companyField.getText() == null || companyField.getText().length() == 0) {
            errorMessage += "No valid company name!\n"; 
        }
        if (seriesField.getText() == null || seriesField.getText().length() == 0) {
            errorMessage += "No series entered!\n"; 
        }

        //season, value

        if (seasonField.getText() == null || seasonField.getText().length() == 0) {
            errorMessage += "No season entered!\n"; 
        } else {
            try {
                Integer.parseInt(seasonField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid season entered (must be an integer)!\n"; 
            }
        }
        
        if (valueField.getText() == null || valueField.getText().length() == 0) {
            errorMessage += "No value entered!\n"; 
        } else {
            try {
                Integer.parseInt(valueField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid season entered (must be an integer)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}