import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Window2 {
    public Window2(){

    }

    public void start1(Stage secondStage){
        BorderPane example = new BorderPane();
        HBox hbox = new HBox();

        secondStage.setScene(new Scene(example, 500, 500));
        secondStage.show();
    }
}
