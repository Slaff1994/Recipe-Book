package com.example.zane.RecipeApp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout.LayoutParams;

public class AddRecipe extends AppCompatActivity implements View.OnClickListener{

    private Button addIngBtn;
    private Button addDirButton;
    private String ingString;
    private Button cameraBtn;
    private String amountString;
    private String stepNumString;
    private String descString;
    private LinearLayout mLay;
    //TextView tv = (TextView)findViewById(R.id.ingTv);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        cameraBtn = (Button) findViewById(R.id.cameraButton);
        addIngBtn = (Button) findViewById(R.id.ingButton);
        addDirButton = (Button) findViewById(R.id.dirButton);
        mLay = (LinearLayout) findViewById(R.id.addLinLay);

        addIngBtn.setOnClickListener(this);
        addDirButton.setOnClickListener(this);
        cameraBtn.setOnClickListener(this);

        TextView textView = new TextView(this);
        textView.setText("New Text");
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.cameraButton:
                startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
                break;
            case R.id.ingButton:
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.customdialog, null);
                final EditText ingEdit = (EditText) alertLayout.findViewById(R.id.ingNameET);
                final EditText amountEdit = (EditText) alertLayout.findViewById(R.id.amountET);

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Add Recipe");
                alert.setView(alertLayout);
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ingString = ingEdit.getText().toString();
                        amountString=amountEdit.getText().toString();

                        mLay.addView(createIngTextView(ingString, amountString));
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
                break;
            case R.id.dirButton:
                LayoutInflater inflater2 = getLayoutInflater();
                View alertLayout2 = inflater2.inflate(R.layout.customdialog2, null);
                final EditText stepNumEdit = (EditText) alertLayout2.findViewById(R.id.stepNumET);
                final EditText descEdit = (EditText) alertLayout2.findViewById(R.id.descET);

                AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
                alert2.setTitle("Add Steps");
                alert2.setView(alertLayout2);
                alert2.setCancelable(false);
                alert2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert2.setPositiveButton("Add", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stepNumString = stepNumEdit.getText().toString();
                        descString = descEdit.getText().toString();

                        mLay.addView(createDirTextView(stepNumString, descString));
                    }
                });
                AlertDialog dialog2 = alert2.create();
                dialog2.show();
                break;
        }
    }

    private TextView createIngTextView(String text,String text2){
        final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        final TextView ingTV = new TextView(this);
        ingTV.setLayoutParams(lparams);
        ingTV.setText("Ingredient: " + text + "          " + "Amount: " + text2);
        return ingTV;
    }
    private TextView createDirTextView(String text, String text2){
        final LayoutParams lparams2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        final TextView dirTV = new TextView(this);
        dirTV.setLayoutParams(lparams2);
        dirTV.setText("Step Number: " + text + "          " + "Description: " + text2);
        return dirTV;
    }
}
