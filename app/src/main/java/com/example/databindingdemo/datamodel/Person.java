package com.example.databindingdemo.datamodel;

import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseMethod;
import androidx.databinding.library.baseAdapters.BR;

import com.example.databindingdemo.MainActivity;

public class Person extends BaseObservable {
    private String name;
    private Integer age;
    private String email;

    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public Integer getAge() {
        try{
            if (this.age == null) {
                return null;
            } else {
                return age;
            }
        }catch(NumberFormatException e) {
            throw new NumberFormatException("Wrong format input");
        }
    }

    public void setAge(Integer age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
//    @BindingAdapter("age")
//    public void setAgeAdapter(MainActivity view, int age) {
//        // Important to break potential infinite loops.
//        if (view.age != this.age) {
//            this.age = age;
//        }
//    }
//
//    @InverseBindingAdapter(attribute = "age")
//    public  int getAge(EditText view) {
//        return view.getAge();
//    }

}
