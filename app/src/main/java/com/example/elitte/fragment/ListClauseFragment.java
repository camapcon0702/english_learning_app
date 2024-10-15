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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elitte.Data.ClauseAdapter;
import com.example.elitte.Page.ClauseActivity;
import com.example.elitte.Page.GrammarPage;
import com.example.elitte.Page.ListClauseActivity;
import com.example.elitte.R;
import com.example.elitte.entity.Clause;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListClauseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListClauseFragment extends Fragment {

    private ListView lvClause;
    ArrayList<Clause> arrayList;
    private TextView btnBack;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListClauseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListClauseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListClauseFragment newInstance(String param1, String param2) {
        ListClauseFragment fragment = new ListClauseFragment();
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
        view = inflater.inflate(R.layout.activity_list_clause, container, false);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();

        return view;
    }

    public void addControls() {
        lvClause = view.findViewById(R.id.list_clause);
        btnBack = view.findViewById(R.id.back);

        arrayList = new ArrayList<>();
        arrayList.add(new Clause("Mệnh đề danh từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề tính từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề trạng từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));

        ClauseAdapter adapter = new ClauseAdapter(getContext(), R.layout.activity_list_tense, arrayList);
        lvClause.setAdapter(adapter);

    }

    private void addEvents() {
        lvClause.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Clause selectedItem = arrayList.get(i);
                Fragment fragment = new ClauseFragment();

                Bundle bundle = new Bundle();
                bundle.putString("clause_name", selectedItem.getNameClause());
                fragment.setArguments(bundle);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new GrammarFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
    }

}