import javafx.application.Application;
import javafx.geometry.Insets;
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
import java.util.stream.IntStream;


public class Window extends Application {
    private Button nextQuestion = new Button("Neste spørsmål");
    private Window2 window_2 = new Window2();

    @Override
    public void start(Stage primaryStage) {
        new Builder();
        primaryStage.setTitle("Trykk på riktig svar!");

        //Question
        HBox questionBox = Builder.instance.returnQuestion("Hva er hovedstaden i Thailand?");

        //Creates new HBoX for bottom text
        HBox alignTextBoxBottom = new HBox();

        //Creates Text and aligning text writing box
        Text descriptionTextBottom = Builder.instance.returnText("", "Arial", 25, Color.WHITE, TextAlignment.CENTER);
        nextQuestion.setOpacity(0);
        alignTextBoxBottom.getChildren().add(nextQuestion);

        HBox bottomBox = new HBox();
        bottomBox.setPrefWidth(600);
        bottomBox.getChildren().add(descriptionTextBottom);
        bottomBox.getChildren().add(nextQuestion);

        //Adds three hearts
        HBox lifeHolder = Builder.instance.returnLifeHolder();
        lifeHolder.setAlignment(Pos.CENTER);

        //Adds answer-options to the questions
        ArrayList<Button> buttonArray = Builder.instance.returnButtons(3, 100, 20);
        buttonArray.get(0).setText("Bankok");
        buttonArray.get(1).setText("Seoul");
        buttonArray.get(2).setText("Tokyo");
        HBox hbox = Builder.instance.returnHBox(buttonArray, Pos.CENTER, 30, 15);
        //hbox.setPadding(new Insets(15, 12, 15, 12));

        //Vbox with answer-options and player health
        VBox mainVbox = new VBox();
        mainVbox.getChildren().add(hbox);
        mainVbox.getChildren().add(lifeHolder);
        mainVbox.setAlignment(Pos.CENTER);
        bottomBox.setPrefWidth(600);
        //Sets the different elements in the borderpane
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color: #336699;");
        border.setCenter(mainVbox);
        border.setTop(questionBox);
        border.setBottom(bottomBox);

        //Eventhandlers
        for (int i = 0; i < buttonArray.size(); i++)
            if (buttonArray.get(i) == buttonArray.get(0)) {
                buttonArray.get(i).setOnAction(event -> {
                    //Sets output depending on what button user clicked on and makes it visible
                    descriptionTextBottom.setText("Dette svaret er riktig!");
                    descriptionTextBottom.setOpacity(1);
                    //Sets spacing
                    bottomBox.setSpacing(255);
                    border.setBottom(bottomBox);
                    //Disables buttons
                    IntStream.range(0, buttonArray.size()).forEach(j -> buttonArray.get(j).setDisable(true));

                    nextQuestion.setOpacity(1);
                    nextQuestion.setOnAction(event12 -> {
                        primaryStage.close();
                        window_2.start(new Stage());
                    });
                });
            } else {
                buttonArray.get(i).setOnAction(event -> {
                    //Sets output depending on what button user clicked on and makes it visible
                    descriptionTextBottom.setText("Dette svaret er feil!");
                    descriptionTextBottom.setOpacity(1);
                    //Sets spacing (Yes, yes i know harcoding)
                    bottomBox.setSpacing(275);
                    border.setBottom(bottomBox);
                    //Disables buttons
                    IntStream.range(0, buttonArray.size()).forEach(j -> buttonArray.get(j).setDisable(true));
                    lifeHolder.getChildren().remove(0);

                    nextQuestion.setOpacity(1);
                    nextQuestion.setOnAction(event12 -> {
                        primaryStage.close();
                        window_2.start(new Stage());
                    });
                });
            }

        //Show scene
        primaryStage.setScene(new Scene(border, 600, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
