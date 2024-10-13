package com.example.elitte.Page;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.TenseAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.Tense;

import java.util.ArrayList;

public class ClauseActivity extends AppCompatActivity {

    private ListView lvClause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clause);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvClause = findViewById(R.id.list_clause);
        ArrayList<Tense> arrayList = new ArrayList<>();
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Tense("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));

        TenseAdapter adapter = new TenseAdapter(this, R.layout.activity_tense, arrayList);
        lvClause.setAdapter(adapter);
    }
}