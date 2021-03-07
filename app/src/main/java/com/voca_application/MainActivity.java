package com.voca_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.voca_application.dictionary.DictionaryFragment;
import com.voca_application.voca_note.VocaNoteFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout DictionaryLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    DictionaryFragment Dictionary;
    VocaNoteFragment VocaNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dictionary = new DictionaryFragment();
        VocaNote = new VocaNoteFragment();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, Dictionary).commitAllowingStateLoss();

    }

    private void buttonHandler(View view){
        transaction = fragmentManager.beginTransaction();
        switch(view.getId())
        {
            case R.id.btnDict:
                transaction.replace(R.id.frameLayout, Dictionary).commitAllowingStateLoss();
                break;
            case R.id.btnVocaNote:
                transaction.replace(R.id.frameLayout, VocaNote).commitAllowingStateLoss();
                break;
        }
    }
}