package com.example.mobileappdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TaskScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_screen);
        Intent intent = getIntent();
        String task = intent.getStringExtra("TASK");
        TextView setTask = findViewById(R.id.task);
        setTask.setText(task);
    }

    public void goBack(View view){
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }

    public void translate(View view) {
        String url = "https://translate.google.ru/?hl=ru&tab=wT&sl=en&tl=ru&op=translate";
        Uri uri = Uri.parse(url);
        Intent goWeb = new Intent(Intent.ACTION_VIEW, uri);
        try{
            startActivity(goWeb);
        } catch (ActivityNotFoundException e){

        }
    }
}