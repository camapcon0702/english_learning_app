package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.entity.MiniGameQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiniGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiniGameFragment extends Fragment implements View.OnClickListener {

    private TextView correctAnswer;
    private TextView questionMiniGame;
    private EditText answerMiniGame;
    private TextView result;
    private Button btnSkip, btnReply;
    private List<MiniGameQuestion> questionList;
    private MiniGameQuestion mMiniGameQuestion;
    private int correctAnswerCount = 0;
    private int currentQuestion = 0;
    View view;
    private TextView txtBack;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MiniGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiniGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MiniGameFragment newInstance(String param1, String param2) {
        MiniGameFragment fragment = new MiniGameFragment();
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
        view = inflater.inflate(R.layout.activity_mini_game_page, container, false);

        addControl();
        addEvent();

        return view;
    }

    private void addEvent() {
        btnSkip.setOnClickListener(this);
        btnReply.setOnClickListener(this);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NavigationMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControl(){
        initUI();
        questionList = getListQuestionMiniGame();
        Log.d("MiniGamePage", "Question List Size: " + questionList.size());
        if(questionList.isEmpty()){
            return;
        }
        setDataQuestion(questionList.get(currentQuestion));

        txtBack = view.findViewById(R.id.back);
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
        correctAnswer = view.findViewById(R.id.tv_correct_answers);
        questionMiniGame = view.findViewById(R.id.question_mini_game);
        answerMiniGame = view.findViewById(R.id.answer);
        btnSkip = view.findViewById(R.id.btn_skip);
        btnReply = view.findViewById(R.id.btn_reply);
        result = view.findViewById(R.id.result);
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