package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity {
     //declare views
    Button apply,save;
    TextView viewTxt;
    EditText editText;
    Switch aSwitch;
    //declare a shared preference ref
    public static final String SHARED_PREFS = "sharedPrefs";
    //stored a placeholder text plus a placeholder switch state
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    //variables to store the users input on text, switch widget
    private String text;
    private boolean switchOnOff;

    //call code
    private static final int REQUEST_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        //view identification
        apply = findViewById(R.id.apply_text_button);
        save = findViewById(R.id.save_button);
        viewTxt = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        aSwitch = findViewById(R.id.switch1);

        //onclick listeners
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTxt.setText(editText.getText().toString().trim());
            }
        });

        //save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        //to see what user stores in my shared prefs
        loadData();
        //to reset the content when user enter new input
        updateViews();

    }

     //saving data / writing to shared prefs
    private void saveData(){
        //new instance of SP class
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        //create a ref to the editor method / instance of the shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //put content in shared prefs
        editor.putString(TEXT,viewTxt.getText().toString().trim());
        editor.putBoolean(SWITCH1, aSwitch.isChecked());

        //commit or apply your sp
        editor.apply();
        Toast.makeText(this, "Data saved to shared preferences", Toast.LENGTH_SHORT).show();
    }

    //reading data from shared prefs
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1,false);

    }

    //update views
    private void updateViews(){
        viewTxt.setText(text);
        aSwitch.setChecked(switchOnOff);
    }

    //email intent
    public void email(View v){
        String text = "sample text";
        //broadcasting a service for sharing of text
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        intent.putExtra(Intent.EXTRA_SUBJECT,"testing to see if this works");
        intent.putExtra(Intent.EXTRA_EMAIL,"josephbill00@gmail.com");
        intent.setType("text/message");
        //set up an intent chooser
        startActivity(Intent.createChooser(intent,"Select app to use"));

    }

    //call intent
    public void call(View v){
        String phoness = "0798501657";
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE);
        } else {
            //if permission is granted
            //if the user has allowed app to make a call , launch intent here
            String phone = "tel:" + phoness;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(phone)));
        }

    }
}
