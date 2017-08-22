package com.example.ee.asg_1_button_textview_edittext;

import android.os.Build;
import android.speech.tts.TextToSpeech;
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

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button btn;
    TextView tView;
    EditText edtText;
    TextToSpeech textToSpeech;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",String.valueOf(tView.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            tView.setText(savedInstanceState.getString("text"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        tView = (TextView) findViewById(R.id.textView);
        edtText = (EditText) findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(getApplicationContext(),this);

    }

    public void clickable(View v){
        String input;
        input = edtText.getText().toString();
        if(input.length()==0){
            Toast tost = Toast.makeText(getApplicationContext(),R.string.Toast,Toast.LENGTH_LONG);
            tost.setGravity(Gravity.TOP,0,250);
            tost.show();

            /*LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast_layout));

            Toast tost = new Toast(getApplicationContext());
            tost.setDuration(Toast.LENGTH_LONG);
            tost.setView(view);
            tost.setGravity(Gravity.FILL,0,0);
            tost.show();*/


            tView.setText(R.string.Anonymous);
            voice("Welcome Anonymous");
        }
        else{
            tView.setText("Welcome "+input+" \uD83D\uDE0E");
            voice("Welcome"+input);
        }

    }

    public void voice(String str){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            textToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else {
            textToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    public void onInit(int status) {

    }
}
