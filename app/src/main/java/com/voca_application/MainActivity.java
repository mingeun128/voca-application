package com.voca_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
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
    private Button DictionaryButton;
    private Button VocaNoteButton;
    private Button VocaExamButton;
    private DictionaryFragment Dictionary;
    private VocaNoteFragment VocaNote;
    private VocaTestFragment VocaExam;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate()");
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
        Log.d(TAG,"buttonHandler() IS CALLED !!");
        DictionaryButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"DICTIONARY BUTTON IS CLICKED!!");
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, Dictionary);
                transaction.commit();
            }
        });

        VocaNoteButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"VOCA NOTE BUTTON IS CLICKED!!");
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, VocaNote);
                transaction.commit();
            }
        });

        VocaExamButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"VOCA TEST BUTTON IS CLICKED!!");
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_layout, VocaExam);
                transaction.commit();
            }
        });
    }
}