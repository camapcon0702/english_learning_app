package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.ClauseAdapter;
import com.example.elitte.Data.TenseAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.Clause;
import com.example.elitte.entity.Tense;

import java.util.ArrayList;

public class ListClauseActivity extends AppCompatActivity {

    private ListView lvClause;
    ArrayList<Clause> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_clause);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls() {
        lvClause = findViewById(R.id.list_clause);
        arrayList = new ArrayList<>();
        arrayList.add(new Clause("Mệnh đề danh từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề tính từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề trạng từ", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));
        arrayList.add(new Clause("Mệnh đề độc lập", "Mệnh đề độc lập (Independent clauses) là một nhóm từ có chứa một chủ ngữ và một động từ."));

        ClauseAdapter adapter = new ClauseAdapter(this, R.layout.activity_list_tense, arrayList);
        lvClause.setAdapter(adapter);
    }

    private void addEvents() {
        lvClause.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Clause selectItem = arrayList.get(i);
                Intent intent = new Intent(ListClauseActivity.this, ClauseActivity.class);
                intent.putExtra("clause_name", selectItem.getNameClause());
                startActivity(intent);
            }
        });
    }
}