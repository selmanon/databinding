package com.example.abdellah.databinding;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.abdellah.databinding.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements OnClickHandler {

    ActivityMainBinding activityMainBinding;
    Profile profile;

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "click!",Toast.LENGTH_LONG).show();
        profile.profileAvatar = "http://i.imgur.com/DvpvklR.png";
        activityMainBinding.setProfile(profile);
    }


    public static class Profile extends BaseObservable {
        public String profileAvatar = "https://cdn.radiofrance.fr/s3/cruiser-production/2018/09/c37f1bf6-b36e-4f5a-a866-b46b686c38dc/838_picasso.jpg";
    }

    @BindingAdapter(value = {"imageUrl", "error"}, requireAll = false)
    public static void loadImage(ImageView view, String url, String error) {
        Picasso.get().load(url).error(R.drawable.ic_launcher_foreground).into(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profile = new Profile();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setProfile(profile);
        activityMainBinding.setClickHandler(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
