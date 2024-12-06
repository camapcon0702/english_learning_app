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


private void loginUser() {
    String email = txtEmail.getText().toString().trim();
    String password = txtMatKhau.getText().toString().trim();

    if (email.isEmpty() || password.isEmpty()) {
        Toast.makeText(this, "Email và mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
        return;
    }

    LoginRequest loginRequest = new LoginRequest(email, password);

    btnLogin.setEnabled(false);

    btnLogin.setText("Đang đăng nhập...");

    AuthApi authApi = RetrofitInstance.getRetrofitInstance(null).create(AuthApi.class);
    authApi.login(loginRequest).enqueue(new Callback<LoginResponse>() {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            btnLogin.setEnabled(true);
            btnLogin.setText("Đăng nhập");

            if (response.isSuccessful() && response.body() != null) {
                String token = response.body().getToken();
                TokenManager.saveToken(LoginPage.this, token);

                AuthApi authApiWithToken = RetrofitInstance.getRetrofitInstance(token).create(AuthApi.class);

                Intent intent = new Intent(LoginPage.this, NavigationMainActivity.class);
                startActivity(intent);
                finish();
            } else {
                if (response.code() == 401) {
                    Toast.makeText(LoginPage.this, "Sai email hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginPage.this, "Lỗi: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            btnLogin.setEnabled(true);
            btnLogin.setText("Đăng nhập");
            Toast.makeText(LoginPage.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}
}