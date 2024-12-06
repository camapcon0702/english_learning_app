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

public class HomeExercisePage extends AppCompatActivity {

    TextView txtBack;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_exercise_page);


        addControls();
        addEvents();
    }

    private void addControls(){
        gridView = findViewById(R.id.gridview);
        txtBack = findViewById(R.id.back);

        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_speakingskill, "Luyện phần đọc"),
                new GridItem(R.drawable.icon_listeningskill, "Luyện phần nghe")
        );

        GridItemAdapterHor adapterHor = new GridItemAdapterHor(this, gridItems);

        gridView.setAdapter(adapterHor);
    }

    private void addEvents(){
        txtBack.setOnClickListener(e ->{
            Intent intent = new Intent(HomeExercisePage.this, HomePage.class);
            startActivity(intent);
        });


    }

}