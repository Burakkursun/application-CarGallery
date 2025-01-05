package com.example.a20230305501;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookingActivity extends AppCompatActivity {

    private Button rentButton;
    private boolean isTimerRunning = false;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 24 * 60 * 60 * 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        rentButton = findViewById(R.id.rentButton);

        ImageView imageCar = findViewById(R.id.imageCar);
        imageCar.setImageResource(R.drawable.vito);

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTimerRunning) {
                    Toast.makeText(BookingActivity.this, "Vehicle Rental Started", Toast.LENGTH_SHORT).show();
                    rentButton.setText("Remaining Time");
                    startTimer();
                }
            }
        });
    }
    private void startTimer() {
        isTimerRunning = true;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateButtonText();
            }

            @Override
            public void onFinish() {
                rentButton.setText("Time is Up");
                isTimerRunning = false;
            }
        }.start();
    }
    private void updateButtonText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        rentButton.setText(timeLeftFormatted);
    }
}