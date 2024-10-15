package com.example.elitte.Page;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.HistoryTopicAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.Answer;
import com.example.elitte.entity.HistoryTopic;
import com.example.elitte.entity.Question;
import com.example.elitte.entity.Topic;

import java.util.ArrayList;
import java.util.List;

public class HistoryTopicPage extends AppCompatActivity {
    private GridView gridView;
    private List<HistoryTopic> historyTopicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_topic_page);

        addControl();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControl() {
        gridView = findViewById(R.id.gridview);
        historyTopicList = getHistoryTopicList();
        if (historyTopicList.isEmpty()) {
            return;
        }

        HistoryTopicAdapter adapter = new HistoryTopicAdapter(this,historyTopicList);
        gridView.setAdapter(adapter);
    }

    private List<HistoryTopic> getHistoryTopicList(){
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
        list.add(new HistoryTopic(new Topic(1,listQuestion1),9));
        List<Question> listQuestion2 = new ArrayList<>();

        listQuestion2.add(new Question(1, "The coffee usually _______ very strong at this café.", answerList1,
                "Sử dụng động từ \"is\" có thể hiểu là một sự mô tả khách quan về cà phê tại quán. Điều này có thể chỉ ra rằng cà phê được pha chế mạnh mẽ, hoặc thể hiện một đặc điểm chung của cà phê tại quán."));
        listQuestion2.add(new Question(2, "My sister __________ a talented musician.", answerList2,
                "Sister là danh từ số ít, chỉ một người."));
        listQuestion2.add(new Question(3, "She always __________ her lunch at noon.", answerList3,
                "Đối với ngôi thứ ba số ít, động từ have phải được chia thành has trong thì hiện tại đơn."));
        list.add(new HistoryTopic(new Topic(2,listQuestion2),5));
        return list;
    }
}