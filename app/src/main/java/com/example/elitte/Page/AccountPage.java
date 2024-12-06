package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;

public class AccountPage extends AppCompatActivity {

    private TextView changePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_page);

        addControl();
        addEvent();
    }

    private void addEvent() {
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountPage.this, ChangePassword.class);
                startActivity(intent);
            }
        });
    }

    private void addControl(){
        changePassword = findViewById(R.id.change_password);
    }
}