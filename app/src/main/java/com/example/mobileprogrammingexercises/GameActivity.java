package com.example.mobileprogrammingexercises;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    ImageView computerImageview, resultImageView;
    ImageButton scissorsImageButton, rockImageButton, paperImageButton;

    private void initComponents() {
        computerImageview = findViewById(R.id.computerImageview);
        resultImageView = findViewById(R.id.resultImageView);
        scissorsImageButton = findViewById(R.id.scissorsImageButton);
        rockImageButton = findViewById(R.id.rockImageButton);
        paperImageButton = findViewById(R.id.paperImageButton);
    }

    private void initListener() {
        scissorsImageButton.setOnClickListener(startGame("SCISSORS"));
        rockImageButton.setOnClickListener(startGame("ROCK"));
        paperImageButton.setOnClickListener(startGame("PAPER"));
    }

    private View.OnClickListener startGame(String option) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String computerOption = Game.pickRandomOption();
                computerImageview.setImageResource(Game.pickDrawable(computerOption));

                if (Game.isDraw(option, computerOption)) {
                    resultImageView.setImageResource(R.drawable.draw);
                } else if (Game.isWin(option, computerOption)) {
                    resultImageView.setImageResource(R.drawable.win);
                } else {
                    resultImageView.setImageResource(R.drawable.lose);
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();
        initListener();
    }
}