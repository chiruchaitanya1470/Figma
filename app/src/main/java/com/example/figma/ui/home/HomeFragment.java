package com.example.figma.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.figma.R;
import com.example.figma.databinding.FragmentHomeBinding;

import java.util.*;

import java.util.ArrayList;



public class HomeFragment extends Fragment  {

    private FragmentHomeBinding binding;
    //  String[] progressBar_data={"search speliestds and doctors","appointments","payments"};
    ListView listview;
    SearchView searchView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);




        // Create the instance of ArrayAdapter
        // having the list of courses

        // binding.progressBar.setProgress(80);
        ProgressBar progressBar=root.findViewById(R.id.progress_bar);

        progressBar.setProgress(80);
        Spinner spinner=root.findViewById(R.id.spinner_home);
        TextView textView=root.findViewById((R.id.textview_home));

        String[] reason={"Chest pain","Headach","Cold","Feaver","Body pains","Skin"};

        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,reason);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem=spinner.getSelectedItem().toString();
                textView.setText(selectedItem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //search implementation
        ArrayList<String> doctor= new ArrayList<String>();
        doctor.add("Allegry and immunology");
        doctor.add("Anesthesiology");
        doctor.add("Dermatology");
        doctor.add("Dianogistic radiology");
        doctor.add("Emergency mediicine");
        doctor.add("Family medicine");
        doctor.add(" Allergy and immunology");
        doctor.add("Anesthesiology");
        doctor.add("Dermatology");
        doctor.add("Skin splists");
        doctor.add("body pains");
        doctor.add("Eye specialists");
        ArrayAdapter adapterdoctor=new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,doctor);
        listview=root.findViewById(R.id.list_view);
        listview.setAdapter(adapterdoctor);
        TextView text2=root.findViewById(R.id.text_2);
      listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              String listitem=listview.getSelectedItem().toString();
              text2.setText(listitem);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });
        searchView=root.findViewById(R.id.search_view);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapterdoctor.getFilter().filter(s);
                return false;
            }
        });






        return root;
    }



}