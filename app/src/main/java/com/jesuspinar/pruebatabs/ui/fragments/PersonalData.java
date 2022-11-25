package com.jesuspinar.pruebatabs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.pruebatabs.R;
import com.jesuspinar.pruebatabs.model.User;

public class PersonalData extends Fragment {

    public interface IOnAttach{
        User getPersonalData();
    }

    private User user;

    public PersonalData() {
        super(R.layout.fragment_pers_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvSurname = view.findViewById(R.id.tvSurname);
        TextView tvBday = view.findViewById(R.id.tvBday);
        TextView tvAddress = view.findViewById(R.id.tvAddress);
        TextView tvNif = view.findViewById(R.id.tvNif);
        ImageView ivPicture = view.findViewById(R.id.ivPicture);
        ivPicture.setImageResource(R.drawable.pic_default);

        //Setting data
        tvName.setText(user.getName());
        tvSurname.setText(user.getSurname());
        tvBday.setText(user.getBirth()+user.getAge());
        tvAddress.setText(user.getAddress());
        tvNif.setText(user.getNif());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        user = onAttach.getPersonalData();

    }
}
