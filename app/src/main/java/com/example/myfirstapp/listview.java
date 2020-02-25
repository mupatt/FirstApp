package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listview extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView=findViewById(R.id.lst);
        final ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("php");
        arrayList.add("Java");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("Python");
        arrayList.add("php");
        arrayList.add("Java");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("Python");
        arrayList.add("php");
        arrayList.add("Java");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("Python");
        arrayList.add("php");
        arrayList.add("Java");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("Python");
        arrayList.add("php");
        arrayList.add("Java");
        arrayList.add("HTML");
        arrayList.add("CSS");
        arrayList.add("Python");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
