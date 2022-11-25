package com.jesuspinar.pruebatabs.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.jesuspinar.pruebatabs.R;
import com.jesuspinar.pruebatabs.model.User;

public class AccessData extends Fragment {

    public interface IOnAttach{
        User getAccessData();
    }

    private User user ;

    public AccessData() {
        super(R.layout.fragment_access);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvUser = view.findViewById(R.id.tvUsername);
        Button btnChangePwd = view.findViewById(R.id.btnChangePwd);
        Button btnSaveChanges = view.findViewById(R.id.btnSaveChanges);
        ConstraintLayout clChangePwd = view.findViewById(R.id.clChangePwd);

        EditText etOldPwd = view.findViewById(R.id.etOldPassword);
        EditText etNewPwd = view.findViewById(R.id.etNewPassword);
        EditText etConfirmPwd = view.findViewById(R.id.etConfirmPassword);

        tvUser.setText(user.getUsername());

        btnChangePwd.setOnClickListener(v -> {
            int visibility = clChangePwd.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE;
            clChangePwd.setVisibility(visibility);
        });

        //implement second btnSaveChanges function
        btnSaveChanges.setOnClickListener(v -> {
            boolean isValid = etOldPwd.getText().toString().equals(user.getPassword())
                  && !etNewPwd.getText().toString().equals("")
                  &&  etNewPwd.getText().toString().equals(etConfirmPwd.getText().toString());
            if (isValid){
                //submit form
                user.setPwd(etNewPwd.getText().toString());
                Toast.makeText(getContext(), "Password updated" ,Toast.LENGTH_LONG).show();
                //TODO: update pwd for all app user instance
            } else
                Toast.makeText(getContext(), "Invalid field input" ,Toast.LENGTH_SHORT).show();
            etOldPwd.setText("");
            etNewPwd.setText("");
            etConfirmPwd.setText("");
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach onAttach = (IOnAttach) context;
        user = onAttach.getAccessData();

    }
}
