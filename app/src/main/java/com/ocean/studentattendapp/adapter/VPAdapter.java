package com.ocean.studentattendapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ocean.studentattendapp.fragment.AllStudentListFragment;
import com.ocean.studentattendapp.fragment.AttendanceReportFragment;
import com.ocean.studentattendapp.fragment.TodaysAttendanceFragment;

import java.util.ArrayList;
import java.util.List;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0 :
                return new AllStudentListFragment();
            case 1:
                return new TodaysAttendanceFragment();
            case 2:
                return new AttendanceReportFragment();
        }
        return new AllStudentListFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
