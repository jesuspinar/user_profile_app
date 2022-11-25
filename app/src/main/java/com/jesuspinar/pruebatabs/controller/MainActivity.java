package com.jesuspinar.pruebatabs.controller;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jesuspinar.pruebatabs.R;
import com.jesuspinar.pruebatabs.model.User;
import com.jesuspinar.pruebatabs.ui.fragments.AccessData;
import com.jesuspinar.pruebatabs.ui.fragments.PersonalData;
import com.jesuspinar.pruebatabs.ui.fragments.ProfessionalData;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity implements PersonalData.IOnAttach,
        ProfessionalData.IOnAttach, AccessData.IOnAttach {

    private User userTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initData();

        ViewPager2 viewPager = findViewById(R.id.view_pager);

        TabStateApdapter tabStateApdapter = new TabStateApdapter(this);
        viewPager.setAdapter(tabStateApdapter);

        Toolbar toolbar = findViewById(R.id.homeBar);
        setSupportActionBar(toolbar);
        setTitle("Override tittle");

        //Config tab bar
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_FIXED);

        //tab tittle
        toolbar.setTitle("");
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Personal"); break;
                    case 1: tab.setText("Professional"); break;
                    case 2: tab.setText("Access"); break;
                    default: tab.setText("Unnamed tab"); break;
                }
            }
        });
        tabLayoutMediator.attach();


    }

    private void initData() {
        userTest = new User("none","12345678B", "Juan", "Palomo Garcia",
                "04/08/1995", "C/Major, 35 - 03730 Xàbia",
                "John Doe, S.L.", "B123456", "http://www.johndoe.com",
                "juanpalomo@johndoe.com");

    }

    @Override
    public User getPersonalData() {
        return userTest;
    }

    @Override
    public User getProfessionalData() {
        return userTest;
    }

    @Override
    public User getAccessData() {
        return userTest;
    }

    /**
     * Only creates fragment one
     */
    public static class TabStateApdapter extends FragmentStateAdapter{

        public TabStateApdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0: return new PersonalData();
                case 1: return new ProfessionalData();
                case 2: return new AccessData();
                default: return new PersonalData();
            }
        }


        //todo change this return if more tabs
        @Override
        public int getItemCount() {
            return 3;
        }
    }

}