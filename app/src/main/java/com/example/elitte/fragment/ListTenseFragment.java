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

import com.example.elitte.Data.TenseAdapter;
import com.example.elitte.Page.GrammarPage;
import com.example.elitte.Page.ListTenseActivity;
import com.example.elitte.Page.TenseActivity;
import com.example.elitte.R;
import com.example.elitte.entity.Tense;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListTenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTenseFragment extends Fragment {

    private ListView lvTense;
    ArrayList<Tense> arrayList;
    private TextView btnBack;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListTenseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTenseFragment newInstance(String param1, String param2) {
        ListTenseFragment fragment = new ListTenseFragment();
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
        view = inflater.inflate(R.layout.activity_list_tense, container, false);
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
        btnBack = view.findViewById(R.id.back);
        lvTense = view.findViewById(R.id.list_tense);
        arrayList = new ArrayList<>();
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại hoàn thành", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại hoàn thành tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì quá khứ đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì quá khứ tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì quá khứ hoàn thành", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì quá khứ hoàn thành tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì tương lai đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì tương lai tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì tương lai hoàn thành", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì tương lai hoàn thành tiếp diễn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));

        TenseAdapter adapter = new TenseAdapter(getContext(), R.layout.activity_list_tense, arrayList);
        lvTense.setAdapter(adapter);
    }

    public void addEvents(){
        lvTense.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tense selectedTense = arrayList.get(i);
                Fragment fragment = new TenseFragment();

                Bundle bundle = new Bundle();
                bundle.putString("tense_name", selectedTense.getNameTense());
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