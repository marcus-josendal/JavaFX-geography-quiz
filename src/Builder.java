import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Builder {
    public Builder() {

    }

    //Return
    HBox returnHBox(ArrayList<Button> buttonArray, Pos position, double setSpacing, int padding){
        HBox hbox = new HBox();

        for(Button aButtonArray : buttonArray) {
            hbox.getChildren().add(aButtonArray);
        }

        hbox.setSpacing(setSpacing);
        hbox.setPadding(new Insets(padding));
        hbox.setAlignment(position);
        return hbox;
    }

    ArrayList<Button> returnButtons(int numberOfButtons, int buttonWidth, int buttonHeight) {
        ArrayList<Button> buttonArray = new ArrayList<>();

        for (int i = 0; i < numberOfButtons; i++) {
            Button button = new Button();
            button.setPrefSize(buttonWidth, buttonHeight);
            buttonArray.add(button);
        }
        return buttonArray;
    }
}


