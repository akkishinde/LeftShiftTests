package com.akshay.leftshifttests;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

        public static String MY_ACTION = "com.akshay.leftshifttests.integer";
        private MyCustomBroadcast myCustomReciver;
        private Button btnBroadcast;
    private TextView tvRecieve;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_service);
            btnBroadcast = (Button) findViewById(R.id.btnBroadcast);
            tvRecieve=(TextView)findViewById(R.id.tvRecieve);
            /*btnBroadcast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendBroadcast(new Intent(MY_ACTION));
                }
            });
            myCustomReciver = new MyCustomBroadcast();
            registerReceiver(myCustomReciver, new IntentFilter(MY_ACTION));*/
            BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
               // tvRecieve.setText();
                }
            };

        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            unregisterReceiver(myCustomReciver);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
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
        }
    }
