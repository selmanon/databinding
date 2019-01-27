package com.example.abdellah.databinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.abdellah.databinding.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {


    public static class Profile {
        public String profileAvatar = "http://i.imgur.com/DvpvklR.png";
    }

    @BindingAdapter(value = {"imageUrl", "error"}, requireAll = false)
    public static void loadImage(ImageView view, String url, String error) {
        Picasso.get().load(url).error(R.drawable.ic_launcher_foreground).into(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Profile profile = new Profile();
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setProfile(profile);
    }
}
