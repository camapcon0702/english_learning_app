package com.example.elitte.Page;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;
import com.example.elitte.entity.MiniGameQuestion;

import java.util.ArrayList;
import java.util.List;

public class MiniGamePage extends AppCompatActivity implements View.OnClickListener {

    private TextView correctAnswer;
    private TextView questionMiniGame;
    private EditText answerMiniGame;
    private TextView result;
    private Button btnSkip, btnReply;
    private List<MiniGameQuestion> questionList;
    private MiniGameQuestion mMiniGameQuestion;
    private int correctAnswerCount = 0;
    private int currentQuestion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mini_game_page);

        addControl();
        addEvent();
    }

    private void addEvent() {
        btnSkip.setOnClickListener(this);
        btnReply.setOnClickListener(this);
    }

    private void addControl(){
        initUI();
        questionList = getListQuestionMiniGame();
        Log.d("MiniGamePage", "Question List Size: " + questionList.size());
        if(questionList.isEmpty()){
            return;
        }
        setDataQuestion(questionList.get(currentQuestion));

    }

    private void setDataQuestion(MiniGameQuestion miniGameQuestion) {
        if (miniGameQuestion == null)
            return;
        mMiniGameQuestion = miniGameQuestion;
        questionMiniGame.setText(miniGameQuestion.getQuestion());
        answerMiniGame.setText("");
        result.setText("");
    }

    private void initUI() {
        correctAnswer = findViewById(R.id.tv_correct_answers);
        questionMiniGame = findViewById(R.id.question_mini_game);
        answerMiniGame = findViewById(R.id.answer);
        btnSkip = findViewById(R.id.btn_skip);
        btnReply = findViewById(R.id.btn_reply);
        result = findViewById(R.id.result);
    }

    private List<MiniGameQuestion> getListQuestionMiniGame(){
        List<MiniGameQuestion> list = new ArrayList<>();
        list.add(new MiniGameQuestion("a/s/n/r/e/w","answer"));
        list.add(new MiniGameQuestion("u/e/s/q/o/n/i/t","question"));
        return list;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_skip)
            moveToNextQuestion();
        if (view.getId() == R.id.btn_reply){
            checkAnswer();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    moveToNextQuestion();
                }
            },2000);
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