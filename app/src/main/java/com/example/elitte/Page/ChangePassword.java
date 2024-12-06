package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;

public class ChangePassword extends AppCompatActivity {

    private TextView back;
    private Button btnUpdatePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);


        addControl();
        addEvent();
    }

    private void addEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backAccountPage();
            }
        });

        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChangePassword.this, "Đã cập nhật mật khẩu", Toast.LENGTH_SHORT).show();
                backAccountPage();
            }
        });
    }

    private void addControl() {
        back = findViewById(R.id.back);
        btnUpdatePassword = findViewById(R.id.btn_update_password);
    }

    private void backAccountPage(){
        Intent intent = new Intent(ChangePassword.this, AccountPage.class);
        startActivity(intent);
        finish();
    }
}