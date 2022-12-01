package com.example.triviaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.triviaapp.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {
    FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.playerName.getText().toString().isEmpty()) {
                    addTriviaFragment(binding.playerName.getText().toString());
                } else {
                    Toast.makeText(getContext(),"Debes escribir tu nombre para jugar...",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }
    private void addTriviaFragment(String Name){
        TriviaFragment triviaFragment = TriviaFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.FragmentContainer,triviaFragment,MainFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}