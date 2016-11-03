package com.example.zane.mycookook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        create = (Button) findViewById(R.id.createButton);
        usernameEditText = (EditText) findViewById(R.id.usernameET);
        passwordEditText = (EditText) findViewById(R.id.password1ET);
        confirmPasswordEditText = (EditText) findViewById(R.id.password2ET);

        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        switch(v.getId()) {
            case R.id.createButton:
                if (username.equals(" ") || password.equals(" ") || confirmPassword.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Missing Field", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "Account Successfully Created", Toast.LENGTH_LONG).show();
                }
        }
    }
}