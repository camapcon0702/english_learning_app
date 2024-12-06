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
import com.example.elitte.Data.GridItemAdapterVer;
import com.example.elitte.R;

import java.util.Arrays;
import java.util.List;

public class VocabularyPage extends AppCompatActivity {

    GridView gridView;
    TextView txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vocabulary);

        addControls();
        addEvents();


    }


    private void addControls(){
        gridView = findViewById(R.id.gridview);
        txtBack = findViewById(R.id.back);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_country, "Quốc gia"),
                new GridItem(R.drawable.icon_traffic, "Giao thông"),
                new GridItem(R.drawable.icon_animal, "Động vật"),
                new GridItem(R.drawable.icon_environment, "Môi trường"),
                new GridItem(R.drawable.icon_food, "Món ăn"),
                new GridItem(R.drawable.icon_travel, "Du lịch")
        );

        GridItemAdapterVer adapterVer = new GridItemAdapterVer(this, gridItems);
        gridView.setAdapter(adapterVer);
    }

    private void addEvents(){
        txtBack.setOnClickListener(e -> {
            Intent intent = new Intent(VocabularyPage.this, LearningPage.class);
            startActivity(intent);
        });
    }
}