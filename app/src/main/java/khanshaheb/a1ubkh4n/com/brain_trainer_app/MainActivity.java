package khanshaheb.a1ubkh4n.com.brain_trainer_app;

import android.os.CountDownTimer;
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
    Button button;
    Button button2;
    Button button3;
    Button button4;
    TextView sumTextView;
    TextView resultTextView;
    TextView pointsTextView;
    TextView timerTextView;


    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void generateQuestions() {

        Random rand = new Random();

        int a = rand.nextInt(31);
        int b = rand.nextInt(31);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        Log.i("locationOfCorrectAnswer", Integer.toString(locationOfCorrectAnswer));

        int incorrectAnswers;

        for (int i = 0; i < 4; i++) {

            if (i == locationOfCorrectAnswer) {

                // if locationOfCorrectAnswer is equal to i value then Add the actual a+b in answers

                answers.add(a + b);
                Log.i("Answer", Integer.toString(a + b));

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        pointsTextView = (TextView) findViewById(R.id.pointTextView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

        generateQuestions();

        new CountDownTimer(3100, 1000) {
            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {

                resultTextView.setText("Done!");

            }
        }.start();

    }

    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);

    }

    public void chooseAnswer(View view) {

        Log.i("Tag", (String) view.getTag());

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

            Log.i("Correct", "Correct!");

            score++;
            resultTextView.setText("Correct!");

        } else {

            resultTextView.setText("Wrong!");
        }

        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestions();

    }
}
