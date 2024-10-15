package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;
import com.example.elitte.entity.Topic;

import java.util.ArrayList;

public class TopicPage extends AppCompatActivity {

    private TextView numberTopicTextView;
    private TextView sizeQuestionTextView;
    private TextView back;
    private Button btnStartTopic;
    private Topic selectedTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topic_page);

        addControl();
        addEvent();

    }

    private void addControl() {
        selectedTopic = getIntent().getParcelableExtra("selected_topic");

        numberTopicTextView = findViewById(R.id.number_topic);
        sizeQuestionTextView = findViewById(R.id.size_question);
        back = findViewById(R.id.back);
        btnStartTopic = findViewById(R.id.btn_start_topic);

        if (selectedTopic != null) {
            int numberTopic = selectedTopic.getNumberTopic();
            numberTopicTextView.setText("Bộ đề " + numberTopic);

            int questionCount = selectedTopic.getListQuestion().size();
            sizeQuestionTextView.setText("Số câu: " + questionCount);
        }

    }

    private void addEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicPage.this, TopicsPage.class);
                startActivity(intent);
            }
        });

        btnStartTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicPage.this, ExercisePage.class);
                intent.putParcelableArrayListExtra("listQuestion", (ArrayList<? extends Parcelable>) selectedTopic.getListQuestion());
                startActivity(intent);
            }
        });
    }


}