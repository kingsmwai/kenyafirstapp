package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunication_ShareModel extends AppCompatActivity {
    Fragment_a_share_communication fragment_a_share_communication;
    Fragment_b_share_communication fragment_b_share_communication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication__share_model);

        fragment_a_share_communication = new Fragment_a_share_communication();
        fragment_b_share_communication = new Fragment_b_share_communication();

        getSupportFragmentManager().beginTransaction().replace(R.id.containerA,fragment_a_share_communication).replace(R.id.containerB,
                fragment_b_share_communication).commit();

    }
}
