package com.example.salim.smsapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    MainActivity mma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    public void sms(View t)
    {
        (new  TestThread()).start();
    }
   public class TestThread extends Thread {
        public void run() {
            Context context = mma.getBaseContext();

            Uri uriSms = Uri.parse("content://sms/inbox");
            Cursor c = context.getContentResolver().query(uriSms, new String[]{"_id", "thread_id", "address", "person", "date", "body"}, null, null, null);

            if (c != null && c.moveToFirst()) {
                do {
                    long id = c.getLong(0);
                    long threadId = c.getLong(1);
                    String address = c.getString(2);
                    String date = c.getString(4);
                    String body = c.getString(5);

                    Log.d("test", "test");
                    Log.d("delete", address);
                    String ladress = "88";

                    if (address.equals(ladress)) {
                        Log.d("Deleting SMS with id: ", Long.toString(threadId));
                        String uri = "content://sms/" + id;
                        mma.getContentResolver().delete(Uri.parse("content://sms/conversations/" + id), null, null);

                    }
                    c.moveToNext();
                } while (!c.isAfterLast());
            }
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.DONUT)
    public void oui(View t) throws InterruptedException {
        SmsManager manager = SmsManager.getDefault();
        int puissance=0;
        Log.d("send", "0000");
        while(puissance<300) {
            Log.d("send2", "0000");
            Thread.sleep(200);
            manager.sendTextMessage("0613550328", null, "test", null, null);
            puissance++;
        }
    }





}


