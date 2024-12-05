
package com.example.elitte.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.elitte.Data.WordItemAdapter;
import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.Vocabulary;
import com.example.elitte.R;
import com.example.elitte.Retrofit.QuestionsApi;
import com.example.elitte.Retrofit.RetrofitInstance;
import com.example.elitte.entity.WordItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordFragment extends Fragment {

    private View view;
    private TextView txtBack;
    private GridView gridView;
    private Long typeId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_word_page, container, false);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getArguments() != null) {
            typeId = getArguments().getLong("typeId");
        }

        addControls();
        fetchDataFromApi();
        addEvents();

        return view;
    }

    public void addControls() {
        gridView = view.findViewById(R.id.gridview);
        txtBack = view.findViewById(R.id.back);
    }

    private void fetchDataFromApi() {
        String token = TokenManager.getToken(getContext());
        QuestionsApi api = RetrofitInstance.getRetrofitInstance(token).create(QuestionsApi.class);
        Call<List<Vocabulary>> call = api.getAllVocabularyByIdType(typeId);

        call.enqueue(new Callback<List<Vocabulary>>() {
            @Override
            public void onResponse(Call<List<Vocabulary>> call, Response<List<Vocabulary>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<WordItem> wordItems = new ArrayList<>();
                    for (Vocabulary vocab : response.body()) {
                        int iconResId = getResources().getIdentifier(vocab.getIconRes(), "drawable", getContext().getPackageName());
                        wordItems.add(new WordItem(iconResId, vocab.getWord(), vocab.getDefinition(), vocab.getExample()));
                    }

                    WordItemAdapter adapter = new WordItemAdapter(getContext(), wordItems);
                    gridView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Không có dữ liệu từ API!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Vocabulary>> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addEvents() {
        txtBack.setOnClickListener(view -> {
            Fragment fragment = new VocabularyFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.home_page, fragment);
            transaction.commit();
        });
    }
}



