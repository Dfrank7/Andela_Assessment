package com.example.dfrank.cryptocurrency.controller;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.dfrank.cryptocurrency.R;
import com.example.dfrank.cryptocurrency.adapter.FraAdapter;
import com.example.dfrank.cryptocurrency.fragments.BtcFragment;
import com.example.dfrank.cryptocurrency.fragments.EthFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fragments = new ArrayList<>();
    List<String> texts = new ArrayList<>();

    private void addData(Fragment fragment, String text) {
        fragments.add(fragment);
        texts.add(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager viewPager = findViewById(R.id.viewPager);
        android.support.v7.widget.Toolbar toolbar =findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        prepareData();
        FraAdapter nAdapter = new FraAdapter(getSupportFragmentManager(), fragments, texts);
       viewPager.setAdapter(nAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void prepareData() {
        addData(new BtcFragment(), "Bitcoin");
        addData(new EthFragment(),"Etherum");

    }
}
