package com.example.dfrank.cryptocurrency.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dfrank.cryptocurrency.R;

/**
 * Created by dfrank on 11/1/17.
 */

public class ConversionActivity extends AppCompatActivity {
    private EditText textarea, textarea1;
    private Button convert, convert1;
    private TextView text, answer, answer1;
    private TextInputLayout inputLayout, inputLayout1;
    private CardView cardView, cardView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion);
        text = findViewById(R.id.text);
        textarea1 = findViewById(R.id.editText1);
        textarea = findViewById(R.id.editText);
        convert1 = findViewById(R.id.submit1);
        convert = findViewById(R.id.submit);
        inputLayout = findViewById(R.id.text_input_layout);
        inputLayout1 = findViewById(R.id.text_input_layout1);
        answer = findViewById(R.id.answer);
        answer1 = findViewById(R.id.answer1);
        cardView1 = findViewById(R.id.cardView1);
        cardView = findViewById(R.id.cardView);

        text.setText("Conversion details for "+getIntent().getStringExtra("Currency"));

        textarea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateName();
            }
        });
        textarea1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateName();
            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
        convert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm2();
            }
        });

    }
    private boolean validateName() {
        if (textarea.getText().toString().trim().isEmpty()) {
            inputLayout.setError(getString(R.string.err_msg_name));

            return false;
        } else {
            inputLayout.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateName1() {
        if (textarea1.getText().toString().trim().isEmpty()) {
            inputLayout1.setError(getString(R.string.err_msg_name));

            return false;
        } else {
            inputLayout1.setErrorEnabled(false);
        }

        return true;
    }
    private void submitForm() {
        if (!validateName()) {
            return;
        }
        cardView.setVisibility(View.VISIBLE);
        crypto2base();

    }
    private void submitForm2(){
        if (!validateName1()) {
            return;
        }
        cardView1.setVisibility(View.VISIBLE);
        base2crypto();
    }
    private void crypto2base(){
        float btc = getIntent().getExtras().getFloat("btc");
        float getText = Float.valueOf(String.valueOf(textarea.getText()));
        answer.setText(String.valueOf(btc*getText));
    }
    private void base2crypto(){
        float btc = getIntent().getExtras().getFloat("btc");
        float getText = Float.valueOf(String.valueOf(textarea1.getText()));
        answer1.setText(String.valueOf(getText/btc));
    }
}
