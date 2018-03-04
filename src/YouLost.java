import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class YouLost extends Application {
    public void start(Stage losingStage){

        Text losingText = Builder.instance.returnText("Du tapte, better luck next time!", "Arial", 25, Color.WHITE, TextAlignment.CENTER);

        BorderPane border = new BorderPane();
        border.setCenter(losingText);
        border.setStyle("-fx-background-color: #336699;");

        losingStage.setScene(new Scene(border, 600, 300));
        losingStage.setResizable(false);
        losingStage.show();
    }
}

