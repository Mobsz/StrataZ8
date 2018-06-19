package com.infinitum.o8.strataz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DiceFragment extends Fragment {

    public DiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dice, container, false);

        Button D20Btn = view.findViewById(R.id.D20Btn);
        Button D6Btn = view.findViewById(R.id.D6Btn);
        Button D20_6Btn = view.findViewById(R.id.D20_6Btn);
        Button D6MilBtn = view.findViewById(R.id.D6MilBtn);
        Button D6CivBtn = view.findViewById(R.id.D6CivBtn);
        Button D6IntBtn = view.findViewById(R.id.D6IntBtn);
        Button D6BuBtn = view.findViewById(R.id.D6BuBtn);
        Button D6ModBtn = view.findViewById(R.id.D6ModBtn);
        Button clearBtn = view.findViewById(R.id.clearButton);
        Button rerollBtn = view.findViewById(R.id.rerollButton);


        TextView diceNumber = view.findViewById(R.id.diceNumber);

        //OnClickClear
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clearBtn = getActivity().findViewById(R.id.clearButton);
                TextView diceNumber = getActivity().findViewById(R.id.diceNumber);
                diceNumber.setText("0");
            }
        });

        //OnClick D20 Roll
        D20Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button D20Btn = getActivity().findViewById(R.id.D20Btn);
                TextView diceNumber = getActivity().findViewById(R.id.diceNumber);

                Random r = new Random();
                int number = r.nextInt(20)+1;
                String numberString = String.valueOf(number);
                diceNumber.setText(numberString);

            }
        });

        //OnClick D6 Roll
        D6Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button D6Btn = getActivity().findViewById(R.id.D6Btn);
                TextView diceNumber = getActivity().findViewById(R.id.diceNumber);

                Random r = new Random();
                int number = r.nextInt(6)+1;
                String numberString = String.valueOf(number);
                diceNumber.setText(numberString);
            }
        });
        //OnClick D20+6
        D20_6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button D20_6Btn = getActivity().findViewById(R.id.D20_6Btn);
                TextView diceNumber = getActivity().findViewById(R.id.diceNumber);

                Random r = new Random();
                int number = r.nextInt(6)+1;
                int numbertwo = r.nextInt(20)+1;
                String numberString = String.valueOf(number+numbertwo);
                diceNumber.setText(numberString);

            }
        });
/*
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button clearBtn = getActivity().findViewById(R.id.clearBtn);
                TextView diceNumber = getActivity().findViewById(R.id.diceNumber);

                //diceNumber.setText(" ");

            }
        });
*/
        return view;
    }



}
