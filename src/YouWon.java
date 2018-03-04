import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class YouWon extends Application {
    public void start(Stage winningStage){

        Text winningText = Builder.instance.returnText("Du vant, gratulerer!", "Arial", 25, Color.WHITE, TextAlignment.CENTER);

        BorderPane border = new BorderPane();
        border.setCenter(winningText);
        border.setStyle("-fx-background-color: #336699;");

        winningStage.setScene(new Scene(border, 600, 300));
        winningStage.setResizable(false);
        winningStage.show();
    }
}
