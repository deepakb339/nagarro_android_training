package org.nagarro.hellotoast;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button mResetButton;
    private Button mCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        Button mToastButton = findViewById(R.id.button_toast);
        mResetButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);

        mToastButton.setOnClickListener(view -> {
            Toast toast = Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT);
            toast.show();
        });

        mCountButton.setOnClickListener(view -> {
            mCount++;
            if (mShowCount != null) {
                mShowCount.setText(String.format(Locale.ENGLISH, "%d", mCount));
            }
            mResetButton.setBackgroundResource(R.color.purple_700);
            mResetButton.setClickable(true);

            switch (mCount % 2) {
                case 0:
                    mCountButton.setBackgroundResource(R.color.design_default_color_on_secondary);
                    break;
                case 1:
                    mCountButton.setBackgroundResource(R.color.black);
                    break;
                default:
                    break;
            }
        });

        mResetButton.setOnClickListener(view -> {
            mCount = 0;
            mShowCount.setText(String.valueOf(mCount));

            view.setClickable(false);
            view.setBackgroundColor(Color.GRAY);
            mCountButton.setBackgroundResource(R.color.purple_700);
        });
    }
}