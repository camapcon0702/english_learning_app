package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.entity.GridItem;
import com.example.elitte.Data.GridItemAdapterHor;
import com.example.elitte.R;

import java.util.Arrays;
import java.util.List;

public class GrammarPage extends AppCompatActivity {

    TextView txtBack;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grammar_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.grammar_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();

    }

    private void addControls(){
        gridView = findViewById(R.id.gridview);
        txtBack = findViewById(R.id.back);
        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_tense, "12 Thì Cơ Bản"),
                new GridItem(R.drawable.icon_clause, "Mệnh đề"),
                new GridItem(R.drawable.icon_wordtype, "Từ loại")
        );
        GridItemAdapterHor adapterHor = new GridItemAdapterHor(this, gridItems);
        gridView.setAdapter(adapterHor);
    }

    private void addEvents(){
        txtBack.setOnClickListener(e -> {
            Intent intent = new Intent(GrammarPage.this, LearningPage.class);
            startActivity(intent);
        });
    }

}