package com.tatvaapps.sample2;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
private EditText et;
    private ImageButton btn;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts=new TextToSpeech(this,this);
        et=(EditText)findViewById(R.id.editText);
        btn=(ImageButton)findViewById(R.id.spkBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });
    }

    private void speakOut() {
       String text=et.getText().toString();
        if(text.isEmpty()){
            Log.e("empty","the string is empty");
        }
        else {
            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    public void onInit(int i) {
        if(i== TextToSpeech.SUCCESS){
            int result=tts.setLanguage(Locale.ENGLISH);
        }
        else {

            Log.e("TTs","tts init failed");
        }
    }
}
