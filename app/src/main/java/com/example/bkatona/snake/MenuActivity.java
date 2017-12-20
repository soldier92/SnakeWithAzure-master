package com.example.bkatona.snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void ExitOnClick(View view) {
        finish();
        System.exit(0);
    }

    public void StartNewGame(View view) {
        startActivity(new Intent(getApplicationContext(),SnakeActivity.class));
    }

    public void ShowScores(View view) {
        startActivity(new Intent(getApplicationContext(),ScoresActivity.class));
    }

    public void LogOutOnClick(View view) {
        finish();
    }
}
