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
import com.example.elitte.entity.Tense;

public class TenseActivity extends AppCompatActivity {

    private TextView tvHeader;
    private TextView btnBack;
    private TextView tvName;
    private TextView tvAffirmative;
    private TextView tvNegative;
    private TextView tvQuestion;
    private TextView tvKeyUses;
    private TextView tvExample;
    private TextView tvSign;
    private Tense tense;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tense);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls(){
        tvHeader = findViewById(R.id.header_tense_title);
        btnBack = findViewById(R.id.back);
        tvName = findViewById(R.id.tense_name);
        tvAffirmative = findViewById(R.id.affirmative_sentences);
        tvNegative = findViewById(R.id.negative_sentences);
        tvQuestion = findViewById(R.id.questions);
        tvKeyUses = findViewById(R.id.tense_key_uses);
        tvExample = findViewById(R.id.text_example);
        tvSign = findViewById(R.id.text_signs);

        tense = new Tense();

        intent = getIntent();

        tense.setNameTense(intent.getStringExtra("tense_name"));

        tense.setAffirmative("(+) S + V(s, es)");
        tense.setNegative("(-) S + don't/doesn't + V");
        tense.setQuestion("(?) Do/Does + S + V");
        tense.setKeyUse("Diễn tả một sự thật hiển nhiên, một chân lý. \nDiễn tả 1 hành động xảy ra thường xuyên, một thói quen ở hiện tại. \nDiễn tả một năng lực của con người \nDiễn tả một kế hoạch đã được sắp xếp trong tương lai, đặc biệt là trong việc di chuyển.");
        tense.setExample("The sun rises in the East and sets in the West");
        tense.setSign("Every day/ week/ month… \nOften, usually, frequently \nSometimes, occasionally \nAlways, constantly \nSeldom, rarely");

        tvHeader.setText(tense.getNameTense());
        tvName.setText(tense.getNameTense());
        tvAffirmative.setText(tense.getAffirmative());
        tvNegative.setText(tense.getNegative());
        tvQuestion.setText(tense.getQuestion());
        tvKeyUses.setText(tense.getKeyUse());
        tvExample.setText(tense.getExample());
        tvSign.setText(tense.getSign());
    }

    public void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(TenseActivity.this, ListTenseActivity.class);
                startActivity(backIntent);
            }
        });
    }
}