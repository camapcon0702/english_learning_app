package com.example.elitte;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class VocabularyPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vocabulary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridview);

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
}