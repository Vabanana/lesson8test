package sg.edu.rp.c346.id18015906.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        save = findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onPause();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa", (float)0.00);

        int radioButton = prefs.getInt("gender",0 );
        String msgGpa = Float.toString(gpa);

        etName.setText(msg);
        etGPA.setText(msgGpa);
        rgGender.check(radioButton);

    }
    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Obtain an instance of the SharedPreferences
        String strName = etName.getText().toString();
        Float strGPA = Float.parseFloat(etGPA.getText().toString());
        int radioButton = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        //Step 1b: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c: Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", strGPA);
        prefEdit.putInt("gender", radioButton);

        //Step 1d: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }



}



