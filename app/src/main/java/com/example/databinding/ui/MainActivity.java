package com.example.databinding.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.R;
import com.example.databinding.model.User;
import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyClickHandlers handlers;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        user = new User();
        /*user.setName("sunil Kushwah");
        user.setEmail("kussunil513@gmail.com");
        user.setMobile("7669524010");*/

        user.name.set("sunil Kushwah");
        user.email.set("kussunil513@gmail.com");
        user.mobile.set("7669524010");
        user.profileImage.set("http://graph.facebook.com/67563683055/picture?type=square");
        binding.setUser(user);

        handlers = new MyClickHandlers(this);
        binding.setHandlers(handlers);
    }

    public class MyClickHandlers{

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onFabClicked(View view){
            Toast.makeText(getApplicationContext(),"Fab Clicked!",Toast.LENGTH_LONG).show();
            /*user.setName("Sam Chaudhary");
            user.setEmail("chaudhary@gmail.com");*/

            user.name.set("Sam Chaudhary");
            user.email.set("chaudhary@gmail.com");
        }

        public void onButtonClick(View view) {
            Toast.makeText(getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClickWithParam(View view, User user) {
            Toast.makeText(getApplicationContext(), "Button clicked! Name: " + user.name.get(), Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Button long pressed!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
