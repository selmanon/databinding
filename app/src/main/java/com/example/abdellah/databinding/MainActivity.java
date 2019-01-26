package com.example.abdellah.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abdellah.databinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    public static class Increment extends BaseObservable{
        public String inc;

        @Bindable
        public String getInc() {
            return inc;
        }

        public void setInc(String inc) {
            this.inc = inc;
            notifyPropertyChanged(BR.inc);
        }
    }

    public static class MyHandlers {

        public void onClickIncrement(Increment increment) {
            increment.setInc(Double.toString(Math.random()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Increment increment = new Increment();
        MyHandlers myHandlers = new MyHandlers();
        activityMainBinding.setIncrement(increment);
        activityMainBinding.setHandler(myHandlers);
    }
}
