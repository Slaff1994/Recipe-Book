package com.example.zane.RecipeApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        signUp = (Button) findViewById(R.id.signUpButton);
        login = (Button) findViewById(R.id.loginButton);

        signUp.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.signUpButton:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                break;
            case R.id.loginButton:
                startActivity(new Intent(getApplicationContext(), Home.class));
                break;
        }
    }
}
