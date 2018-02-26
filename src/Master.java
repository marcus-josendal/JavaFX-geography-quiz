import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
import javafx.application.Application;

public class Master {

    //Re-occuring variables
    String name = "";
    String answer = "";
    String answer2 = "";
    String answer3 = "";
    Scanner scanner = new Scanner(System.in);
    Questions question = new Questions();

    public Master() {
        Application.launch(Window.class);
        startGame();
    }

    private void startGame() {
        System.out.print("Vennligst skriv inn ditt navn: ");
        name = scanner.nextLine();
        System.out.println("Hei " + name + ". Du har tre liv, og mister et for hver gang du svarer feil på et spørsmål.");

        //Adds a small pause so user can finish reading sentence
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("Noe feil skjedde");
        }

        boolean run = false;

        //Start game
        while (!run) {

            System.out.println("La oss starte med noe enkelt. Hva er hovedstaden i Spania?");
            question.question1(answer);
            answer = scanner.nextLine();


            if (question.question1(answer)) {
                System.out.println("Du svarte riktig. Din score er: " + question.getScore());
            } else {
                System.out.println("Du svarte feil, svaret er Madrid. Du mista nå ett liv, du har " + question.getLife() + " igjen.");
            }

            //Creates a small pause between questions
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println("Noe feil skjedde");
            }

            System.out.println("Vi holder det enkelt. Hvilke land ligger Norge ved siden av?");

            System.out.print("Første land: ");
            answer = scanner.nextLine();
            System.out.print("Andre land: ");
            answer2 = scanner.nextLine();
            System.out.print("Tredje land: ");
            answer3 = scanner.nextLine();

            question.question2(answer, answer2, answer3);
        }
    }
}

