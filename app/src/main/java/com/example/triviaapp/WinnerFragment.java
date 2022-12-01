package com.example.triviaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.triviaapp.databinding.FragmentWinnerBinding;


public class WinnerFragment extends Fragment {

    FragmentWinnerBinding binding;

    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;


    public WinnerFragment() {
        // Required empty public constructor
    }


    public static WinnerFragment newInstance(String param1) {
        WinnerFragment fragment = new WinnerFragment();
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
        binding = FragmentWinnerBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        String Writting = getString(R.string.winnerMessage,mParam1);
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