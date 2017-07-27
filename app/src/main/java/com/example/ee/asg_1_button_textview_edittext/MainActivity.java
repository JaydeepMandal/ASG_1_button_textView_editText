package com.example.ee.asg_1_button_textview_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tView;
    EditText edtText;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",String.valueOf(tView.getText()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        tView = (TextView) findViewById(R.id.textView);
        edtText = (EditText) findViewById(R.id.editText);

        if(savedInstanceState != null){
            String textView = savedInstanceState.getString("text");
            tView.setText(textView);

        }

    }

    public void clickable(View v){
        Editable input;
        input = edtText.getText();
        if(input.length()==0){
            Toast tost = Toast.makeText(getApplicationContext(),R.string.Toast,Toast.LENGTH_LONG);
            tost.setGravity(Gravity.TOP,0,250);
            tost.show();
            tView.setText(R.string.Anonymous);
        }
        else{
            tView.setText("Welcome "+input+" \uD83D\uDE0E");
        }

    }

}
