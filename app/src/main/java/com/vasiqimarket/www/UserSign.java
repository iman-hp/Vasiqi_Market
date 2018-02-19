package com.vasiqimarket.www;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Asus on 12/28/2017.
 */

public class UserSign extends AppCompatActivity {
    CheckBox showpass;
    EditText edtemail;
    EditText edtpass;
    TextView txtsignup;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        setContentView(R.layout.user_sign);
        super.onCreate(savedInstanceState);
        showpass=(CheckBox)findViewById(R.id.showpass);
        edtemail=(EditText)findViewById(R.id.edtEmail);
        edtpass=(EditText)findViewById(R.id.edtPass);
        txtsignup=(TextView)findViewById(R.id.txtsignup);
        showpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(showpass.isChecked()){
                    edtpass.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else {
                    edtpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT );
                }
            }
        });


        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserSign.this,ActivityUserSignUp.class);
                startActivity(intent);
            }
        });
    }
}
