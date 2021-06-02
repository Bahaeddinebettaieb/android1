package com.itgate.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText pseudo;
    EditText password;
    TextView login;
    TextView emptyFieldPseudo,emptyFieldPassword,invalidPseudo,invalidPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pseudo = (EditText)findViewById(R.id.pseudo);
        password = (EditText)findViewById(R.id.password);
        login = (TextView)findViewById(R.id.sign_in_activity_main);
        emptyFieldPseudo = (TextView)findViewById(R.id.error_empty_field_pseudo);
        emptyFieldPassword = (TextView)findViewById(R.id.error_empty_field_password);
        invalidPseudo = (TextView)findViewById(R.id.error_invalid_pseudo);
        invalidPassword = (TextView)findViewById(R.id.error_wrong_password);

        pseudo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().isEmpty()){
                    emptyFieldPseudo.setVisibility(View.GONE);
                    invalidPseudo.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().isEmpty()){
                    emptyFieldPassword.setVisibility(View.GONE);
                    invalidPassword.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMain();
            }


        });
    }


    private Boolean showErrors() {
        if ((pseudo.toString().isEmpty())){
            emptyFieldPseudo.setVisibility(View.VISIBLE);
            return false;
        } else if ((!pseudo.getText().toString().equals("admin"))){
            invalidPseudo.setVisibility(View.VISIBLE);
            return false;
        }else if ((password.toString().isEmpty())){
            emptyFieldPassword.setVisibility(View.VISIBLE);
            return false;
        }else if ((!password.getText().toString().equals("admin"))){
            invalidPassword.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    private void navigateToMain() {
        if (showErrors()){
            startActivity(new Intent(MainActivity.this,MainRecyclerActivity.class));
        }
    }

}