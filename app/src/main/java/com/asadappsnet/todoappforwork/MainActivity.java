package com.asadappsnet.todoappforwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.asadappsnet.todoappforwork.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    ArrayList<HomeModel> list;
    HomeAdapter adapter;


    String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
getSupportActionBar().hide();
        setupRecycler();

        addTODO();



        binding.splash.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.gone));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
             //   getSupportActionBar().show();

                binding.splash.setVisibility(View.GONE);

            }
        },5000);



    }

    private void addTODO() {
        binding.addTODObutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userInput = binding.todoName.getText().toString();


                if (userInput.equals("")){
                    Toast.makeText(MainActivity.this, "Please Write Something", Toast.LENGTH_SHORT).show();

                }
                else {

                    list.add(new HomeModel(userInput));

                    adapter.notifyDataSetChanged();
                }


            }
        });



    }

    private void setupRecycler() {
    list = new ArrayList<>();
    adapter = new HomeAdapter(list,this);
    binding.homeRecycler.setAdapter(adapter);



    }
}