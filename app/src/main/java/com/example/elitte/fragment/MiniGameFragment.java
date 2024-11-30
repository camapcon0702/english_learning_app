package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.ListMiniGame;
import com.example.elitte.Models.MiniGame;
import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.Retrofit.MiniGameAPI;
import com.example.elitte.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MiniGameFragment extends Fragment implements View.OnClickListener {

    private TextView correctAnswer;
    private TextView questionMiniGame;
    private EditText answerMiniGame;
    private TextView result;
    private Button btnSkip, btnReply;
    private List<MiniGame> questionList = new ArrayList<>();
    private MiniGame mMiniGameQuestion;
    private int correctAnswerCount = 0;
    private int currentQuestion = 0;
    private View view;
    private TextView txtBack;

    private MutableLiveData<List<MiniGame>> liveQuestionList = new MutableLiveData<>();

    public MiniGameFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mini_game_page, container, false);
        addControl();
        addEvent();
        fetchQuestionsFromApi();
        observeQuestionList();
        return view;
    }

    private void addControl() {
        correctAnswer = view.findViewById(R.id.tv_correct_answers);
        questionMiniGame = view.findViewById(R.id.question_mini_game);
        answerMiniGame = view.findViewById(R.id.answer);
        btnSkip = view.findViewById(R.id.btn_skip);
        btnReply = view.findViewById(R.id.btn_reply);
        result = view.findViewById(R.id.result);
        txtBack = view.findViewById(R.id.back);

    }

    private void addEvent() {
        btnSkip.setOnClickListener(this);
        btnReply.setOnClickListener(this);
        txtBack.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), NavigationMainActivity.class);
            startActivity(intent);
        });
    }

    private void fetchQuestionsFromApi() {
        MiniGameAPI miniGameAPI;
        String token = TokenManager.getToken(getContext());
        miniGameAPI = new RetrofitInstance().getRetrofitInstance(token).create(MiniGameAPI.class);

        Call<ListMiniGame> call = miniGameAPI.getListMinigamme();
        call.enqueue(new Callback<ListMiniGame>() {
            @Override
            public void onResponse(Call<ListMiniGame> call, Response<ListMiniGame> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveQuestionList.postValue(response.body());
                } else {
                    Log.e("fetchQuestionsFromApi", "API Response Failed");
                }
            }

            @Override
            public void onFailure(Call<ListMiniGame> call, Throwable t) {
                Log.e("fetchQuestionsFromApi", "API Call Failed: " + t.getMessage());
            }
        });
    }

    private void observeQuestionList() {
        liveQuestionList.observe(getViewLifecycleOwner(), new Observer<List<MiniGame>>() {
            @Override
            public void onChanged(List<MiniGame> miniGames) {
                if (miniGames != null && !miniGames.isEmpty()) {
                    questionList = miniGames;
                    setDataQuestion(questionList.get(currentQuestion));
                } else {
                    Log.e("observeQuestionList", "No questions available");
                }
            }
        });
    }

    private void setDataQuestion(MiniGame miniGameQuestion) {
        if (miniGameQuestion == null) return;

        mMiniGameQuestion = miniGameQuestion;
        questionMiniGame.setText(miniGameQuestion.getQuestion());
        answerMiniGame.setText("");
        result.setText("");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_skip) {
            moveToNextQuestion();
        } else if (view.getId() == R.id.btn_reply) {
            checkAnswer();
            new Handler().postDelayed(this::moveToNextQuestion, 2000);
        }
    }

    private void checkAnswer() {
        String userAnswer = answerMiniGame.getText().toString().trim();
        if (mMiniGameQuestion != null && userAnswer.equalsIgnoreCase(mMiniGameQuestion.getAnswer())) {
            correctAnswerCount++;
            result.setText("Chính xác!");
        } else {
            result.setText("Sai rồi!");
        }
        updateCorrectAnswerCount();
    }

    private void updateCorrectAnswerCount() {
        correctAnswer.setText("Số câu trả lời đúng: " + correctAnswerCount);
    }

    private void moveToNextQuestion() {
        currentQuestion++;
        if (currentQuestion < questionList.size()) {
            setDataQuestion(questionList.get(currentQuestion));
        } else {
            result.setText("Bạn đã hoàn thành trò chơi!");
            btnReply.setEnabled(false);
            btnSkip.setEnabled(false);
        }
    }
}
