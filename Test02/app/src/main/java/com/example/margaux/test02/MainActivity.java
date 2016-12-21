package com.example.margaux.test02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spanned textResultDefault = null;
    private final String text_mega= "t'es parfait(e)!";

    private EditText poids = null;
    private EditText taille = null;
    private RadioGroup radioGroup = null;
    private RadioButton radioB2 = null;
    private CheckBox checkB = null;
    private Button button_calcul = null;
    private Button button_raz = null;
    private TextView textView_result2 = null;


    private OnClickListener clickListener_button_calcul = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(checkB.isChecked()){
                textView_result2.setText(text_mega);
            }
            else if (Double.valueOf(poids.getText().toString())==0 || Double.valueOf(taille.getText().toString())==0){
                Toast.makeText(MainActivity.this, "Heuuu zéro me parait faible...", Toast.LENGTH_SHORT).show();
            }
            else if (!poids.getText().equals("") && !taille.getText().equals("")){
                Double poids_d = Double.valueOf(poids.getText().toString());
                Double taille_d= Double.valueOf(taille.getText().toString());

                if (radioB2.isChecked()){
                    taille_d = taille_d/100;
                }
                Double imc = poids_d/taille_d;
                textView_result2.setText(getResources().getString(R.string.result_imc,imc));
            }
        }
    };

    private OnClickListener clickListener_button_raz = new OnClickListener() {
        @Override
        public void onClick(View v) {
            poids.getText().clear();
            taille.getText().clear();
            textView_result2.setText(textResultDefault);
        }
    };

    private TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView_result2.setText(textResultDefault);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            textView_result2.setText(textResultDefault);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String textResultDefaut1 = getResources().getString(R.string.resultDefault);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textResultDefault = Html.fromHtml(textResultDefaut1,Html.FROM_HTML_MODE_LEGACY);
        } else {
            textResultDefault = Html.fromHtml(textResultDefaut1);
        }

        button_calcul=(Button) findViewById(R.id.button_calcul);
        button_calcul.setOnClickListener(clickListener_button_calcul);

        button_raz=(Button) findViewById(R.id.button_raz);
        button_raz.setOnClickListener(clickListener_button_raz);

        taille=(EditText) findViewById(R.id.editText_taille);
        taille.addTextChangedListener(textwatcher);

        poids = (EditText) findViewById(R.id.editText_poids);
        poids.addTextChangedListener(textwatcher);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(checkedChangeListener);

        radioB2 = (RadioButton) findViewById(R.id.radioB2);

        checkB = (CheckBox) findViewById(R.id.checkB);

        textView_result2 = (TextView) findViewById(R.id.textView_result2);
        textView_result2.setText(textResultDefault);
    }
}
