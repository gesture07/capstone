package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    data selecteddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSelectedData();

        setValues();
    }

    private void setValues() {

        TextView tv = findViewById(R.id.data_name);

        tv.setText(selecteddata.getName());
    }

    private void getSelectedData(){
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        selecteddata = MainActivity.dataList.get(Integer.valueOf(id));
    }
}