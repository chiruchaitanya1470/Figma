package com.example.figma.ui.records;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.figma.R;
import com.example.figma.databinding.FragmentHomeBinding;
import com.example.figma.ui.home.HomeViewModel;

public class recordsFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecordsViewModel recordsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recordsViewModel=
                new ViewModelProvider(this).get(RecordsViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}