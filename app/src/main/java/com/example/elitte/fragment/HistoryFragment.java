
package com.example.elitte.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.elitte.Data.HistoryTopicAdapter;
import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.ListExamSet;
import com.example.elitte.Models.UserExamset;
import com.example.elitte.Models.UserResponse;
import com.example.elitte.R;
import com.example.elitte.Retrofit.ExerciseAPI;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.Retrofit.UserAPI;
import com.example.elitte.entity.HistoryTopic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HistoryFragment extends Fragment {

    private GridView gridView;
    private List<HistoryTopic> historyTopicList;
    private View view;
    private HistoryTopicAdapter adapter;
    private String token;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_history_topic_page, container, false);

        addControl();
        token = TokenManager.getToken(getContext());
        fetchUserProfile();

        return view;
    }

    private void addControl() {
        gridView = view.findViewById(R.id.gridview);
        historyTopicList = new ArrayList<>();
        adapter = new HistoryTopicAdapter(getContext(), historyTopicList);
        gridView.setAdapter(adapter);
    }

    private void fetchUserProfile() {
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(token);
        UserAPI userAPI = retrofit.create(UserAPI.class);
        Call<UserResponse> call = userAPI.getUserProfile();

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserResponse user = response.body();
                    int userId = user.getId();
                    fetchHistoryData(userId);
                } else {
                    Toast.makeText(getContext(), "Failed to fetch user profile", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "Error fetching user profile", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchHistoryData(int userId) {
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(token);
        ExerciseAPI apiService = retrofit.create(ExerciseAPI.class);

        Call<List<UserExamset>> call = apiService.getHistoryOfUser(userId);
        call.enqueue(new Callback<List<UserExamset>>() {
            @Override
            public void onResponse(Call<List<UserExamset>> call, Response<List<UserExamset>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<UserExamset> userExamSets = response.body();
                    historyTopicList.clear();

                    for (UserExamset userExamSet : userExamSets) {
                        ListExamSet examSet = userExamSet.getExamSet();
                        int point = userExamSet.getDiem();
                        String createdAt = userExamSet.getCreatedAt();
                        String formattedDate = parseDate(createdAt);
                        HistoryTopic historyTopic = new HistoryTopic(examSet, point, formattedDate);
                        historyTopicList.add(historyTopic);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Failed to load history", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserExamset>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String parseDate(String createdAt) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date date = inputFormat.parse(createdAt);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return createdAt;
        }
    }
}