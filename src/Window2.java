import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Window2 extends Application {
    public Window2(){

    }

    public void start(Stage secondStage){
        BorderPane example = new BorderPane();
        HBox hbox = addHBox(3, 30);


        example.setCenter(hbox);
        secondStage.setScene(new Scene(example, 500, 500));
        secondStage.show();
    }

    private HBox addHBox(int numberOfButtons, int spacingBetweenButtons){
        HBox hbox = new HBox();
        //hbox.setPadding(new Insets(15 ,12 ,15 ,12));
        hbox.setSpacing(spacingBetweenButtons);
        hbox.setAlignment(Pos.CENTER);

        ArrayList<Button> myArray = new ArrayList<>();

        for(int i = 0; i < numberOfButtons ; i++){
            Button button = new Button();
            myArray.add(button);
            hbox.getChildren().add(button);
        }

        return hbox;
    }


}


