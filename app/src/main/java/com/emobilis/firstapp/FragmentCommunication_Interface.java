package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunication_Interface extends AppCompatActivity implements Fragment_a_communication.FragmentAListener, Fragment_b_communication.FragmentBListener {
    //declare the Fragments
    private Fragment_a_communication fragment_a_communication;
    private Fragment_b_communication fragment_b_communication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication__interface);

        //new instances of the fragment
        fragment_a_communication = new Fragment_a_communication();
        fragment_b_communication = new Fragment_b_communication();

        //attach fragments to respective container
        getSupportFragmentManager().beginTransaction().replace(R.id.containerA, fragment_a_communication).replace(R.id.containerB, fragment_b_communication).commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragment_b_communication.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragment_a_communication.updateEditText(input);
    }
}
