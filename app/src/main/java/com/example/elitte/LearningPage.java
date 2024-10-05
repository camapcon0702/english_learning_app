package com.example.elitte;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class LearningPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.learning_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridview);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_grammar, "Ngữ pháp"),
                new GridItem(R.drawable.icon_vocabulary, "Từ vựng")
        );

        GridItemAdapterHor adapterHor = new GridItemAdapterHor(this, gridItems);

        gridView.setAdapter(adapterHor);
    }
}