package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;
import com.example.elitte.entity.PartOfSpeech;

public class PartOfSpeechActivity extends AppCompatActivity {

    private TextView tvHeader;
    private TextView btnBack;
    private TextView tvName;
    private TextView tvPosition;
    private TextView tvSign;
    private TextView tvExample;
    private Intent intent;
    private PartOfSpeech partOfSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_part_of_speech);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls() {
        tvHeader = findViewById(R.id.header_title_part_of_speech);
        btnBack = findViewById(R.id.back);
        tvName = findViewById(R.id.part_of_speech_name);
        tvPosition = findViewById(R.id.part_of_speech_position);
        tvSign = findViewById(R.id.part_of_speech_sign);
        tvExample = findViewById(R.id.part_of_speech_example);

        partOfSpeech = new PartOfSpeech();

        intent = getIntent();

        partOfSpeech.setNamePoS(intent.getStringExtra("part_of_speech_name"));
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
                Intent backIntent = new Intent(PartOfSpeechActivity.this, ListPartOfSpeechActivity.class);
                startActivity(backIntent);
            }
        });
    }
}