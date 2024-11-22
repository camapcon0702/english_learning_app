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
import com.example.elitte.Models.LoginRequest;
import com.example.elitte.Models.LoginResponse;
import com.example.elitte.R;
import com.example.elitte.Retrofit.AuthApi;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.fragment.HomeFragment;
import com.example.elitte.fragment.MiniGameFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPage extends AppCompatActivity {


    EditText txtEmail;
    EditText txtMatKhau;
    TextView txtDangKi;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();

    }

    private void addControls(){
        txtEmail = this.findViewById(R.id.txtEmail);
        txtMatKhau = this.findViewById(R.id.txtMatKhau);
        txtDangKi = this.findViewById(R.id.dang_ky);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void addEvents(){
        txtDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(v -> loginUser());

    }

    private void loginUser(){
        String email = txtEmail.getText().toString().trim();
        String password = txtMatKhau.getText().toString();
        LoginRequest loginRequest = new LoginRequest(email, password);
        AuthApi authApi = RetrofitInstance.getRetrofitInstance().create(AuthApi.class);
        authApi.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String token = response.body().getToken();
                    TokenManager.saveToken(LoginPage.this, token);

                    Intent intent = new Intent(LoginPage.this, NavigationMainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginPage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginPage.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}