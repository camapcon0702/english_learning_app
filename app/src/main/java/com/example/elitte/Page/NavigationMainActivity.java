package com.example.elitte.Page;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.elitte.fragment.AccountFragment;
import com.example.elitte.fragment.alarm.CalendarFragment;
import com.example.elitte.fragment.HistoryFragment;
import com.example.elitte.fragment.HomeFragment;
import com.example.elitte.view_pager_adapter.ViewPagerAdapter;
import com.example.elitte.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationMainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView navigationBarView;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exercise), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    public void addControls() {
//        viewPager = findViewById(R.id.view_page);
        navigationBarView = findViewById(R.id.bottom_navigation);

//        viewPagerAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);

        loadFragment(new HomeFragment());
    }

    public void addEvents() {
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                switch (position) {
//                    case 0:
//                        navigationBarView.getMenu().findItem(R.id.menu_home).setChecked(true);
//                        break;
//                    case 1:
//                        navigationBarView.getMenu().findItem(R.id.menu_calendar).setChecked(true);
//                        break;
//                    case 2:
//                        navigationBarView.getMenu().findItem(R.id.menu_history).setChecked(true);
//                        break;
//                    case 3:
//                        navigationBarView.getMenu().findItem(R.id.menu_account).setChecked(true);
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                super.onPageScrollStateChanged(state);
//            }
//        });

        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.menu_home) {
//                    viewPager.setCurrentItem(0);
                    selectedFragment = new HomeFragment();
                }
                if (item.getItemId() == R.id.menu_calendar) {
//                    viewPager.setCurrentItem(1);
                    selectedFragment = new CalendarFragment();
                }
                if (item.getItemId() == R.id.menu_history) {
//                    viewPager.setCurrentItem(2);
                    selectedFragment = new HistoryFragment();
                }
                if (item.getItemId() == R.id.menu_account) {
//                    viewPager.setCurrentItem(3);
                    selectedFragment = new AccountFragment();
                }
                return loadFragment(selectedFragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        // Để không thêm fragment trùng lặp
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.view_page, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}