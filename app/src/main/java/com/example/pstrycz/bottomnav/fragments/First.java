package com.example.pstrycz.bottomnav.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pstrycz.bottomnav.R;
import com.example.pstrycz.bottomnav.databinding.FirstBinding;

public class First extends Fragment {

    public static Fragment newInstance() {
        First fragment = new First();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FirstBinding binding = DataBindingUtil.inflate(inflater, R.layout.first, container, false);
        return binding.getRoot();
    }


}
