package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class LearningPage extends AppCompatActivity {

    TextView txtBack;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning_page);

        addControls();
        addEvent();

    }

    private void addControls(){

        gridView = findViewById(R.id.gridview);
        txtBack = findViewById(R.id.back);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_grammar, "Ngữ pháp"),
                new GridItem(R.drawable.icon_vocabulary, "Từ vựng")
        );

        GridItemAdapterHor adapterHor = new GridItemAdapterHor(this, gridItems);

        gridView.setAdapter(adapterHor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(LearningPage.this, GrammarPage.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(LearningPage.this, VocabularyPage.class);
                        startActivity(intent1);
                        break;

                }
            }
        });

    }

    private void addEvent(){
        txtBack.setOnClickListener(e -> {
            Intent intent = new Intent(LearningPage.this, HomePage.class);
            startActivity(intent);
        });


    }
}