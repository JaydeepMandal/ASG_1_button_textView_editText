package com.example.ee.asg_1_button_textview_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tView;
    EditText edtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        tView = (TextView) findViewById(R.id.textView);
        edtText = (EditText) findViewById(R.id.editText);


    }

    public void clickable(View v){
        Editable input;
        input = edtText.getText();
        if(input.length()==0){
           // Toast tost = Toast.makeText(getApplicationContext(),R.string.Toast,Toast.LENGTH_LONG);
//            tost.setGravity(Gravity.TOP,0,250);
//            tost.show();

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_layout));

            Toast tost = new Toast(getApplicationContext());
            tost.setDuration(Toast.LENGTH_LONG);
            tost.setView(view);
            tost.setGravity(Gravity.FILL,0,0);
            tost.show();


            tView.setText(R.string.Anonymous);
        }
        else{
            tView.setText("Welcome "+input+" \uD83D\uDE0E");
        }

    }
}
