package com.example.elitte.Page;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.entity.WordItem;
import com.example.elitte.Data.WordItemAdapter;
import com.example.elitte.R;

import java.util.Arrays;
import java.util.List;

public class WordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_word_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridview);

        List<WordItem> wordItems = Arrays.asList(
                new WordItem(R.drawable.icon_airport, "airport (n) ['eəpɔ:t]", "Sân bay = the place that you go to get on a plane",
                        "Security checks has become really strict at the [airport].(Dịch: Kiểm tra an ninh ở sân bay đã trở nên rất nghiêm ngặt)"),
                new WordItem(R.drawable.icon_airport, "airport (n) ['eəpɔ:t]", "Sân bay = the place that you go to get on a plane",
                        "Security checks has become really strict at the [airport].(Dịch: Kiểm tra an ninh ở sân bay đã trở nên rất nghiêm ngặt)")
        );

        WordItemAdapter adapter = new WordItemAdapter(this,wordItems);
        gridView.setAdapter(adapter);
    }
}