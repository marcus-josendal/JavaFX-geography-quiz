import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Window2 extends Application {

    public Window2(){

    }

    public void start(Stage secondStage) {
        //Question
        HBox questionBox = Builder.instance.returnQuestion("Hvor mange fylker er det i Norge?");

        //Button answer-options
        ArrayList<Button> buttonArray = Builder.instance.returnButtons(4, 90, 20);
        for(int i = 0; i < buttonArray.size(); i++){
            buttonArray.get(i).setText(String.valueOf(16 + i));
        }
        HBox buttonHolder = Builder.instance.returnHBox(buttonArray, Pos.CENTER, 30, 15);
        HBox test = Builder.instance.returnLifeHolder();
        VBox centerBox = new VBox();
        centerBox.getChildren().add(buttonHolder);
        centerBox.getChildren().add(test);

        BorderPane example = new BorderPane();
        example.setCenter(centerBox);
        example.setTop(questionBox);
        example.setStyle("-fx-background-color: #336699;");

        secondStage.setScene(new Scene(example, 600, 300));
        secondStage.show();
    }
}
