package com.voca_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.voca_application.dictionary.DictionaryFragment;
import com.voca_application.voca_test.VocaTestFragment;
import com.voca_application.voca_note.VocaNoteFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout DictionaryLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    Button DictionaryButton;
    Button VocaNoteButton;
    Button VocaExamButton;
    DictionaryFragment Dictionary;
    VocaNoteFragment VocaNote;
    VocaTestFragment VocaExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dictionary = new DictionaryFragment();
        VocaNote = new VocaNoteFragment();
        VocaExam = new VocaTestFragment();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_layout, Dictionary);
        transaction.commit();

        DictionaryButton = findViewById(R.id.btnDict);
        VocaNoteButton = findViewById(R.id.btnVocaNote);
        VocaExamButton = findViewById(R.id.btnVocaExam);

        buttonHandler();

    }

    private void buttonHandler(){
        DictionaryButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, Dictionary);
                transaction.commit();
            }
        });

        VocaNoteButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, VocaNote);
                transaction.commit();
            }
        });

        VocaExamButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, VocaExam);
                transaction.commit();
            }
        });
    }
}