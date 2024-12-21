package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.UserResponse;
import com.example.elitte.Page.AccountPage;
import com.example.elitte.Page.ChangePassword;
import com.example.elitte.R;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.Retrofit.UserAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    private View view;
    private TextView changePassword;
    private TextView txtName, txtEmail;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_account_page, container, false);

        addControl();
        addEvent();
        welcomeUser();

        return view;
    }

    private void addEvent() {
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ChangePasswordFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.account_page, fragment);
                transaction.commit();
            }
        });
    }

    private void addControl(){
        txtName = view.findViewById(R.id.name_account);
        txtEmail = view.findViewById(R.id.email_account);
        changePassword = view.findViewById(R.id.change_password);
    }

    public void welcomeUser() {
        String token = TokenManager.getToken(getContext());
        System.out.println(token);
        if (token == null) {
            Log.e("WelcomeUser", "Token not found");
            return;
        }

        UserAPI userAPI = RetrofitInstance.getRetrofitInstance(token).create(UserAPI.class);
        userAPI.getUserProfile().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserResponse user = response.body();

                    txtName.setText(user.getLastName() + " " + user.getFirstName());
                    txtEmail.setText(user.getEmail() + "");
                } else {
                    Log.e("WelcomeUser", "Failed to fetch user profile");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("WelcomeUser", "Error fetching user profile: " + t.getMessage());
            }
        });
    }
}