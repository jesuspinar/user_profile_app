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

public class AccessData extends Fragment {

    public interface IOnAttach{
        User getUser();
    }

    User user ;

    public AccessData() {
        super(R.layout.fragment_access);
    }

    //ToDo: continue here, implement action button change password

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvUser = view.findViewById(R.id.tvUsername);
        Button btnChangePwd = view.findViewById(R.id.btnChangePwd);
        Button btnSaveChanges = view.findViewById(R.id.btnSaveChanges);
        ConstraintLayout clChangePwd = view.findViewById(R.id.clChangePwd);

        tvUser.setText(user.getName());

        btnChangePwd.setOnClickListener(v -> {
            int visibility = clChangePwd.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE;
            clChangePwd.setVisibility(visibility);
        });

        //implement second btnSaveChanges function
        btnSaveChanges.setOnClickListener(v -> {
            //TODO: valid data

            //TODO: submit form

        });


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        user = onAttach.getUser();

    }
}
