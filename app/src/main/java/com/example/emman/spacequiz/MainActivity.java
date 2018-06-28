package com.example.emman.spacequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This Method is called when the Get Started button is clicked
     * it collects name text and starts new intent
     * @param view
     */
    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        Bundle bundle = new Bundle();
        EditText editText = findViewById(R.id.name_text);
        String nameText = editText.getText().toString();
        bundle.putString("text", nameText );
        intent.putExtras(bundle);

        if(TextUtils.isEmpty(editText.getText())) {
            editText.setError( "Required!" );
        } else if  (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
