package com.example.elitte.Page;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.TenseAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.Tense;

import java.util.ArrayList;

public class ListTenseActivity extends AppCompatActivity {

    private ListView lvTense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_tense);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvTense = findViewById(R.id.list_tense);
        ArrayList<Tense> arrayList = new ArrayList<>();
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));
        arrayList.add(new Tense("Thì hiện tại đơn", "Thì hiện tại đơn (Simple Present Tense) dùng để diễn tả một sự thật hiển nhiên hay một hành động diễn ra lặp đi lặp lại theo thói quen, phong tục, khả năng."));

        TenseAdapter adapter = new TenseAdapter(this, R.layout.activity_list_tense, arrayList);
        lvTense.setAdapter(adapter);
    }
}