package com.example.elitte.Page;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.R;

public class TenseActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAffirmative;
    private TextView tvNegative;
    private TextView tvQuestion;
    private RelativeLayout viewKeyUses;
    private TextView tvExample;
    private TextView tvSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tense);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void addControls(){
        tvName = findViewById(R.id.tense_name);
        tvAffirmative = findViewById(R.id.affirmative_sentences);
        tvNegative = findViewById(R.id.negative_sentences);
        tvQuestion = findViewById(R.id.questions);
        viewKeyUses = findViewById(R.id.tense_key_use);
        tvExample = findViewById(R.id.text_example);
        tvSign = findViewById(R.id.text_signs);
    }

    public void addEvents() {

    }
}