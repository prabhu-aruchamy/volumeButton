package com.prabhu.volumebuttoncheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView count_no;
    static int counter = 0;
    int counter1 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count_no = (TextView)findViewById(R.id.count_no);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            counter = counter - 1;
            counter1 = counter1 + 1;
            if(counter1 >= 5){
                Intent intent = new Intent(MainActivity.this,newActivity.class);
                startActivity(intent);
                counter1 = 0;
            }else{
                count_no.setText("Counter : "+counter );
                Toast.makeText(this, "Volume Down Pressed", Toast.LENGTH_SHORT).show();
            }

            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            counter = counter + 1;
            count_no.setText("Counter : "+counter );
            Toast.makeText(this, "Volume Up Pressed", Toast.LENGTH_SHORT).show();
            return true;
        }

        else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
