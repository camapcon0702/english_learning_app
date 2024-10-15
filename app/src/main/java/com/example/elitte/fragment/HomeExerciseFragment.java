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
import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.entity.GridItem;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeExerciseFragment extends Fragment {

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

    public HomeExerciseFragment() {
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
    public static HomeExerciseFragment newInstance(String param1, String param2) {
        HomeExerciseFragment fragment = new HomeExerciseFragment();
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
        view = inflater.inflate(R.layout.activity_home_exercise_page, container, false);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.exercise), (v, insets) -> {
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

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_speakingskill, "Luyện phần đọc"),
                new GridItem(R.drawable.icon_listeningskill, "Luyện phần nghe")
        );

        GridItemAdapterHor adapterHor = new GridItemAdapterHor(getContext(), gridItems);

        gridView.setAdapter(adapterHor);
    }

    private void addEvents(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment selectedFragment = null;
                switch (i) {
                    case 0:
                        selectedFragment = new TopicsFragment();
                        break;
                    case 1:
                        selectedFragment = new TopicsFragment();
                        break;
                    default:
                        return;
                }
                if (selectedFragment != null) {
                    // Sử dụng FragmentManager và FragmentTransaction để thay thế Fragment
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.home_page, selectedFragment);  // R.id.fragment_container là nơi mà Fragment Home hiện tại đang nằm
                    transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại bằng nút Back
                    transaction.commit();  // Hoàn thành giao dịch
                }
            }
        });

        txtBack.setOnClickListener(e ->{
//            Fragment fragment = new HomeFragment();
//            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.main, fragment);
////            transaction.addToBackStack(null);
//            transaction.commit();
            Intent intent = new Intent(getActivity(), NavigationMainActivity.class);
            startActivity(intent);
        });
    }

}