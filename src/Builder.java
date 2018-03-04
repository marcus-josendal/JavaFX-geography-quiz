import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Builder {

    ArrayList<ImageView> lifes = new ArrayList<>();
    HBox lifeHolder = new HBox();

    public static Builder instance;

    public Builder() {
        if(instance != null){
            return;
        }
        instance = this;
        initLife();
    }

    private  void initLife(){

        Image heart = new Image("file:assets\\heart.png");
        lifeHolder.setAlignment(Pos.CENTER);

        for(int i = 0; i < 3 ; i++){
            lifes.add(new ImageView(heart));
            lifes.get(i).setFitHeight(65);
            lifes.get(i).setFitWidth(65);
            lifeHolder.getChildren().add(lifes.get(i));
        }
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

    //Returns question text (only questions)
    public HBox returnQuestion(String questionText) {
        HBox hbox = new HBox();
        Text text = returnText(questionText, "Arial", 35, Color.WHITE, TextAlignment.CENTER);

        hbox.getChildren().add(text);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }
    //Returns HBox with lifes in it
    public HBox returnLifeHolder(){
        return lifeHolder;
    }

    public ArrayList<ImageView> returnLifes(){
        return lifes;
    }

}




