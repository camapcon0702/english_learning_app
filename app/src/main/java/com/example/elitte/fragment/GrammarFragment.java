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
import android.widget.GridView;
import android.widget.TextView;

import com.example.elitte.Data.GridItemAdapterHor;
import com.example.elitte.Page.GrammarPage;
import com.example.elitte.Page.LearningPage;
import com.example.elitte.Page.ListClauseActivity;
import com.example.elitte.Page.ListPartOfSpeechActivity;
import com.example.elitte.Page.ListTenseActivity;
import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.entity.GridItem;
import com.example.elitte.entity.Tense;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrammarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrammarFragment extends Fragment {

    TextView txtBack;
    GridView gridView;
    List<GridItem> gridItems;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GrammarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GrammarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GrammarFragment newInstance(String param1, String param2) {
        GrammarFragment fragment = new GrammarFragment();
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
        view = inflater.inflate(R.layout.activity_grammar_page, container, false);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.grammar_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();

        return view;
    }

    private void addControls(){
        gridView = view.findViewById(R.id.gridview);
        txtBack = view.findViewById(R.id.back);
        gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_tense, "12 Thì Cơ Bản"),
                new GridItem(R.drawable.icon_clause, "Mệnh đề"),
                new GridItem(R.drawable.icon_wordtype, "Từ loại")
        );
        GridItemAdapterHor adapterHor = new GridItemAdapterHor(getContext(), gridItems);
        gridView.setAdapter(adapterHor);
    }

    private void addEvents(){
        txtBack.setOnClickListener(e -> {
            Fragment fragment = new LearningFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.home_page, fragment);
            transaction.commit();
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment = null;
                switch (i) {
                    case 0:
                        fragment = new ListTenseFragment();
                        break;
                    case 1:
                        fragment = new ListClauseFragment();
                        break;
                    case 2:
                        fragment = new ListPartOfSpeechFragment();
                        break;
                }
                if (fragment != null) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.home_page, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}