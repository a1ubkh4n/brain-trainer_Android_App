package khanshaheb.a1ubkh4n.com.brain_trainer_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);

        TextView sumTextView = (TextView) findViewById(R.id.sumTextView);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        Random rand = new Random();

        int a = rand.nextInt(31);
        int b = rand.nextInt(31);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        Log.i("locationOfCorrectAnswer", Integer.toString(locationOfCorrectAnswer));

        int incorrectAnswers;

        for(int i=0; i<4; i++) {

            if(i == locationOfCorrectAnswer) {

                // if locationOfCorrectAnswer is equal to i value then Add the actual a+b in answers

                answers.add(a + b);
                Log.i("Answer", Integer.toString(a+b));

            } else {

                incorrectAnswers = rand.nextInt(61);

                Log.i("Incorrect Answer", Integer.toString(incorrectAnswers));

                while (incorrectAnswers == a + b) {

                    incorrectAnswers = rand.nextInt(61);
                }

                answers.add(incorrectAnswers);
            }
        }

        button.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));


    }


    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);

    }

    public void chooseAnswer(View view) {


    }
}
