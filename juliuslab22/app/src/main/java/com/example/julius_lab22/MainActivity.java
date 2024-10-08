package com.example.julius_lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView jokeListTitle, jokeTitle, jokeSetup, jokePunchline;
    private Button backJokeButton, nextJokeButton;
    private int currentJokeIndex = 0;


    private String[][] jokes = {
            {"Why did the coffee file a police report? It got mugged."},
            {"What do you call a fish wearing a bowtie? Sofishticated."},
            {"How do you organize a space party? You planet."},
            {"Why don’t eggs tell jokes? They’d crack each other up."},
            {"What do you call a can opener that doesn’t work? A can’t opener."},
            {"Why did the golfer bring two pairs of pants? In case he got a hole in one."},
            {"WWhat do you call a snowman with a six-pack? An abdominal snowman."},
            {"Why did the tomato turn red? Because it saw the salad dressing."},
            {"How does a vampire start a letter? Tomb it may concern."},
            {"Why did the math teacher take off her glasses? Because she couldn’t see any more problems."}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);


        jokeListTitle = findViewById(R.id.jokeList);
        jokeTitle = findViewById(R.id.jokeTitle);
        jokeSetup = findViewById(R.id.jokeSetup);
        jokePunchline = findViewById(R.id.jokePunchline);
        backJokeButton = findViewById(R.id.backJokeButton);
        nextJokeButton = findViewById(R.id.nextJokeButton);


        jokeListTitle.setText("Joke List");
        displayJoke(currentJokeIndex);


        nextJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentJokeIndex++;
                displayJoke(currentJokeIndex);
            }
        });


        backJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentJokeIndex--;
                displayJoke(currentJokeIndex);
            }
        });
    }


    private void displayJoke(int index) {
        jokeTitle.setText(jokes[index][0]);
        jokeSetup.setText(jokes[index][1]);
        jokePunchline.setText(jokes[index][2]);


        if (index == 0) {
            backJokeButton.setVisibility(View.INVISIBLE);
        } else {
            backJokeButton.setVisibility(View.VISIBLE);
        }

        if (index == jokes.length - 1) {
            nextJokeButton.setVisibility(View.INVISIBLE);
        } else {
            nextJokeButton.setVisibility(View.VISIBLE);
        }
    }
}