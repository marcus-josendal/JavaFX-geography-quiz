import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Builder {
    public Builder() {

    }

    //Return Hbox with buttons specified in the returnButtons method
    public HBox returnHBox(ArrayList<Button> buttonArray, Pos position, double setSpacing, int padding){
        HBox hbox = new HBox();

        for(Button aButtonArray : buttonArray) {
            hbox.getChildren().add(aButtonArray);
        }

        hbox.setSpacing(setSpacing);
        hbox.setPadding(new Insets(padding));
        hbox.setAlignment(position);
        return hbox;
    }

    //Returns an ArrayList with button, which can be used by other Methods
    public ArrayList<Button> returnButtons(int numberOfButtons, int buttonWidth, int buttonHeight) {
        ArrayList<Button> buttonArray = new ArrayList<>();

        for (int i = 0; i < numberOfButtons; i++) {
            Button button = new Button();
            button.setPrefSize(buttonWidth, buttonHeight);
            buttonArray.add(button);
        }
        return buttonArray;
    }


    //Return text
    public Text returnText(String content, String font, int fontsize, Color color, TextAlignment textposition){
        Text text = new Text(content);
        text.setFont(new Font(font, fontsize));
        text.setFill(color);
        text.setTextAlignment(textposition);

        return text;
    }

    public HBox returnQuestion(String questionText) {
        HBox hbox = new HBox();
        Text text = returnText(questionText, "Arial", 35, Color.WHITE, TextAlignment.CENTER);

        hbox.getChildren().add(text);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }
}




