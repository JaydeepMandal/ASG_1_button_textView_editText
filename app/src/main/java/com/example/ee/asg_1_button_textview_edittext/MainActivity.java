package com.example.ee.asg_1_button_textview_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            input.insert(0,"Anonymous");
        }
        tView.setText("Welcome "+input);
    }
}
