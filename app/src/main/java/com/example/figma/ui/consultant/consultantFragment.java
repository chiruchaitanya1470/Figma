package com.example.figma.ui.consultant;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.figma.R;
import com.example.figma.databinding.FragmentHomeBinding;
import com.example.figma.ui.home.HomeViewModel;

public class consultantFragment extends Fragment {

    Spinner spin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_consultant,container,false);
        View root1 = root;
        return root1;



    }
}