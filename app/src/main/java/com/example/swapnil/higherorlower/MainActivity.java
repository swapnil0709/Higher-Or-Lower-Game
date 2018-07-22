package com.example.swapnil.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;

    }

    public void guess(View view) {
        Log.i("info", "button pressed");
        EditText editText = (EditText) findViewById(R.id.editText);
        String str = editText.getText().toString();
        if (str.isEmpty()) {
            Toast.makeText(this, "Please Enter Some Value", Toast.LENGTH_SHORT).show();
        } else {
            int guess = Integer.parseInt(str);
            String message;
            if (guess > randomNumber) {
                message = "lower!";
            } else if (guess < randomNumber) {
                message = "higher!";
            } else {
                message = "You Got It Right! You can Play Again";
                generateRandomNumber();
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
        Toast.makeText(this, "Welcome to Higher or Lower Game", Toast.LENGTH_LONG).show();
    }
}
