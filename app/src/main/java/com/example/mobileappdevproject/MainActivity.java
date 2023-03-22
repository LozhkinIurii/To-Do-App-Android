package com.example.mobileappdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
    }

    public void showTask(View view){
        String url = "https://dummyjson.com/todos";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            response -> {
                parseJsonAndUpdateUI(response);
            }, error -> {
                Log.d("ERROR", error.toString());
            });
        queue.add(stringRequest);
    }

    private void parseJsonAndUpdateUI(String response){
        try {
            Random rand = new Random();
            int objId = rand.nextInt(30);
            JSONObject taskResponse = new JSONObject(response);
            String task = taskResponse.getJSONArray("todos").getJSONObject(objId).getString("todo");
            Intent taskIntent = new Intent(this, TaskScreen.class);
            taskIntent.putExtra("TASK", task);
            startActivity(taskIntent);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}