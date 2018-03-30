package com.example.pstrycz.bottomnav.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pstrycz.bottomnav.R;
import com.example.pstrycz.bottomnav.databinding.FirstBinding;
import com.example.pstrycz.bottomnav.databinding.ThirdBinding;

public class Third extends Fragment {

    public static Fragment newInstance() {
        Third fragment = new Third();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ThirdBinding binding = DataBindingUtil.inflate(inflater, R.layout.third, container, false);
        return binding.getRoot();
    }
}
