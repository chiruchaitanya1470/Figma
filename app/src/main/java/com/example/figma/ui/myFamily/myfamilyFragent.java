package com.example.figma.ui.myFamily;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.figma.R;
import com.example.figma.databinding.FragmentHomeBinding;

public class myfamilyFragent extends Fragment {


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      //  binding = FragmentHomeBinding.inflate(inflater, container, false);
       // View root = binding.getRoot();
        View root= inflater.inflate(R.layout.fragment_myfamily,container,false);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}