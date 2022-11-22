package com.jesuspinar.pruebatabs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.pruebatabs.R;

public class PersonalData extends Fragment {

    public interface IOnAttach{
        String getPersonalData();
    }

    private String data;

    public PersonalData() {
        super(R.layout.fragment_pers_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvPersonalData = view.findViewById(R.id.tvPersonalData);
        tvPersonalData.setText(data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        data = onAttach.getPersonalData();

    }
}
