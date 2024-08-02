package com.example.apt3060labs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Lab6Fragment extends Fragment {

    private static final String ARG_TEAM_DETAIL = "team_detail";

    public static Lab6Fragment newInstance(String teamDetail) {
        Lab6Fragment fragment = new Lab6Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEAM_DETAIL, teamDetail);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab6, container, false);
        TextView teamDetailTextView = view.findViewById(R.id.teamDetail);

        if (getArguments() != null) {
            String teamDetail = getArguments().getString(ARG_TEAM_DETAIL);
            teamDetailTextView.setText(teamDetail);
        }

        return view;
    }
}
