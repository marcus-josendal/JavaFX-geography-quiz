import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Window2 extends Window{
    public Window2(){

    }

    public void start(Stage secondStage){
        BorderPane example = new BorderPane();
        HBox hbox = new HBox();
        //hbox.getChildren().add(lifes);
        example.setCenter(example);

        secondStage.setScene(new Scene(example, 500, 500));
        secondStage.show();
    }
}
