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

import com.example.elitte.Page.ClauseActivity;
import com.example.elitte.Page.ListClauseActivity;
import com.example.elitte.R;
import com.example.elitte.entity.Clause;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClauseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClauseFragment extends Fragment {

    private TextView tvHeader, btnBack, tvName, tvStructure, tvKeyUse, tvExample;
    private Clause clause;
    private Intent intent;
    View view;
    private String clauseName;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClauseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClauseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClauseFragment newInstance(String param1, String param2) {
        ClauseFragment fragment = new ClauseFragment();
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
        view = inflater.inflate(R.layout.activity_clause, container, false);


        addControls();
        addEvents();

        return view;
    }

    public void addControls(){
        tvHeader = view.findViewById(R.id.header_clause_title);
        btnBack = view.findViewById(R.id.back);
        tvName = view.findViewById(R.id.clause_name);
        tvStructure = view.findViewById(R.id.clause_structure);
        tvKeyUse = view.findViewById(R.id.clause_key_uses);
        tvExample = view.findViewById(R.id.clause_example);

        clause = new Clause();

        if (getArguments() != null) {
            clauseName = getArguments().getString("clause_name");
        }

        clause.setNameClause(clauseName);

        clause.setStructure("[Liên từ + S + V] hoặc [Từ để hỏi + S + V]");
        clause.setKeyUse("Làm chủ ngữ, tân ngữ hoặc bổ ngữ.");
        clause.setExample("I don’t know what she wants. (Tân ngữ)\nWhat he said surprised me. (Chủ ngữ)\nThe problem is that he is late. (Bổ ngữ)");

        tvHeader.setText(clause.getNameClause());
        tvName.setText(clause.getNameClause());
        tvStructure.setText(clause.getStructure());
        tvKeyUse.setText(clause.getKeyUse());
        tvExample.setText(clause.getExample());
    }

    public void addEvents(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ListClauseFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
    }

}