package com.example.triviaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.triviaapp.databinding.FragmentLoserBinding;


public class LoserFragment extends Fragment {
    FragmentLoserBinding binding;

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public LoserFragment() {
        // Required empty public constructor
    }


    public static LoserFragment newInstance(String param1) {
        LoserFragment fragment = new LoserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoserBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        String Writting = getString(R.string.loserMessage,mParam1);
        binding.txtLoserMessage.setText(Writting);

        binding.btnWinnerAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}