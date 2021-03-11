package com.voca_application.voca_test;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.voca_application.MainActivity;
import com.voca_application.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VocaTestFragment extends Fragment {
    private TextView weakWordsTest;
    private TextView allWordsTest;
    private static final String TAG = VocaTestFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView()");
        View view = inflater.inflate(R.layout.fragment_voca_exam, container, false);
        weakWordsTest = view.findViewById(R.id.weak_words_test);
        weakWordsTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"WEAK WORDS TEST IS CLICKED!!");

            }
        });
        allWordsTest = view.findViewById(R.id.all_words_test);
        allWordsTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ALL WORDS TEST IS CLICKED!!");

            }
        });
        return view;
    }
}