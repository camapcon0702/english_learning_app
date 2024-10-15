package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.entity.GridItem;
import com.example.elitte.Data.GridItemAdapterVer;
import com.example.elitte.R;

import java.util.Arrays;
import java.util.List;

public class HomePage extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        addControls();
        addEvents();
    }

    public void addControls(){

        gridView = findViewById(R.id.gridview);

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

    public void addEvents(){
        // set sự kiện khi nhấn vào từng item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(HomePage.this, LearningPage.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(HomePage.this, HomeExercisePage.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(HomePage.this, FlashcardsActivity.class);
                        startActivity(intent2);
                        break;

                }
            }
        });
    }

}
