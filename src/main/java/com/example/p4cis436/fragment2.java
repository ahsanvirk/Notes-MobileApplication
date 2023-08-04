package com.example.p4cis436;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class fragment2 extends Fragment {
    View view;
    DatabaseHelper myDB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        super.onCreate(savedInstanceState);

        ListView listView = view.findViewById(R.id.listView);
        myDB = new DatabaseHelper(getContext());

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(getActivity(), "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
        return view;
    }
}