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
    private EditText textarea;
    private Button convert;
    private TextView answer;
    private TextInputLayout inputLayout;
    private CardView cardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion);
        textarea = findViewById(R.id.editText);
        convert = findViewById(R.id.submit);
        inputLayout = findViewById(R.id.text_input_layout);
        answer = findViewById(R.id.answer);
        cardView = findViewById(R.id.cardView);

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
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
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
    private void submitForm() {
        if (!validateName()) {
            return;
        }
        cardView.setVisibility(View.VISIBLE);
        conversion();

    }
    private void conversion(){
        float btc = getIntent().getExtras().getFloat("btc");
        float getText = Float.valueOf(String.valueOf(textarea.getText()));
        answer.setText(String.valueOf(btc*getText));
    }
}
