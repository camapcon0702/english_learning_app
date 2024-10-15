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
import com.example.elitte.entity.Clause;

public class ClauseActivity extends AppCompatActivity {

    private TextView tvHeader, btnBack, tvName, tvStructure, tvKeyUse, tvExample;
    private Clause clause;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clause);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls(){
        tvHeader = findViewById(R.id.header_clause_title);
        btnBack = findViewById(R.id.back);
        tvName = findViewById(R.id.clause_name);
        tvStructure = findViewById(R.id.clause_structure);
        tvKeyUse = findViewById(R.id.clause_key_uses);
        tvExample = findViewById(R.id.clause_example);

        clause = new Clause();

        intent = getIntent();

        clause.setNameClause(intent.getStringExtra("clause_name"));

        clause.setStructure("[Liên từ + S + V] hoặc [Từ để hỏi + S + V]");
        clause.setKeyUse("Làm chủ ngữ, tân ngữ hoặc bổ ngữ.");
        clause.setExample("I don’t know what she wants. (Tân ngữ)\nWhat he said surprised me. (Chủ ngữ)\nThe problem is that he is late. (Bổ ngữ)");

        tvHeader.setText(clause.getNameClause());
        tvName.setText(clause.getNameClause());
        tvStructure.setText(clause.getStructure());
        tvKeyUse.setText(clause.getKeyUse());
        tvExample.setText(clause.getExample());
    }

    public void addEvents(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ClauseActivity.this, ListClauseActivity.class);
                startActivity(backIntent);
            }
        });
    }
}