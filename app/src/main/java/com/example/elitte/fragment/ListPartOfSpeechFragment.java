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

import com.example.elitte.Data.PartOfSpeechAdapter;
import com.example.elitte.Page.GrammarPage;
import com.example.elitte.Page.ListPartOfSpeechActivity;
import com.example.elitte.Page.PartOfSpeechActivity;
import com.example.elitte.R;
import com.example.elitte.entity.PartOfSpeech;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListPartOfSpeechFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListPartOfSpeechFragment extends Fragment {

    private ListView lvPartOfSpeech;
    ArrayList<PartOfSpeech> arrayList;
    private TextView btnBack;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListPartOfSpeechFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListPartOfSpeechFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListPartOfSpeechFragment newInstance(String param1, String param2) {
        ListPartOfSpeechFragment fragment = new ListPartOfSpeechFragment();
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
        view = inflater.inflate(R.layout.activity_list_part_of_speech, container, false);
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
        lvPartOfSpeech = view.findViewById(R.id.list_part_of_speech);
        arrayList = new ArrayList<>();
        arrayList.add(new PartOfSpeech("Danh từ (Noun)", "Là những từ chỉ người, sự vật, địa điểm hay hiện tượng cụ thể."));
        arrayList.add(new PartOfSpeech("Động từ (Verb)", "Những từ chỉ hành động và trạng thái của một người, sự vật hay hiện tượng nào đó."));
        arrayList.add(new PartOfSpeech("Tính từ (Adjective)", "Những từ chỉ tính chất, đặc điểm của người, vật hay hiện tượng."));
        arrayList.add(new PartOfSpeech("Trạng từ (Adverb)", "Là những từ bổ nghĩa thêm cho tính từ, chỉ trạng thái hay tính chất của một sự vật/hiện tượng. "));
        arrayList.add(new PartOfSpeech("Giới từ (Preposition)", "Là những từ biểu thị tính liên quan giữa các sự vật, hiện tượng bất kỳ."));
        arrayList.add(new PartOfSpeech("Liên từ (Conjunction)", "Là những từ dùng để nối kết các từ, cụm từ, mệnh đề, và ý nghĩa trong một câu."));
        arrayList.add(new PartOfSpeech("Thán từ (Interjection)", "Những từ dùng để thể hiện cảm xúc của người nói. "));
        arrayList.add(new PartOfSpeech("Đại từ (Pronoun)", "Những từ chỉ người hay sự vật, được dùng nhằm thay thế cho cụm từ/danh từ cụ thể đã xác định trong câu để giảm thiểu việc lặp lại nhiều lần, khiến câu mất đi tính tự nhiên."));
        arrayList.add(new PartOfSpeech("Từ hạn định (Determiner)", "Từ hạn định là từ đứng trước một danh từ hoặc cụm danh từ nhằm giới hạn và xác định danh từ/ cụm danh từ đó, qua đó góp phần làm rõ nghĩa cho các sự vật, sự việc, con người được đề cập đến trong câu."));

        PartOfSpeechAdapter adapter = new PartOfSpeechAdapter(getContext(), R.layout.part_of_speech_item, arrayList);
        lvPartOfSpeech.setAdapter(adapter);
    }

    public void addEvents() {
        lvPartOfSpeech.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PartOfSpeech selectedItem = arrayList.get(i);
                Fragment fragment = new PartOfSpeechFragment();

                Bundle bundle = new Bundle();
                bundle.putString("pos_name", selectedItem.getNamePoS());
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