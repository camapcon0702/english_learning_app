package com.example.elitte.Page;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.elitte.R;
import com.example.elitte.entity.Answer;
import com.example.elitte.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class ExercisePage extends AppCompatActivity implements View.OnClickListener {

    private TextView numberQuestion;
    private TextView contentQuestion;
    private LinearLayout optionA, optionB, optionC, optionD;
    private TextView answerA, answerB, answerC, answerD;
    private TextView explain;
    private Button btnNext;
    private List<Question> questionList;
    private Question mQuestion;
    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_page);

        addControl();
        addEvent();

    }

    private void addControl(){
        initUI();
        questionList = getListQuestion();
        if (questionList.isEmpty()) {
            return;
        }
        setDataQuestion(questionList.get(currentQuestion));
    }

    private void addEvent() {
        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    private void NextQuestion() {
        currentQuestion++;
        if (currentQuestion < questionList.size()) {
            resetOptionsBackground();
            setDataQuestion(questionList.get(currentQuestion));
        } else {
            currentQuestion = 0;
            resetOptionsBackground();
            setDataQuestion(questionList.get(currentQuestion));
        }
    }

    private void resetOptionsBackground() {
        optionA.setBackgroundResource(R.drawable.answer_background_default);
        optionB.setBackgroundResource(R.drawable.answer_background_default);
        optionC.setBackgroundResource(R.drawable.answer_background_default);
        optionD.setBackgroundResource(R.drawable.answer_background_default);
    }

    private void setDataQuestion(Question question) {
        if (question == null || question.getAnswerList() == null || question.getAnswerList().size() < 4)
            return;

        mQuestion = question;

        String nQuestion = "Question " + question.getNumber();
        numberQuestion.setText(nQuestion);
        contentQuestion.setText(question.getContent());
        answerA.setText(question.getAnswerList().get(0).getContent());
        answerB.setText(question.getAnswerList().get(1).getContent());
        answerC.setText(question.getAnswerList().get(2).getContent());
        answerD.setText(question.getAnswerList().get(3).getContent());
        explain.setText("");


    }


    private void initUI() {
        numberQuestion = findViewById(R.id.numbre_question);
        contentQuestion = findViewById(R.id.question);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);
        explain = findViewById(R.id.explain);
        btnNext = findViewById(R.id.nextButton);

    }

    private List<Question> getListQuestion() {
        List<Question> list = new ArrayList<>();

        // Câu hỏi 1
        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("am", false));
        answerList1.add(new Answer("be", false));
        answerList1.add(new Answer("is", true));
        answerList1.add(new Answer("are", false));

        list.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));

        // Câu hỏi 2
        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("am", false));
        answerList2.add(new Answer("is", true));
        answerList2.add(new Answer("be", false));
        answerList2.add(new Answer("are", false));

        list.add(new Question(2, "My sister __________ a talented musician.", answerList2,
                "Sister là danh từ số ít, chỉ một người."));

        // Câu hỏi 3
        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("have", false));
        answerList3.add(new Answer("has", true));
        answerList3.add(new Answer("having", false));
        answerList3.add(new Answer("had", false));

        list.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));

        return list;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.optionA){
            optionA.setBackgroundResource(R.drawable.answer_background_click);
            checkAnswer(optionA,mQuestion,mQuestion.getAnswerList().get(0));
        } else if (view.getId() == R.id.optionB) {
            optionB.setBackgroundResource(R.drawable.answer_background_click);
            checkAnswer(optionB,mQuestion,mQuestion.getAnswerList().get(1));
        } else if (view.getId() == R.id.optionC) {
            optionC.setBackgroundResource(R.drawable.answer_background_click);
            checkAnswer(optionC,mQuestion,mQuestion.getAnswerList().get(2));
        } else if (view.getId() == R.id.optionD) {
            optionD.setBackgroundResource(R.drawable.answer_background_click);
            checkAnswer(optionD,mQuestion,mQuestion.getAnswerList().get(3));
        }

        if(view.getId() == R.id.nextButton)
            NextQuestion();

    }

    private void checkAnswer(LinearLayout linearLayout, Question question, Answer answer){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.isCorrect()){
                    linearLayout.setBackgroundResource(R.drawable.answer_background_true);
                    showExplain(question);
                }else {
                    linearLayout.setBackgroundResource(R.drawable.answer_background_false);
                    showAnswerCorrent(question);
                    showExplain(question);
                }
            }
        },1000);
    }

    private void showExplain(Question question) {
        if (question == null )
            return;
        explain.setText(question.getExplain());
    }

    private void showAnswerCorrent(Question question) {
        if (question == null || question.getAnswerList() == null || question.getAnswerList().isEmpty())
            return;

        if (question.getAnswerList().get(0).isCorrect()){
            optionA.setBackgroundResource(R.drawable.answer_background_true);
        }else if (question.getAnswerList().get(1).isCorrect()){
            optionB.setBackgroundResource(R.drawable.answer_background_true);
        }else if (question.getAnswerList().get(2).isCorrect()){
            optionC.setBackgroundResource(R.drawable.answer_background_true);
        }else if (question.getAnswerList().get(3).isCorrect()){
            optionD.setBackgroundResource(R.drawable.answer_background_true);
        }
    }
}
