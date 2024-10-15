package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.elitte.Page.ExercisePage;
import com.example.elitte.Page.TopicPage;
import com.example.elitte.Page.TopicsPage;
import com.example.elitte.R;
import com.example.elitte.entity.Question;
import com.example.elitte.entity.Topic;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicFragment extends Fragment {

    private TextView numberTopicTextView;
    private TextView sizeQuestionTextView;
    private TextView back;
    private Button btnStartTopic;
    private Topic selectedTopic;

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopicFragment newInstance(String param1, String param2) {
        TopicFragment fragment = new TopicFragment();
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
        view = inflater.inflate(R.layout.activity_topic_page, container, false);

        addControl();
        addEvent();

        return view;
    }

    private void addControl() {
        if (getArguments() != null) {
            selectedTopic = (Topic) getArguments().getParcelable("selected_topic");
        }

        numberTopicTextView = view.findViewById(R.id.number_topic);
        sizeQuestionTextView = view.findViewById(R.id.size_question);
        back = view.findViewById(R.id.back);
        btnStartTopic = view.findViewById(R.id.btn_start_topic);

        if (selectedTopic != null) {
            int numberTopic = selectedTopic.getNumberTopic();
            numberTopicTextView.setText("Bộ đề " + numberTopic);

            int questionCount = selectedTopic.getListQuestion().size();
            sizeQuestionTextView.setText("Số câu: " + questionCount);
        }

    }

    private void addEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(TopicPage.this, TopicsPage.class);
//                startActivity(intent);
                Fragment fragment = new TopicsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });

        btnStartTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(TopicPage.this, ExercisePage.class);
//                intent.putParcelableArrayListExtra("listQuestion", (ArrayList<? extends Parcelable>) selectedTopic.getListQuestion());
//                startActivity(intent);
                ArrayList<Question> listQuestion = (ArrayList<Question>) selectedTopic.getListQuestion();
                Fragment fragment = new ExerciseFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("listQuestion", listQuestion);
                fragment.setArguments(bundle);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();

            }
        });
    }

}