package com.example.elitte.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.elitte.Data.TopicAdapter;
import com.example.elitte.Page.TopicPage;
import com.example.elitte.Page.TopicsPage;
import com.example.elitte.R;
import com.example.elitte.entity.Answer;
import com.example.elitte.entity.Question;
import com.example.elitte.entity.Topic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopicsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicsFragment extends Fragment {

    private GridView gridView;
    private List<Topic> topicList;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopicsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopicsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopicsFragment newInstance(String param1, String param2) {
        TopicsFragment fragment = new TopicsFragment();
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
        view = inflater.inflate(R.layout.activity_topics_page, container, false);
        addControl();
        addEvent();
        return view;
    }

    private void addEvent() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Topic selectedTopic = topicList.get(position);

//                Intent intent = new Intent(TopicsPage.this, TopicPage.class);
//                intent.putExtra("selected_topic", selectedTopic);
//                startActivity(intent);

// Tạo một fragment mới
                Fragment topicPageFragment = new TopicFragment();

// Truyền dữ liệu (selectedTopic) vào Fragment thông qua Bundle
                Bundle bundle = new Bundle();
                bundle.putParcelable("selected_topic", selectedTopic);
                topicPageFragment.setArguments(bundle);

// Thực hiện Fragment Transaction để thay thế fragment hiện tại bằng TopicPageFragment
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, topicPageFragment)  // R.id.fragment_container là ID của container chứa fragment trong layout của bạn
//                        .addToBackStack(null)  // Thêm vào back stack để có thể quay lại
//                        .commit();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page, topicPageFragment);
                transaction.commit();

            }
        });
    }

    private void addControl() {
        gridView = view.findViewById(R.id.gridview);

        topicList = getTopicList();

        if (topicList.isEmpty()) {
            return;
        }
        TopicAdapter topicAdapter = new TopicAdapter(getContext(),topicList);
        gridView.setAdapter(topicAdapter);

    }

    private List<Topic> getTopicList(){

        List<Topic> listTopic = new ArrayList<>();

        List<Question> listQuestion1 = new ArrayList<>();

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("am", false));
        answerList1.add(new Answer("be", false));
        answerList1.add(new Answer("is", true));
        answerList1.add(new Answer("are", false));

        listQuestion1.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("am", false));
        answerList2.add(new Answer("is", true));
        answerList2.add(new Answer("be", false));
        answerList2.add(new Answer("are", false));

        listQuestion1.add(new Question(2, "My sister __________ a talented musician.", answerList2,
                "Sister là danh từ số ít, chỉ một người."));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("have", false));
        answerList3.add(new Answer("has", true));
        answerList3.add(new Answer("having", false));
        answerList3.add(new Answer("had", false));

        listQuestion1.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));

        listTopic.add(new Topic(1,listQuestion1));

        List<Question> listQuestion2 = new ArrayList<>();

        listQuestion2.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));
        listQuestion2.add(new Question(2, "My sister __________ a talented musician.", answerList2,
                "Sister là danh từ số ít, chỉ một người."));
        listQuestion2.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));

        listTopic.add(new Topic(2,listQuestion2));
        return listTopic;
    }
}