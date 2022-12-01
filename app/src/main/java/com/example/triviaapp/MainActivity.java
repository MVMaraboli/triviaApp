package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.triviaapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding Binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = Binding.getRoot();
        setContentView(view);
        addMainFragment();

    }
    private void addMainFragment(){
        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(Binding.FragmentContainer.getId(),mainFragment,MainFragment.class.getSimpleName());
        fragmentTransaction.commit();

    }
}