package com.example.converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

public class KeyboardFragment extends Fragment {
    ConverterViewModel converterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_keyboard, container, false);

        view.findViewById(R.id.button0).setOnClickListener(i -> converterViewModel.addNumber("0"));
        view.findViewById(R.id.button1).setOnClickListener(i -> converterViewModel.addNumber("1"));
        view.findViewById(R.id.button2).setOnClickListener(i -> converterViewModel.addNumber("2"));
        view.findViewById(R.id.button3).setOnClickListener(i -> converterViewModel.addNumber("3"));
        view.findViewById(R.id.button4).setOnClickListener(i -> converterViewModel.addNumber("4"));
        view.findViewById(R.id.button5).setOnClickListener(i -> converterViewModel.addNumber("5"));
        view.findViewById(R.id.button6).setOnClickListener(i -> converterViewModel.addNumber("6"));
        view.findViewById(R.id.button7).setOnClickListener(i -> converterViewModel.addNumber("7"));
        view.findViewById(R.id.button8).setOnClickListener(i -> converterViewModel.addNumber("8"));
        view.findViewById(R.id.button9).setOnClickListener(i -> converterViewModel.addNumber("9"));

        view.findViewById(R.id.buttonSeparator).setOnClickListener(i -> converterViewModel.addSeparator());
        view.findViewById(R.id.buttonDelete).setOnClickListener(i -> converterViewModel.removeSymbol());
        view.findViewById(R.id.buttonClear).setOnClickListener(i -> converterViewModel.clearInput());

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        converterViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(ConverterViewModel.class);
    }
}
