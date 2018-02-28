import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.stream.IntStream;


public class Window extends Application {
    private Button nextQuestion = new Button("Neste spørsmål");
    private ArrayList<ImageView> lifes = new ArrayList<>();
    private Builder builder = new Builder();
    private Window2 window_2 = new Window2();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Trykk på riktig svar!");

        //Question
        HBox questionBox = builder.returnQuestion("Hvor mange fylker er det i Norge?");

        //Creates new VBoX for bottom text
        HBox alignTextBoxBottom = new HBox();

        //Creates Text and aligning text writing box
        Text descriptionTextBottom = builder.returnText("", "Arial", 25, Color.WHITE, TextAlignment.CENTER);
        descriptionTextBottom.setOpacity(1);
        nextQuestion.setOpacity(0);
        alignTextBoxBottom.getChildren().add(nextQuestion);

        HBox bottomBox = new HBox();
        bottomBox.setPrefWidth(600);
        bottomBox.getChildren().add(descriptionTextBottom);
        bottomBox.getChildren().add(nextQuestion);

        //Adds three hearts
        Image heart = new Image("file:assets\\heart.png");
        HBox lifeHolder = new HBox();
        lifeHolder.setAlignment(Pos.CENTER);

        for(int i = 0; i < 3 ; i++){
            lifes.add(new ImageView(heart));
            lifes.get(i).setFitHeight(65);
            lifes.get(i).setFitWidth(65);
            lifeHolder.getChildren().add(lifes.get(i));
        }

        //Adds answer-options to the questions
        ArrayList<Button> buttonArray = builder.returnButtons(3, 100, 20);
        buttonArray.get(0).setText("Bankok");
        buttonArray.get(1).setText("Seoul");
        buttonArray.get(2).setText("Tokyo");
        HBox hbox = builder.returnHBox(buttonArray, Pos.CENTER, 30, 15);
        hbox.setPadding(new Insets(15 ,12 ,15 ,12));

        //Vbox with answer-options and player health
        VBox mainVbox = new VBox();
        mainVbox.getChildren().add(hbox);
        mainVbox.getChildren().add(lifeHolder);
        mainVbox.setAlignment(Pos.CENTER);

        //Sets the different elements in the borderpane
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color: #336699;");
        border.setCenter(mainVbox);
        border.setTop(questionBox);
        border.setBottom(bottomBox);


        //Add Eventhandlers for buttons
        buttonArray.get(0).setOnAction(event -> {
            //Sets output depending on what button user clicked on and makes it visible
            descriptionTextBottom.setText("Dette svaret er riktig!");
            descriptionTextBottom.setOpacity(1);
            //Sets spacing
            bottomBox.setSpacing(255);
            border.setBottom(bottomBox);
            //Disables buttons
            IntStream.range(0, buttonArray.size()).forEach(i -> buttonArray.get(i).setDisable(true));

            nextQuestion.setOpacity(1);
            nextQuestion.setOnAction(event12 -> {
                primaryStage.close();
                window_2.start(new Stage());
            });
        });

        EventHandler ev = event -> {
            descriptionTextBottom.setText("Dette svaret er feil!");
            descriptionTextBottom.setOpacity(1);
            border.setBottom(bottomBox);
            bottomBox.setSpacing(278);
            lifeHolder.getChildren().remove(0);

            IntStream.range(0, buttonArray.size()).forEach(i -> buttonArray.get(i).setDisable(true));

            nextQuestion.setOpacity(1);
            nextQuestion.setOnAction(event1 -> {
                primaryStage.close();
                window_2.start(new Stage());
            });
        };

        buttonArray.get(1).setOnAction(ev);
        buttonArray.get(2).setOnAction(ev);

        //Show scene
        primaryStage.setScene(new Scene(border, 600, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public ArrayList<ImageView> returnHealth(){
        return lifes;
    }
}
