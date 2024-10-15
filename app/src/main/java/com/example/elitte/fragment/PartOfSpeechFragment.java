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

import com.example.elitte.Page.ListPartOfSpeechActivity;
import com.example.elitte.Page.PartOfSpeechActivity;
import com.example.elitte.R;
import com.example.elitte.entity.PartOfSpeech;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartOfSpeechFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartOfSpeechFragment extends Fragment {

    private TextView tvHeader;
    private TextView btnBack;
    private TextView tvName;
    private TextView tvPosition;
    private TextView tvSign;
    private TextView tvExample;
    private Intent intent;
    private PartOfSpeech partOfSpeech;
    View view;
    private String posName;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PartOfSpeechFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartOfSpeechFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PartOfSpeechFragment newInstance(String param1, String param2) {
        PartOfSpeechFragment fragment = new PartOfSpeechFragment();
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
        view = inflater.inflate(R.layout.activity_part_of_speech, container, false);
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
        tvHeader = view.findViewById(R.id.header_title_part_of_speech);
        btnBack = view.findViewById(R.id.back);
        tvName = view.findViewById(R.id.part_of_speech_name);
        tvPosition = view.findViewById(R.id.part_of_speech_position);
        tvSign = view.findViewById(R.id.part_of_speech_sign);
        tvExample = view.findViewById(R.id.part_of_speech_example);

        partOfSpeech = new PartOfSpeech();

        if (getArguments() != null) {
            posName = getArguments().getString("pos_name");
        }

        partOfSpeech.setNamePoS(posName);
        partOfSpeech.setPosition("Đứng đầu câu và sau trạng từ chỉ thời gian\nĐứng sau tính từ thường\nĐứng sau các tính từ sở hữu\nĐứng sau động từ khi làm tân ngữ\nĐứng sau 'enough'\nĐứng sau các mạo từ như: a, an, the hoặc các từ chỉ định như this, that, these, those,... \nĐứng sau các từ như each, every, all, both, no, some, any, few, a few, little, a little,...\nĐứng sau giới từ như in, on, of, with, under, about, at,...");
        partOfSpeech.setSign("Hậu tố: -tion, -sion, -ment, -ce, -ness, -er/or, -ity/ty, -ship, -ics, -dom, -ture, -ism, -phy, -logy, -cy, -an/ian, -ette, -itude, -age, -th, -ry/try, -hood");
        partOfSpeech.setExample("car (ô tô)\nlady (người phụ nữ)\nParis (thành phố Paris)");

        tvHeader.setText(partOfSpeech.getNamePoS());
        tvName.setText(partOfSpeech.getNamePoS());
        tvPosition.setText(partOfSpeech.getPosition());
        tvSign.setText(partOfSpeech.getSign());
        tvExample.setText(partOfSpeech.getExample());

    }

    public void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ListPartOfSpeechFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, fragment);
                transaction.commit();
            }
        });
    }
}