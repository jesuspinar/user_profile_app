package com.jesuspinar.pruebatabs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.pruebatabs.R;

public class ProfessionalData extends Fragment {

    public interface IOnAttach{
        String getProfessionalData();
    }

    private String data;

    public ProfessionalData() {
        super(R.layout.fragment_pro_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvProfessionalData = view.findViewById(R.id.tvProfessionalData);
        tvProfessionalData.setText(data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        data = onAttach.getProfessionalData();

    }
}
