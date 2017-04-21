package com.example.sierra.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    Button btnSpeak;
    EditText txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new  TextToSpeech(this,this);
        btnSpeak = (Button) findViewById(R.id.btnSpeak);
        txtText = (EditText) findViewById(R.id.txtText);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });

    }


    @Override
    public void onDestroy(){
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            int res = tts.setLanguage(Locale.US);
            if(res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("--TTS--","Language not found");
            }else{
                btnSpeak.setEnabled(true);
                speakOut();
            }
        }
    }

    public void speakOut(){
        String txt = txtText.getText().toString();
        tts.speak(txt,TextToSpeech.QUEUE_FLUSH,null);
    }
}
