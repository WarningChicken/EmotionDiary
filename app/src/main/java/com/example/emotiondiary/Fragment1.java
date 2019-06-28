package com.example.emotiondiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.TextView;

//import android.support.annotation.Nullable;

public class Fragment1 extends Fragment {
    //Fragment of day_view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day_view, container, false);
        return view;
        }
}