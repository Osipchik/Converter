package com.example.converter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Objects;


public class ConverterViewModel extends AndroidViewModel {
    private final MutableLiveData<String> liveDataInput = new MutableLiveData<>("");
    private final MutableLiveData<String> liveDataResult = new MutableLiveData<>("");
    private double conversionFactor = 1.0;

    public ConverterViewModel(@NonNull Application application) {

        super(application);
    }

    public void addNumber(String item) {
        liveDataInput.setValue(liveDataInput.getValue() + item);
        convertField();
    }

    public void addSeparator(){
        if (!Objects.requireNonNull(liveDataInput.getValue()).contains(".")) {
            liveDataInput.setValue(liveDataInput.getValue() + ".");
            convertField();
        }
    }

    public void removeSymbol(){
        if (Objects.requireNonNull(liveDataInput.getValue()).length() <= 1) {
            clearInput();
        }
        else
        {
            liveDataInput.setValue(liveDataInput.getValue().substring(0, liveDataInput.getValue().length() - 1));
            convertField();
        }
    }

    public void clearInput(){
        liveDataInput.setValue("");

        liveDataResult.setValue("");
    }

    public LiveData<String> getDataInput(){
        return liveDataInput;
    }

    public LiveData<String> getDataResult(){
        return liveDataResult;
    }

    public void convertField() {
        liveDataResult.setValue(Float.toString((float) (Float.parseFloat(Objects.requireNonNull(liveDataInput.getValue())) * conversionFactor)));
    }

    public void changeConverter(Float conversionFactor){
        this.conversionFactor = conversionFactor;
        if (Objects.requireNonNull(liveDataInput.getValue()).length() != 0){
            convertField();
        }
    }

    public void switchInput(){
        if (!Objects.equals(liveDataResult.getValue(), ""))
        {
            liveDataInput.setValue(liveDataResult.getValue());
            convertField();
        }
    }
}
