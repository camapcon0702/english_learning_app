package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.RegisterRequest;
import com.example.elitte.Models.RegisterResponse;
import com.example.elitte.R;
import com.example.elitte.Retrofit.AuthApi;
import com.example.elitte.Retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {

    TextView txtDangNhap;
    EditText txtEmail, txtHo, txtTen, txtMatKhau, txtConfirmMatKhau;
    Button btnDangKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);


        txtDangNhap = findViewById(R.id.dang_nhap);
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        addControls();
        addEvent();



    }

    private void addControls(){
        txtEmail = findViewById(R.id.txtEmail);
        txtHo = findViewById(R.id.txtHo);
        txtTen = findViewById(R.id.txtTen);
        txtMatKhau = findViewById(R.id.txtMatKhau);
        txtConfirmMatKhau = findViewById(R.id.txtConfirmMatKhau);
        btnDangKi = findViewById(R.id.btnDangKi);

    }

    private void addEvent(){
        btnDangKi.setOnClickListener(e -> registerUser());

    }

    private void registerUser(){
        String email = txtEmail.getText().toString().trim();
        String ho = txtHo.getText().toString().trim();
        String ten = txtTen.getText().toString().trim();
        String matKhau = txtMatKhau.getText().toString();
        String confirmMatKhau = txtConfirmMatKhau.getText().toString();

        RegisterRequest registerRequest = new RegisterRequest(ten, ho, email, matKhau, confirmMatKhau);
        AuthApi authApi = RetrofitInstance.getRetrofitInstance(null).create(AuthApi.class);
        authApi.register(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    txtEmail.setText("");
                    txtHo.setText("");
                    txtTen.setText("");
                    txtMatKhau.setText("");
                    txtConfirmMatKhau.setText("");
                    Toast.makeText(RegisterPage.this, "Đăng kí tài khoản thành công", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RegisterPage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterPage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }


}