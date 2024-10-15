package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elitte.Page.ListTenseActivity;
import com.example.elitte.Page.TenseActivity;
import com.example.elitte.R;
import com.example.elitte.entity.Tense;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TenseFragment extends Fragment {

    private TextView tvHeader;
    private TextView btnBack;
    private TextView tvName;
    private TextView tvAffirmative;
    private TextView tvNegative;
    private TextView tvQuestion;
    private TextView tvKeyUses;
    private TextView tvExample;
    private TextView tvSign;
    private Tense tense;
    private Intent intent;
    private String tenseName;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TenseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TenseFragment newInstance(String param1, String param2) {
        TenseFragment fragment = new TenseFragment();
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
        view = inflater.inflate(R.layout.activity_tense, container, false);
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
        return view;
    }
    public void addControls(){
        tvHeader = view.findViewById(R.id.header_tense_title);
        btnBack = view.findViewById(R.id.back);
        tvName = view.findViewById(R.id.tense_name);
        tvAffirmative = view.findViewById(R.id.affirmative_sentences);
        tvNegative = view.findViewById(R.id.negative_sentences);
        tvQuestion = view.findViewById(R.id.questions);
        tvKeyUses = view.findViewById(R.id.tense_key_uses);
        tvExample = view.findViewById(R.id.text_example);
        tvSign = view.findViewById(R.id.text_signs);

        tense = new Tense();


        if (getArguments() != null) {
            tenseName = getArguments().getString("tense_name");
        }

        tense.setNameTense(tenseName);

        tense.setAffirmative("(+) S + V(s, es)");
        tense.setNegative("(-) S + don't/doesn't + V");
        tense.setQuestion("(?) Do/Does + S + V");
        tense.setKeyUse("Diễn tả một sự thật hiển nhiên, một chân lý. \nDiễn tả 1 hành động xảy ra thường xuyên, một thói quen ở hiện tại. \nDiễn tả một năng lực của con người \nDiễn tả một kế hoạch đã được sắp xếp trong tương lai, đặc biệt là trong việc di chuyển.");
        tense.setExample("The sun rises in the East and sets in the West");
        tense.setSign("Every day/ week/ month… \nOften, usually, frequently \nSometimes, occasionally \nAlways, constantly \nSeldom, rarely");

        tvHeader.setText(tense.getNameTense());
        tvName.setText(tense.getNameTense());
        tvAffirmative.setText(tense.getAffirmative());
        tvNegative.setText(tense.getNegative());
        tvQuestion.setText(tense.getQuestion());
        tvKeyUses.setText(tense.getKeyUse());
        tvExample.setText(tense.getExample());
        tvSign.setText(tense.getSign());
    }

    public void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ListTenseFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
    }

}