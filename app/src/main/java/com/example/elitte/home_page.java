package com.example.elitte;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridLayout gridLayout = findViewById(R.id.gridlayout);
        List<GridItem> gridItems = Arrays.asList(
                new GridItem(R.drawable.icon_learning, "Học tập"),
                new GridItem(R.drawable.icon_execise, "Bài tập"),
                new GridItem(R.drawable.icon_flashcard, "Flash card"),
                new GridItem(R.drawable.icon_minigamr, "Mini game"),
                new GridItem(R.drawable.icon_calendar, "Lịch học")
        );

        gridLayout.setRowCount(3);
        gridLayout.setColumnCount(2);

        for (GridItem item : gridItems) {

            View itemView = getLayoutInflater().inflate(R.layout.grid_item, null);
            ImageView icon = itemView.findViewById(R.id.item_icon);
            TextView text = itemView.findViewById(R.id.item_text);
            icon.setImageResource(item.getIconRes());
            text.setText(item.getTitle());


            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.setMargins(20, 20, 20, 20);
            itemView.setLayoutParams(params);

            gridLayout.addView(itemView);
        }
    }
}