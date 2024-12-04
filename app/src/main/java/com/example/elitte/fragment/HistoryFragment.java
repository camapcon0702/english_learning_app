//package com.example.elitte.fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.GridView;
//
//import com.example.elitte.Data.GridItemAdapterHor;
//import com.example.elitte.Data.HistoryTopicAdapter;
//import com.example.elitte.Page.NavigationMainActivity;
//import com.example.elitte.R;
//import com.example.elitte.entity.Answer;
//import com.example.elitte.entity.GridItem;
//import com.example.elitte.entity.HistoryTopic;
//import com.example.elitte.entity.Question;
//import com.example.elitte.entity.Topic;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HistoryFragment#newInstance} factory method to
// * * create an instance of this fragment.
// */
//public class HistoryFragment extends Fragment {
//
//    private GridView gridView;
//    private List<HistoryTopic> historyTopicList;
//    private View view;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public HistoryFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HistoryFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HistoryFragment newInstance(String param1, String param2) {
//        HistoryFragment fragment = new HistoryFragment();
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
//        view = inflater.inflate(R.layout.activity_history_topic_page, container, false);
//
//        addControl();
//        addEvent();
//
//        return view;
//    }
//
//    private void addEvent() {
//    }
//
//    private void addControl() {
//        gridView = view.findViewById(R.id.gridview);
//        historyTopicList = getHistoryTopicList();
//        if (historyTopicList.isEmpty()) {
//            return;
//        }
//
//        HistoryTopicAdapter adapter = new HistoryTopicAdapter(getContext(), historyTopicList);
//        gridView.setAdapter(adapter);
//    }
//
//    private List<HistoryTopic> getHistoryTopicList() {
//        List<HistoryTopic> list = new ArrayList<>();
//
//        List<Question> listQuestion1 = new ArrayList<>();
//
//        List<Answer> answerList1 = new ArrayList<>();
//        answerList1.add(new Answer("am", false));
//        answerList1.add(new Answer("be", false));
//        answerList1.add(new Answer("is", true));
//        answerList1.add(new Answer("are", false));
//
//        listQuestion1.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
//                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));
//
//        List<Answer> answerList2 = new ArrayList<>();
//        answerList2.add(new Answer("am", false));
//        answerList2.add(new Answer("is", true));
//        answerList2.add(new Answer("be", false));
//        answerList2.add(new Answer("are", false));
//
//        listQuestion1.add(new Question(2, "My sister __________ a talented musician.", answerList2,
//                "Sister là danh từ số ít, chỉ một người."));
//
//        List<Answer> answerList3 = new ArrayList<>();
//        answerList3.add(new Answer("have", false));
//        answerList3.add(new Answer("has", true));
//        answerList3.add(new Answer("having", false));
//        answerList3.add(new Answer("had", false));
//
//        listQuestion1.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
//                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));
//        list.add(new HistoryTopic(new Topic(1, listQuestion1), 9));
//        List<Question> listQuestion2 = new ArrayList<>();
//
//        listQuestion2.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
//                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));
//        listQuestion2.add(new Question(2, "My sister __________ a talented musician.", answerList2,
//                "Sister là danh từ số ít, chỉ một người."));
//        listQuestion2.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
//                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));
//        list.add(new HistoryTopic(new Topic(2, listQuestion2), 5));
//        return list;
//    }
//}


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

import com.example.elitte.Data.GridItemAdapterHor;
import com.example.elitte.Data.HistoryTopicAdapter;
import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.entity.Answer;
import com.example.elitte.entity.GridItem;
import com.example.elitte.entity.HistoryTopic;
import com.example.elitte.entity.Question;
import com.example.elitte.entity.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    private GridView gridView;
    private List<HistoryTopic> historyTopicList;
    private View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        view = inflater.inflate(R.layout.activity_history_topic_page, container, false);

        addControl();
        addEvent();

        return view;
    }

    private void addEvent() {
    }

    private void addControl() {
        gridView = view.findViewById(R.id.gridview);
        historyTopicList = getHistoryTopicList();
        if (historyTopicList.isEmpty()) {
            return;
        }

        HistoryTopicAdapter adapter = new HistoryTopicAdapter(getContext(), historyTopicList);
        gridView.setAdapter(adapter);
    }

    private List<HistoryTopic> getHistoryTopicList() {
        List<HistoryTopic> list = new ArrayList<>();

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
        list.add(new HistoryTopic(new Topic(1, listQuestion1), 9));
        List<Question> listQuestion2 = new ArrayList<>();

        listQuestion2.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));
        listQuestion2.add(new Question(2, "My sister __________ a talented musician.", answerList2,
                "Sister là danh từ số ít, chỉ một người."));
        listQuestion2.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));
        list.add(new HistoryTopic(new Topic(2, listQuestion2), 5));
        return list;
    }
}