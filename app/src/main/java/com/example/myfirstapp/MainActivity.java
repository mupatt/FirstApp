package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static String weburl="http://www.gmail.com";
    public static String website="http://www.must.ac.ug";
    Button music;
    private BroadcastReceiver myReceiver= new BroadcastReceiver(){
        public void onReceive(Context c, Intent i){
            //Get Battery
            int level = i.getIntExtra("level",0);
            //Find the progressbar created in main.xml
            ProgressBar pb =(ProgressBar)findViewById(R.id.progressBa);
            pb.setProgress(level);

            //Accessing textview control created in main.xml
            TextView textView=(TextView)findViewById(R.id.batteryView);
            textView.setText("Battery level:" + Integer.toString(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register the receiver when battery charge is changed
        registerReceiver(myReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


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
       //Define a method to send alerts
    public void startAlert(View view){

        EditText text=(EditText)findViewById(R.id.textClick);
        int in = Integer.parseInt(text.getText().toString());

        //Create an intent and call your receiver
        Intent intent = new Intent(this,BroadcastReceiver.class);

        //Create a pending Intent to be fired
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);

        //Recall the alarm manager class
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //Real time clock to be used

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (in * 1000),pendingIntent);
        Toast.makeText(this,"Alarm set in" + in + "seconds",Toast.LENGTH_LONG).show();
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
                else{
                    return true;
                }
            case R.id.mail:
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(weburl));
                if (webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                }else{
                    return true;
                }
            case R.id.file:
                startActivity(new Intent(this,Services.class));
                return true;

            case R.id.lists:
                startActivity(new Intent(this, listview.class));
                return true;

            case R.id.music:
                startActivity(new Intent(this,Service.class));
                return true;

            case R.id.mails:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto"));
                String to [] = {"mupatt@gmail.com","muhairwep@yahaoo.com","bryntu9@gmail.com","nalumagamaria501@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL, to);
                i.putExtra(Intent.EXTRA_SUBJECT, "Reminder");
                i.putExtra(Intent.EXTRA_TEXT, "You are reminded to hand in your assignment as soon as possible");
                i.setType("message/rfc822");
                startActivity(i);
                return true;

            case R.id.call:
                try {
                    // check for call permissions
                    int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

                    // Here, thisActivity is the current activity
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {

                            // Show an explanation to the user *asynchronously*
                            Toast.makeText(this, "This permission is required to call a phone number", Toast.LENGTH_LONG).show();

                        } else {

                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                            // app-defined int constant. The callback method gets the
                            // result of the request.
                        }
                    }
                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0700373510"));
                    startActivity(in);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this,Storage.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

