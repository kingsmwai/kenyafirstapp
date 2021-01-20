package com.emobilis.firstapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_b_communication extends Fragment {

    //declare the interface
    private FragmentBListener listener;
    //declare views
    private EditText editText;
    private Button button;


    //define the interface
    public interface FragmentBListener {
        //we place an abstract method
        void onInputBSent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b_communication,container,false);
        editText = v.findViewById(R.id.edit_text);
        button = v.findViewById(R.id.button_ok);

        //capture and pass input from user to interface method
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText().toString().trim();
                listener.onInputBSent(input);
            }
        });

        return  v;
    }

    //update edit text
    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    //attach inteface method to focus of fragment


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBListener){
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement Fragment Listener");
        }
    }

    //when fragment or activity is destroyed
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
