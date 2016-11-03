package com.example.zane.mycookook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        signUp = (Button) findViewById(R.id.signUpButton);

        signUp.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.signUpButton:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                break;
            case R.id.loginButton:
                //Insert Code Here
        }
    }
}
