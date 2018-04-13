package com.example.win.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** variable declarations **/
    Context ctx;    // context
    Button butt1;   // save button
    EditText et1;   // edit text to be updated
    SharedPreferences sp; //shared preferences to keep information

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** establish link of xml and variables **/
        butt1 = (Button) findViewById(R.id.butt1);
        et1 = (EditText) findViewById(R.id.etstring);

        /** load the variables **/
        ctx = this;
        sp = ctx.getSharedPreferences("MYFILE", Context.MODE_PRIVATE);
        et1.setText(sp.getString("myvalue", " "));

        /** establish the button event and point to new function **/
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveText(et1.getText().toString());
            }
        });
    }

    /** function to save text to file **/
    private void saveText(String str){
        Toast too = Toast.makeText(ctx, "Saved ... ", 2000);
        too.setGravity(Gravity.CENTER,0,0);
        too.show();
        SharedPreferences.Editor she = sp.edit();
        she.putString("myvalue", et1.getText().toString());
        she.commit();
    }
}
