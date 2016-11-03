package com.example.zane.mycookook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button viewRecipeBtn = (Button)findViewById(R.id.viewButton);
        Button addRecipeBtn = (Button)findViewById(R.id.addButton);
        Button helpBtn = (Button)findViewById(R.id.helpButton);
        viewRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(getApplicationContext(),ViewRecipe.class);
                startActivity(activity2);
            }
        }
        );
        addRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(getApplicationContext(),AddRecipe.class);
                startActivity(activity2);
            }
        }
        );
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(getApplicationContext(),Help.class);
                startActivity(activity2);
            }
        }
        );
    }
}
