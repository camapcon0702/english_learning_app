package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.TopicAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.Answer;
import com.example.elitte.entity.Question;
import com.example.elitte.entity.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopicsPage extends AppCompatActivity {
    private GridView gridView;
    private List<Topic> topicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topics_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControl();
        addEvent();
    }

    private void addEvent() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Topic selectedTopic = topicList.get(position);

                Intent intent = new Intent(TopicsPage.this, TopicPage.class);
                intent.putExtra("selected_topic", selectedTopic);
                startActivity(intent);
            }
        });
    }

    private void addControl() {
        gridView = findViewById(R.id.gridview);

        topicList = getTopicList();

        if (topicList.isEmpty()) {
            return;
        }
        TopicAdapter topicAdapter = new TopicAdapter(this,topicList);
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