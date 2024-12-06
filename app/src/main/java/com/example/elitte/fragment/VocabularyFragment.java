//package com.example.elitte.fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.TextView;
//
//import com.example.elitte.Data.GridItemAdapterVer;
//import com.example.elitte.Page.LearningPage;
//import com.example.elitte.Page.VocabularyPage;
//import com.example.elitte.R;
//import com.example.elitte.entity.GridItem;
//import com.example.elitte.entity.WordItem;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link VocabularyFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class VocabularyFragment extends Fragment {
//
//    GridView gridView;
//    TextView txtBack;
//    View view;
//    List<GridItem> gridItems;
//
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public VocabularyFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment VocabularyFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static VocabularyFragment newInstance(String param1, String param2) {
//        VocabularyFragment fragment = new VocabularyFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view = inflater.inflate(R.layout.activity_vocabulary, container, false);
//
//        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.exercise), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        addControls();
//        addEvents();
//
//        return view;
//
//    }
//
//    private void addControls(){
//        gridView = view.findViewById(R.id.gridview);
//        txtBack = view.findViewById(R.id.back);
//
//        gridItems = Arrays.asList(
//                new GridItem(R.drawable.icon_country, "Quốc gia"),
//                new GridItem(R.drawable.icon_traffic, "Giao thông"),
//                new GridItem(R.drawable.icon_animal, "Động vật"),
//                new GridItem(R.drawable.icon_environment, "Môi trường"),
//                new GridItem(R.drawable.icon_food, "Món ăn"),
//                new GridItem(R.drawable.icon_travel, "Du lịch")
//        );
//
//        GridItemAdapterVer adapterVer = new GridItemAdapterVer(getContext(), gridItems);
//        gridView.setAdapter(adapterVer);
//    }
//
//    private void addEvents(){
//        txtBack.setOnClickListener(e -> {
//            Fragment fragment = new LearningFragment();
//            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.home_page, fragment);
//            transaction.commit();
//        });
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                GridItem wordItem = gridItems.get(i);
//
//                Fragment fragment = new WordFragment();
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.home_page, fragment);
//                transaction.commit();
//            }
//        });
//    }
//
//}
package com.example.elitte.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.elitte.Data.GridItemAdapterVer;
import com.example.elitte.JWT.TokenManager;
import com.example.elitte.R;
import com.example.elitte.Retrofit.QuestionsApi;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.entity.GridItem;
import com.example.elitte.Models.TypeOfVocabulary;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VocabularyFragment extends Fragment {

    private GridView gridView;
    private TextView txtBack;
    private View view;
    private List<GridItem> gridItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_vocabulary, container, false);



        addControls();
        addEvents();

        return view;
    }

    private void addControls() {
        gridView = view.findViewById(R.id.gridview);
        txtBack = view.findViewById(R.id.back);

        fetchDataFromApi();  // Gọi API để lấy dữ liệu
    }

    private void fetchDataFromApi() {
        String token = TokenManager.getToken(getContext());
        QuestionsApi api = RetrofitInstance.getRetrofitInstance(token).create(QuestionsApi.class);
        Call<List<TypeOfVocabulary>> call = api.getAllTypeOfVocabulary();

        call.enqueue(new Callback<List<TypeOfVocabulary>>() {
            @Override
            public void onResponse(Call<List<TypeOfVocabulary>> call, Response<List<TypeOfVocabulary>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    gridItems = new ArrayList<>();
                    for (TypeOfVocabulary vocab : response.body()) {
                        int iconResId = getResources().getIdentifier(vocab.getIconRes(), "drawable", getContext().getPackageName());
                        gridItems.add(new GridItem(iconResId, vocab.getTitle(), vocab.getId()));
                    }
                    GridItemAdapterVer adapterVer = new GridItemAdapterVer(getContext(), gridItems);
                    gridView.setAdapter(adapterVer);
                } else {
                    Toast.makeText(getContext(), "Không có dữ liệu từ API!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<TypeOfVocabulary>> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addEvents() {
        txtBack.setOnClickListener(e -> {
            Fragment fragment = new LearningFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.home_page, fragment);
            transaction.commit();
        });

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {

            GridItem selectedItem = gridItems.get(i);

            Fragment fragment = new WordFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("typeId", selectedItem.getId());
            fragment.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.home_page, fragment);
            transaction.commit();
        });
    }

}



