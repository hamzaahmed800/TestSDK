package com.xfoil.dev.test_sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xfoil.dev.test_sdk.databinding.ActivityMainBinding;

import java.util.concurrent.CountedCompleter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}