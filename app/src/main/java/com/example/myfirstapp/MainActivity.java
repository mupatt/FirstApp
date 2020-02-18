package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String weburl="http://www.gmail.com";
    public static String website="http://www.must.ac.ug";
    Button music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = findViewById(R.id.mp3);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SocialMedia.class);
                startActivity(intent);
            }
        });
    }
    public void sendMessage(View view){
        EditText message = (EditText)findViewById(R.id.message);
        Toast.makeText(this,"Sending message" + message.getText().toString(),Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this,DisplayMessageActivity.class);
        intent.putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");
    }
    public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.offers,menu);
    return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/up button
        //so long as a parent activity in Android Manifest .xml is specified.
        int id = item.getItemId();
        switch (id){
            case R.id.web:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            case R.id.mail:
                Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse(weburl));
                if (webintent.resolveActivity(getPackageManager())!=null){
                    startActivity(webintent);
                }

        }
        return super.onOptionsItemSelected(item);
    }
}

