package com.example.margaux.test03blocnote;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button1 = null;
    Button button2 = null;
    Button button3 = null;

    ImageButton smiley_happy = null;
    ImageButton smiley_super_happy = null;
    ImageButton smiley_blink = null;

    RadioGroup radioGroup = null;

    Button buttonShowHide = null;

    EditText editText =null;

    Boolean isOpen = false;
    Boolean isBold = false;
    Boolean isItalic = false;
    Boolean isUnderlined = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        smiley_happy = (ImageButton) findViewById(R.id.smiley_happy);
        smiley_super_happy = (ImageButton) findViewById(R.id.smiley_super_happy);
        smiley_blink = (ImageButton) findViewById(R.id.smiley_blink);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        buttonShowHide = (Button) findViewById(R.id.buttonShowHide);

        editText = (EditText) findViewById(R.id.editText);

        button1.setText(htmlToText(getResources().getString(R.string.string_button1)));
        button2.setText(htmlToText(getResources().getString(R.string.string_button2)));
        button3.setText(htmlToText(getResources().getString(R.string.string_button3)));
        buttonShowHide.setText(htmlToText(getResources().getString(R.string.string_buttonShowHide_Hide)));

        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {

                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                Editable myText = editText.getText();
                if(start==end){

                    myText.insert(start, "<b></b>");

                }
                else{
                    myText.insert(start,"<b>");
                    myText.insert(end+3,"</b>");
                }
            }
        });

        button2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {

                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                Editable myText = editText.getText();
                if(start==end){

                    myText.insert(start, "<i></i>");

                }
                else{
                    myText.insert(start,"<i>");
                    myText.insert(end+3,"</i>");
                }
            }
        });
        button3.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {

                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                Editable myText = editText.getText();
                if(start==end){

                    myText.insert(start, "<u></u>");

                }
                else{
                    myText.insert(start,"<u>");
                    myText.insert(end+3,"</u>");
                }
            }
        });
    }






    private Spanned htmlToText(String s){
        Spanned newText = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            newText = Html.fromHtml(s,Html.FROM_HTML_MODE_LEGACY);
        } else {
            newText = Html.fromHtml(s);
        }

        return newText;
    };
}

