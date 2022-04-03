package com.ocean.studentattendapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ocean.studentattendapp.R;
import com.ocean.studentattendapp.adapter.VPAdapter;
import com.ocean.studentattendapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private VPAdapter vpAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vpAdapter = new VPAdapter(this);
        binding.viewPagerMainActivity.setAdapter(vpAdapter);

        new TabLayoutMediator(binding.tabLayoutMainActivity, binding.viewPagerMainActivity, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("All Student List");
                }else if (position ==1){
                    tab.setText("Take Attendance");
                }else if (position == 2){
                    tab.setText("Attendance Report");
                }
            }
        }).attach();

        binding.floatingActionButton.setOnClickListener(view -> {
                startActivity(new Intent(this, AddStudentActivity.class));
        });
    }
}