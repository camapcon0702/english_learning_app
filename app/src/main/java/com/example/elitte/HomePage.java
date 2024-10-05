package com.example.elitte;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridview);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_learning, "Học tập"),
                new GridItem(R.drawable.icon_execise, "Bài tập"),
                new GridItem(R.drawable.icon_flashcard, "Flash card"),
                new GridItem(R.drawable.icon_minigamr, "Mini game"),
                new GridItem(R.drawable.icon_calendar, "Lịch học")
        );

        GridItemAdapterVer adapter = new GridItemAdapterVer(this, gridItems);
        gridView.setAdapter(adapter);
    }
}
