package com.example.elitte.fragment;

import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.elitte.Data.GridItemAdapterVer;
import com.example.elitte.R;
import com.example.elitte.entity.GridItem;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    GridView gridView;
    View view;
    private ViewPager2 viewPager;
//    private View mView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        view = inflater.inflate(R.layout.activity_home_page, container, false);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.home_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();

        return view;
    }

    public void addControls(){

        gridView = view.findViewById(R.id.gridview);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_learning, "Học tập"),
                new GridItem(R.drawable.icon_execise, "Bài tập"),
                new GridItem(R.drawable.icon_flashcard, "Flash card"),
                new GridItem(R.drawable.icon_minigamr, "Mini game"),
                new GridItem(R.drawable.icon_calendar, "Lịch học")
        );

        GridItemAdapterVer adapter = new GridItemAdapterVer(getContext(), gridItems);
        gridView.setAdapter(adapter);


    }

    public void addEvents(){
        // set sự kiện khi nhấn vào từng item
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        Intent intent = new Intent(getActivity(), LearningPage.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        Intent intent1 = new Intent(getActivity(), HomeExercisePage.class);
//                        startActivity(intent1);
//                        break;
//                    case 2:
//                        Intent intent2 = new Intent(getActivity(), FlashcardsActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                }
//            }
//        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment selectedFragment = null;

                // Tạo một Fragment mới dựa trên vị trí nhấn
                switch (position) {
                    case 0:
                        selectedFragment = new LearningFragment();  // Thay thế bằng Fragment mới
                        break;
                    case 1:
                        selectedFragment = new HomeExerciseFragment();  // Thay thế bằng Fragment mới
                        break;
                    case 2:
                        selectedFragment = new FlashCardsFragment();  // Thay thế bằng Fragment mới
                        break;
                    case 3:
                        selectedFragment = new MiniGameFragment();
                        break;
                    default:
                        // Nếu vị trí không hợp lệ, không làm gì
                        return;
                }

                // Kiểm tra xem Fragment có null hay không trước khi thực hiện thay thế
                if (selectedFragment != null) {
                    // Sử dụng FragmentManager và FragmentTransaction để thay thế Fragment
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.home_page, selectedFragment);  // R.id.fragment_container là nơi mà Fragment Home hiện tại đang nằm
                    transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại bằng nút Back
                    transaction.commit();  // Hoàn thành giao dịch
                }
            }
        });
    }

}