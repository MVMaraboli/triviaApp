package com.example.triviaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.triviaapp.databinding.FragmentTriviaBinding;


public class TriviaFragment extends Fragment {

    FragmentTriviaBinding binding;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    // Declaramos contenedores de los valores pulsados de los Radio Buttons
    private static final int Option_1 = 0;
    private static final int Option_2 = 1;
    private static final int Option_3 = 2;
    private static final int Option_4 = 3;
    private static final int Option_5 = 4;
    // Declaramos la variable numérica que recibirá nuestra opción pulsada.
    private int optionChoice = 6;

    public TriviaFragment() {
        // Constructor Vacío
    }

    public static TriviaFragment newInstance(String param1) {
        TriviaFragment fragment = new TriviaFragment();
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
        // Inflamos la vista de los datos recibidos por parámetros
        binding = FragmentTriviaBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        String Writting = getString(R.string.hellow_player,mParam1);
        binding.recivedName.setText(Writting);
        // Operación de la selección de radio starButton
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                View radioButton = binding.radioGroup.findViewById((checkedId));
                int index = binding.radioGroup.indexOfChild(radioButton);
                switch(index){
                    case Option_1:
                        optionChoice = Option_1;
                        break;
                    case Option_2:
                        optionChoice = Option_2;
                        break;
                    case Option_3:
                        optionChoice = Option_3;
                        break;
                    case Option_4:
                        optionChoice = Option_4;
                        break;
                    case Option_5:
                        optionChoice = Option_5;
                        break;
                    default:
                        optionChoice = 6;
                        break;
                }

            }
        });

        binding.btnSendAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (optionChoice == Option_4) {
                    goWin(mParam1);
                } else if(optionChoice == Option_1 || optionChoice == Option_2 || optionChoice == Option_3 || optionChoice == Option_5 ){
                    goTryAgain(mParam1);
                } else if(optionChoice == 6) {
                    Toast.makeText(getContext(), "Debes Seleccionar una Opción Para Jugar...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void goWin(String Name){
        WinnerFragment winnerFragment = WinnerFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.FragmentContainer,winnerFragment,WinnerFragment.class.getSimpleName());
        fragmentTransaction.commit();

    }

    private void goTryAgain(String Name){
        LoserFragment loserFragment = LoserFragment.newInstance(Name);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.FragmentContainer,loserFragment,LoserFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}