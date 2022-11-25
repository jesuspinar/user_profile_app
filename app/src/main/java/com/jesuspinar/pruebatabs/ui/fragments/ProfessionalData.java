package com.jesuspinar.pruebatabs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.jesuspinar.pruebatabs.R;
import com.jesuspinar.pruebatabs.model.User;

public class ProfessionalData extends Fragment {

    public interface IOnAttach{
        User getProfessionalData();
    }

    private User user;

    public ProfessionalData() {
        super(R.layout.fragment_pro_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvCif = view.findViewById(R.id.tvCif);
        TextView tvLegalForm = view.findViewById(R.id.tvLegalForm);
        TextView tvAddress = view.findViewById(R.id.tvAddressPro);
        TextView tvWebsite = view.findViewById(R.id.tvWebsite);
        TextView tvEmail = view.findViewById(R.id.tvEmail);

        tvCif.setText(user.getCif());
        tvLegalForm.setText(user.getLegalForm());
        tvAddress.setText(user.getAddress());
        tvWebsite.setText(user.getWebsite());
        tvEmail.setText(user.getEmail());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        user = onAttach.getProfessionalData();

    }
}
