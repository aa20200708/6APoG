package com.example.startapp012;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private float textSize = 18;
    private int textColor = BLACK;
    private int backgroundColor = 0xFFFFE4B5;

    private final int textColorDark = BLACK;
    private final int textColorLight = WHITE;
    private final int backgroundColorLight = 0xFFFFE4B5;
    private final int backgroundColorDark = BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView.setTextSize(textSize);
        textView.setTextColor(textColorDark);
        textView.setBackgroundColor(backgroundColorLight);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.font_up_setting:
                if (textSize < 14) {
                    textSize += 3;
                    textView.setTextSize(textSize);
                } else {
                    textSize *= 1.2;
                    textView.setTextSize(textSize);
                }
                break;

            case R.id.font_down_setting:
                if (textSize < 14) {
                    textSize -= 1.5;
                    textView.setTextSize(textSize);
                } else {
                    textSize /= 1.2;
                    textView.setTextSize(textSize);
                }
                break;

            case R.id.night_day_setting:
                textView.getCurrentTextColor();
                if (textColor == textColorDark && backgroundColor == backgroundColorLight) {
                    textView.setTextColor(textColorLight);
                    textColor = textColorLight;
                    textView.setBackgroundColor(backgroundColorDark);
                    backgroundColor = backgroundColorDark;
                } else {
                    textView.setTextColor(textColorDark);
                    textColor = textColorDark;
                    textView.setBackgroundColor(backgroundColorLight);
                    backgroundColor = backgroundColorLight;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}