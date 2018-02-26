
import java.util.ArrayList;

public class Questions {

    int score = 0;
    int life = 3;

    public Questions() {

    }

    public boolean question1(String answer) {

        //Question 1 mechanics
        if (answer.equals("Madrid") || answer.equals("madrid")) {
            score += 100;
            return true;
        } else {
            life--;
            return false;
        }
    }

    public void question2(String country1, String country2, String country3) {
        //Question 2 mechanics
        //Initiliazing one array with answer, and another with user inputs
        ArrayList<String> countries = new ArrayList<String>();
        ArrayList<String> userCountries = new ArrayList<String>();

        //Adds correct answers to Array
        countries.add("Sverige");
        countries.add("Russland");
        countries.add("Finland");

        //Adds user-input from Array
        userCountries.add(country1);
        userCountries.add(country2);
        userCountries.add(country3);

        //Compares answers with user-input. Counts for every correct answer.
        int count = 0;

        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < userCountries.size(); j++) {
                if (countries.get(i).equalsIgnoreCase(userCountries.get(j))) {
                    count++;
                }
            }
        }
        //Adds and prints score based on correct answers
        int scoreHolder2 = count * 100;
        score += scoreHolder2;
        System.out.println("Du hadde " + count + "/3 riktige. Dette ga deg " + scoreHolder2 + " poeng. Du har nå " + score + " poeng.");
    }

    public void question3(){

    }

    //Returns total score
    public int getScore() {
        return score;
    }

    public int getLife(){
        return life;
    }
}
