import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Window2 extends Application {
    private Builder builder = new Builder();

    public Window2(){

    }

    public void start(Stage secondStage) {
        ArrayList<Button> buttonArray = builder.returnButtons(3, 100, 20);
        HBox buttonHolder = builder.returnHBox(buttonArray, Pos.CENTER, 30, 15);

        BorderPane example = new BorderPane();
        example.setCenter(buttonHolder);
        example.setStyle("-fx-background-color: #336699;");

        secondStage.setScene(new Scene(example, 500, 500));
        secondStage.show();
    }
}
