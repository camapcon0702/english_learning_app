package com.example.elitte.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elitte.JWT.TokenManager;
import com.example.elitte.Models.FlashCard;
import com.example.elitte.Models.ListFlashCard;
import com.example.elitte.Models.MiniGame;
import com.example.elitte.Page.FlashcardsActivity;
import com.example.elitte.Page.HomePage;
import com.example.elitte.Page.NavigationMainActivity;
import com.example.elitte.R;
import com.example.elitte.Retrofit.FlashCardAPI;
import com.example.elitte.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlashCardsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlashCardsFragment extends Fragment {

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
    private ListFlashCard listFlashCard;
    private int currentIndex = 0;
    TextView txtBack;
    View view;
    Button btnTiepTheo;
    private MutableLiveData<List<FlashCard>> liveFlashCardList = new MutableLiveData<>();

    // CardBack


    // CardFront
    TextView tuVung, phienAm, viDu;
    ImageButton btnAmThanh;
    // CardBack
    TextView nghiaCuaTu;
    ImageView hinhAnh;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FlashCardsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlashCardsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlashCardsFragment newInstance(String param1, String param2) {
        FlashCardsFragment fragment = new FlashCardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_flashcards, container, false);


        findViews();
        loadAnimations();
        changeCameraDistance();
        View childFrame = view.findViewById(R.id.child_frame);  // Hoặc bất kỳ view nào bạn muốn gán click
        childFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCard(view);
            }
        });
        addControls();
        addEvents();

        // Fetch and observe data
        fetchFlashCardFromAPI();
        observeFlashCardList();

        return view;
    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.in_animation);
    }

    private void findViews() {
        mCardBackLayout = view.findViewById(R.id.card_back);
        mCardFrontLayout = view.findViewById(R.id.card_front);

    }

    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }


    }

    private void addControls(){
        txtBack = view.findViewById(R.id.back);
        btnTiepTheo = view.findViewById(R.id.btn_reply);
        //cardfront
        tuVung = view.findViewById(R.id.txt_card_word);
        phienAm = view.findViewById(R.id.txt_card_word_pronunciation);
        viDu = view.findViewById(R.id.txt_card_word_explain);
        btnAmThanh = view.findViewById(R.id.icon_sound);
        //cardback
        nghiaCuaTu = view.findViewById(R.id.txt_card_word_vn_meaning);
        hinhAnh = view.findViewById(R.id.txt_card_word_image);


    }

    private void addEvents(){
        txtBack.setOnClickListener(e -> {
            Intent intent = new Intent(getActivity(), NavigationMainActivity.class);
            startActivity(intent);
        });
        btnTiepTheo.setOnClickListener(e -> {
            moveToTheNextFlashCard(liveFlashCardList.getValue());
        });
    }

    private void fetchFlashCardFromAPI() {
        String token = TokenManager.getToken(getContext());
        FlashCardAPI api = RetrofitInstance.getRetrofitInstance(token).create(FlashCardAPI.class);
        Call<ListFlashCard> call = api.getAllFlashCards();

        call.enqueue(new Callback<ListFlashCard>() {
            @Override
            public void onResponse(Call<ListFlashCard> call, Response<ListFlashCard> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<FlashCard> flashCards = response.body();
                    liveFlashCardList.postValue(flashCards);
                    Log.d("FlashCardAPI", "Fetched " + flashCards.size() + " flashcards");
                } else {
                    Log.e("FlashCardAPI", "Error: " + response.code());
                    Toast.makeText(getContext(), "Lỗi khi tải Flashcards!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListFlashCard> call, Throwable t) {
                Log.e("FlashCardAPI", "Failed to load Flashcards: " + t.getMessage());
                Toast.makeText(getContext(), "Lỗi kết nối API!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void observeFlashCardList() {
        liveFlashCardList.observe(getViewLifecycleOwner(), flashCards -> {
            if (flashCards != null && !flashCards.isEmpty()) {
                updateFlashCardUI(flashCards.get(0));
            } else {
                Toast.makeText(getContext(), "Không có Flashcards nào!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateFlashCardUI(FlashCard flashCard) {

        tuVung.setText(flashCard.getTuVung());


        phienAm.setText(flashCard.getPhienAm());


        viDu.setText(flashCard.getCachDung());


        nghiaCuaTu.setText(flashCard.getDichNghia());


        btnAmThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String soundFileName = flashCard.getAmThanh();
                int soundResId = getResources().getIdentifier(soundFileName, "raw", getContext().getPackageName());

                if (soundResId != 0) {

                    MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), soundResId);
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(mp -> mp.release());
                } else {

                    Toast.makeText(getContext(), "Không tìm thấy tệp âm thanh!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        int imageResId = getResources().getIdentifier(flashCard.getHinhAnh(), "drawable", getContext().getPackageName());
        if (imageResId != 0) {
            hinhAnh.setImageResource(imageResId);
        } else {
            Toast.makeText(getContext(), "Hình ảnh không tìm thấy!", Toast.LENGTH_SHORT).show();
        }
    }


    private void moveToTheNextFlashCard(List<FlashCard> flashCards) {
        if (flashCards != null && !flashCards.isEmpty()) {
            currentIndex = (currentIndex + 1) % flashCards.size();
            updateFlashCardUI(flashCards.get(currentIndex));
        }
    }


}