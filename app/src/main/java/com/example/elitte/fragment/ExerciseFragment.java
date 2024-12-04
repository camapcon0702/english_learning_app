package com.example.elitte.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.ListExamSet;
import com.example.elitte.Models.Questions;
import com.example.elitte.Models.UserExamset;
import com.example.elitte.Models.UserResponse;
import com.example.elitte.R;
import com.example.elitte.Retrofit.ExerciseAPI;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.Retrofit.UserAPI;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment implements View.OnClickListener{

    TextView txtBack, txtDiem;
    GridView gridView;
    View view;
    ImageButton btnAmThanh;
    private TextView numberQuestion;
    private TextView contentQuestion;
    private LinearLayout optionA, optionB, optionC, optionD;
    private TextView answerA, answerB, answerC, answerD;
    private TextView explain;
    private Button btnNext;

    private int currentQuestion = 0;
//    private TextView txtBack;
    private int correctAnswersCount = 0;

    private ListExamSet selectedExamSet;
    private List<Questions> listQuestion;

    private boolean isAnswered = false;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExerciseFragment newInstance(String param1, String param2) {
        ExerciseFragment fragment = new ExerciseFragment();
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
        view = inflater.inflate(R.layout.activity_exercise_page, container, false);

        Bundle bundle = getArguments();
        selectedExamSet = (ListExamSet) bundle.getSerializable("selected_exam_set");
        listQuestion = new ArrayList<>();
        getAllQuestionFromExamSet(selectedExamSet.getId());

        addControl();
        addEvent();

        return view;
    }

    private void addControl() {
        initUI();
        getAllQuestionFromExamSet(selectedExamSet.getId());
    }

    private void addEvent() {
        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HomeExerciseFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
    }

//    private void NextQuestion() {
//        currentQuestion++;
//        if (currentQuestion < listQuestion.size()) {
//            resetOptionsBackground();
//            setDataQuestions(listQuestion.get(currentQuestion));
//        } else {
//
//            btnNext.setText("Kết thúc");
//        }
//
//        enableOptions();
//        isAnswered = false;
//    }

    private void NextQuestion() {
        if (currentQuestion + 1 < listQuestion.size()) {
            currentQuestion++;
            resetOptionsBackground();
            setDataQuestions(listQuestion.get(currentQuestion));
            enableOptions();
            btnNext.setText("Tiếp tục");
        } else {
            btnNext.setText("Kết thúc");

            saveHistory();
        }
        isAnswered = false;
    }


    private void enableOptions() {
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }


    private void resetOptionsBackground() {
        optionA.setBackgroundResource(R.drawable.answer_background_default);
        optionB.setBackgroundResource(R.drawable.answer_background_default);
        optionC.setBackgroundResource(R.drawable.answer_background_default);
        optionD.setBackgroundResource(R.drawable.answer_background_default);
    }



    private void setDataQuestions(Questions question) {

        String nQuestion = "Question " + question.getNumberQuestion();
        numberQuestion.setText(nQuestion);



        if (question.getName() != null && !question.getName().trim().isEmpty()) {
            contentQuestion.setVisibility(View.VISIBLE);
            contentQuestion.setText(question.getName());
        } else {
            contentQuestion.setVisibility(View.GONE);
        }


        if (question.getSound() != null && !question.getSound().toString().trim().isEmpty()) {
            btnAmThanh.setVisibility(View.VISIBLE);
        } else {
            btnAmThanh.setVisibility(View.GONE);
        }


        answerA.setText(question.getOption1());
        answerB.setText(question.getOption2());
        answerC.setText(question.getOption3());
        answerD.setText(question.getOption4());
        explain.setText("");
    }



    private void initUI() {
        numberQuestion = view.findViewById(R.id.number_question);
        contentQuestion = view.findViewById(R.id.question);
        optionA = view.findViewById(R.id.optionA);
        optionB = view.findViewById(R.id.optionB);
        optionC = view.findViewById(R.id.optionC);
        optionD = view.findViewById(R.id.optionD);
        answerA = view.findViewById(R.id.answerA);
        answerB = view.findViewById(R.id.answerB);
        answerC = view.findViewById(R.id.answerC);
        answerD = view.findViewById(R.id.answerD);
        explain = view.findViewById(R.id.explain);
        btnNext = view.findViewById(R.id.nextButton);
        txtBack = view.findViewById(R.id.back);
        txtDiem = view.findViewById(R.id.diem);
        btnAmThanh = view.findViewById(R.id.amThanh);
    }





    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.optionA) {
            handleOptionClick(optionA, listQuestion.get(currentQuestion).getOption1());
        } else if (viewId == R.id.optionB) {
            handleOptionClick(optionB, listQuestion.get(currentQuestion).getOption2());
        } else if (viewId == R.id.optionC) {
            handleOptionClick(optionC, listQuestion.get(currentQuestion).getOption3());
        } else if (viewId == R.id.optionD) {
            handleOptionClick(optionD, listQuestion.get(currentQuestion).getOption4());
        } else if (viewId == R.id.nextButton) {
            NextQuestion();
        }
    }

    private void handleOptionClick(LinearLayout selectedOption, String selectedAnswer) {
        if (isAnswered) return;

        resetOptionsBackground();
        selectedOption.setBackgroundResource(R.drawable.answer_background_click);

        String correctAnswer = listQuestion.get(currentQuestion).getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            selectedOption.setBackgroundResource(R.drawable.answer_background_true);
            correctAnswersCount++;
            txtDiem.setText("Điểm Số: " + correctAnswersCount);
            showExplain(listQuestion.get(currentQuestion));
        } else {
            selectedOption.setBackgroundResource(R.drawable.answer_background_false);
            showCorrectAnswer(listQuestion.get(currentQuestion));
            showExplain(listQuestion.get(currentQuestion));
        }

        isAnswered = true;
        disableOptions();
    }


    private void disableOptions() {
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);
    }

//hello

    private void showCorrectAnswer(Questions question) {
        if (question.getOption1().equalsIgnoreCase(question.getCorrectAnswer())) {
            optionA.setBackgroundResource(R.drawable.answer_background_true);
        } else if (question.getOption2().equalsIgnoreCase(question.getCorrectAnswer())) {
            optionB.setBackgroundResource(R.drawable.answer_background_true);
        } else if (question.getOption3().equalsIgnoreCase(question.getCorrectAnswer())) {
            optionC.setBackgroundResource(R.drawable.answer_background_true);
        } else if (question.getOption4().equalsIgnoreCase(question.getCorrectAnswer())) {
            optionD.setBackgroundResource(R.drawable.answer_background_true);
        }
    }




    private void showExplain(Questions question) {
        if (question == null )
            return;
        explain.setText(question.getExplainCorrectAnswer());
    }



    private void getAllQuestionFromExamSet(int id) {
        String token = TokenManager.getToken(getContext());
        ExerciseAPI api = RetrofitInstance.getRetrofitInstance(token).create(ExerciseAPI.class);
        Call<List<Questions>> call = api.getAllQuestionOfExamSet(id);

        call.enqueue(new Callback<List<Questions>>() {
            @Override
            public void onResponse(Call<List<Questions>> call, Response<List<Questions>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listQuestion = response.body();
                    if (!listQuestion.isEmpty()) {
                        setDataQuestions(listQuestion.get(currentQuestion));
                    }
                    Log.d("API_SUCCESS", "Received questions: " + listQuestion.size());
                } else {
                    Log.e("API_ERROR", "Response unsuccessful or empty body");
                }
            }

            @Override
            public void onFailure(Call<List<Questions>> call, Throwable t) {
                Log.e("API_ERROR", "API call failed: " + t.getMessage());
            }
        });
    }

    

    private void saveHistory() {
        String token = TokenManager.getToken(getContext());
        ExerciseAPI api = RetrofitInstance.getRetrofitInstance(token).create(ExerciseAPI.class);
        UserAPI userApi = RetrofitInstance.getRetrofitInstance(token).create(UserAPI.class);

        userApi.getUserProfile().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserResponse currentUser = response.body();

                    UserExamset userExamset = new UserExamset();
                    userExamset.setExamSet(selectedExamSet);
                    userExamset.setDiem(correctAnswersCount);
                    userExamset.setUser(currentUser);

                    Call<UserExamset> saveCall = api.saveHistory(userExamset);
                    saveCall.enqueue(new Callback<UserExamset>() {
                        @Override
                        public void onResponse(Call<UserExamset> call, Response<UserExamset> response) {
                            if (response.isSuccessful()) {
                                Log.d("API_SUCCESS", "History saved successfully");
                                navigateToResultPage();
                            } else {
                                Log.e("API_ERROR", "Failed to save history: " + response.errorBody());
                            }
                        }

                        @Override
                        public void onFailure(Call<UserExamset> call, Throwable t) {
                            Log.e("API_ERROR", "API call failed: " + t.getMessage());
                        }
                    });
                } else {
                    Log.e("API_ERROR", "Failed to get user profile: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API_ERROR", "Failed to fetch user profile: " + t.getMessage());
            }
        });
    }


    private void navigateToResultPage() {
        Fragment fragment = new TopicFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_page, fragment);
        transaction.commit();
    }



}