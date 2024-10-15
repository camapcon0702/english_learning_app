package com.example.elitte.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elitte.Data.PartOfSpeechAdapter;
import com.example.elitte.R;
import com.example.elitte.entity.PartOfSpeech;

import java.util.ArrayList;

public class ListPartOfSpeechActivity extends AppCompatActivity {

    private ListView lvPartOfSpeech;
    ArrayList<PartOfSpeech> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_part_of_speech);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls() {
        lvPartOfSpeech = findViewById(R.id.list_part_of_speech);
        arrayList = new ArrayList<>();
        arrayList.add(new PartOfSpeech("Danh từ (Noun)", "Là những từ chỉ người, sự vật, địa điểm hay hiện tượng cụ thể."));
        arrayList.add(new PartOfSpeech("Động từ (Verb)", "Những từ chỉ hành động và trạng thái của một người, sự vật hay hiện tượng nào đó."));
        arrayList.add(new PartOfSpeech("Tính từ (Adjective)", "Những từ chỉ tính chất, đặc điểm của người, vật hay hiện tượng."));
        arrayList.add(new PartOfSpeech("Trạng từ (Adverb)", "Là những từ bổ nghĩa thêm cho tính từ, chỉ trạng thái hay tính chất của một sự vật/hiện tượng. "));
        arrayList.add(new PartOfSpeech("Giới từ (Preposition)", "Là những từ biểu thị tính liên quan giữa các sự vật, hiện tượng bất kỳ."));
        arrayList.add(new PartOfSpeech("Liên từ (Conjunction)", "Là những từ dùng để nối kết các từ, cụm từ, mệnh đề, và ý nghĩa trong một câu."));
        arrayList.add(new PartOfSpeech("Thán từ (Interjection)", "Những từ dùng để thể hiện cảm xúc của người nói. "));
        arrayList.add(new PartOfSpeech("Đại từ (Pronoun)", "Những từ chỉ người hay sự vật, được dùng nhằm thay thế cho cụm từ/danh từ cụ thể đã xác định trong câu để giảm thiểu việc lặp lại nhiều lần, khiến câu mất đi tính tự nhiên."));
        arrayList.add(new PartOfSpeech("Từ hạn định (Determiner)", "Từ hạn định là từ đứng trước một danh từ hoặc cụm danh từ nhằm giới hạn và xác định danh từ/ cụm danh từ đó, qua đó góp phần làm rõ nghĩa cho các sự vật, sự việc, con người được đề cập đến trong câu."));

        PartOfSpeechAdapter adapter = new PartOfSpeechAdapter(this, R.layout.part_of_speech_item, arrayList);
        lvPartOfSpeech.setAdapter(adapter);
    }

    public void addEvents() {
        lvPartOfSpeech.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PartOfSpeech selectedItem = arrayList.get(i);
                Intent intent = new Intent(ListPartOfSpeechActivity.this, PartOfSpeechActivity.class);
                intent.putExtra("part_of_speech_name", selectedItem.getNamePoS());
                startActivity(intent);
            }
        });
    }
}