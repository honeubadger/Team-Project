package com.byui.teamproject.records;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.byui.teamproject.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ShowRecords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

        ImageView reclogo = (ImageView) findViewById(R.id.logoImage7);
        reclogo.setImageResource(R.drawable.company_logo);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Next lines are test
        //This view should get the list entry from the database

        Employee_Example john = new Employee_Example("John Doe", "11/11/2021 9:04 AM", 1244);
        Employee_Example johnny = new Employee_Example("Johnny Doe", "09/11/2021 8:44 AM", 1286);
        Employee_Example lara = new Employee_Example("Lara Croft", "10/10/2021 10:11 AM", 2006);
        Employee_Example logan = new Employee_Example("Logan Paul", "12/12/2020 7:46 AM", 2020);
        Employee_Example gary = new Employee_Example("Gary Goodspeed", "07/11/2021 9:00 AM", 2318);


        Employee_Example[] employee = new Employee_Example[]{john, johnny, lara, logan, gary};

        ArrayAdapter<Employee_Example> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employee);

        ListView myView = (ListView) findViewById(R.id.employee_list);
        myView.setAdapter(myAdapter);
    }
}