package com.jesuspinar.pruebatabs;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jesuspinar.pruebatabs.ui.fragments.PersonalData;
import com.jesuspinar.pruebatabs.ui.fragments.ProfessionalData;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity implements PersonalData.IOnAttach, ProfessionalData.IOnAttach {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.view_pager);

        TabStateApdapter tabStateApdapter = new TabStateApdapter(this);
        viewPager.setAdapter(tabStateApdapter);

        Toolbar toolbar = findViewById(R.id.homeBar);
        setSupportActionBar(toolbar);
        setTitle("Override tittle");

        //Config tab bar
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        //tab tittle
        toolbar.setTitle("");
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Datos Personales"); break;
                    case 1: tab.setText("Datos Profesionales"); break;
                    //todo : default case
                }
            }
        });
        tabLayoutMediator.attach();
    }

    @Override
    public String getPersonalData() {
        return "Personal Data";
    }

    @Override
    public String getProfessionalData() {
        return "Professional Data";
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
                default: return new PersonalData();
            }
        }


        //todo change this return if more tabs
        @Override
        public int getItemCount() {
            return 2;
        }
    }

}