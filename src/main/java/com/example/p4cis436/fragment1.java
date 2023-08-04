package com.example.p4cis436;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class fragment1 extends Fragment {
    DatabaseHelper myDB;
    Button btnAdd;
    EditText editText;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        super.onCreate(savedInstanceState);
        editText = view.findViewById(R.id.editText);
        btnAdd = view.findViewById(R.id.btnAdd);
        myDB = new DatabaseHelper(getActivity());
        Button deletedata = view.findViewById(R.id.deletedata);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(getActivity(), "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });
        deletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    myDB.delete();
                    Toast.makeText(getActivity(), "Deleted!", Toast.LENGTH_LONG).show();
            }
        });
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color);
    return view;

    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(getActivity(), "Your data has been successfully entered!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(), "Sorry :( something is wrong.", Toast.LENGTH_LONG).show();
        }
    }

}