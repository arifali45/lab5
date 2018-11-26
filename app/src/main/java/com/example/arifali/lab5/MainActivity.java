package com.example.arifali.lab5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    EditText etn,etm;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS=0;
    String phoneno;
    String message;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        etn=findViewById(R.id.editText);
        etm=findViewById(R.id.editText2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonedial();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendemail();
            }
        });
    }
    protected void phonedial(){
        Intent i=new Intent(Intent.ACTION_DIAL);
        startActivity(i);
    }
    protected void sendsms()
    {
        String num=etn.getText().toString();
        String mes=etm.getText().toString();
        Uri uri=Uri.parse("smsto:"+num);
        Intent i=new Intent(Intent.ACTION_SENDTO,uri);
        i.putExtra("sms_body",mes);
        startActivity(i);
        /*SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage("9901846113",null,"hello",null,null);
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.putExtra("sms_body","default content");
        i.setType("vnd.android-dir/mms-sms");
        startActivity(i);*/
        Toast.makeText(this, "SMS SENT succesfully ", Toast.LENGTH_SHORT).show();
        etn.setText("");
        etm.setText("");
    }
    protected void sendemail()
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"arifali45@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,"Subject Test");
        i.putExtra(Intent.EXTRA_TEXT,"Message body Test");
        startActivity(i);
    }
}
