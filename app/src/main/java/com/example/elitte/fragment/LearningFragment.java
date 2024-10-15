package com.example.elitte.fragment;

import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.elitte.R;
import com.example.elitte.entity.GridItem;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    TextView txtBack;
    GridView gridView;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();
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
        view = inflater.inflate(R.layout.activity_learning_page, container, false);
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.learning_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvent();

        return view;
    }
    private void addControls(){

        gridView = view.findViewById(R.id.gridview);
        txtBack = view.findViewById(R.id.back);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_grammar, "Ngữ pháp"),
                new GridItem(R.drawable.icon_vocabulary, "Từ vựng")
        );

//        GridItemAdapterHor adapterHor = new GridItemAdapterHor(getActivity(), gridItems);
//
//        gridView.setAdapter(adapterHor);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        Intent intent = new Intent(LearningPage.this, GrammarPage.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        Intent intent1 = new Intent(LearningPage.this, VocabularyPage.class);
//                        startActivity(intent1);
//                        break;
//
//                }
//            }
//        });

    }

    private void addEvent(){
        txtBack.setOnClickListener(e -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.exercise, new HomeFragment());
            transaction.commit();
        });


    }
}