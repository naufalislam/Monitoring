package com.pale.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.pale.R;
import com.pale.SessionManager;

import java.util.HashMap;

public class AccountFragment extends Fragment {

    SessionManager sessionManager;

    private TextView txtprofil;
    private CardView btnlogout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        txtprofil = (TextView) view.findViewById(R.id.account_menu);
        btnlogout = (CardView) view.findViewById(R.id.cvLogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });

//        sessionManager = new SessionManager(getApplicationContext());
        sessionManager = new SessionManager(getContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        String name = user.get(SessionManager.kunci_email);
        txtprofil.setText(Html.fromHtml("<b>" + name + "</b>"));

        return view;
    }
}
