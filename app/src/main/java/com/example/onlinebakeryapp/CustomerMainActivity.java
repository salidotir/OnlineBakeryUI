package com.example.onlinebakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class CustomerMainActivity extends AppCompatActivity implements View.OnClickListener, ChangePasswordDialog.ChangePasswordDialogListener {

    AlphaAnimation buttonClick;

    LinearLayout menu_item;
    FrameLayout bottom_menu_with_alpha;
    Button btn_menu;
    Button btn_change_password;
    Button btn_profile;
    Button btn_about;
    Button btn_customer_wallet;
    Button btn_cart;

    Animation open_menu;
    Animation close_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);

        // define menu
        bottom_menu_with_alpha = findViewById(R.id.bottom_menu_with_alpha);

        // define menu buttons
        btn_menu = findViewById(R.id.btn_menu);
        menu_item = findViewById(R.id.menu_item);
        btn_menu.setOnClickListener(this);

        btn_change_password = findViewById(R.id.btn_change_password);
        btn_change_password.setOnClickListener(this);

        btn_profile = findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(this);

        btn_about = findViewById(R.id.btn_about);
        btn_about.setOnClickListener(this);

        btn_customer_wallet = findViewById(R.id.btn_customer_wallet);
        btn_customer_wallet.setOnClickListener(this);

        btn_cart = findViewById(R.id.btn_cart);
        btn_cart.setOnClickListener(this);

        // define menu animations
        open_menu = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.open_menu);
        close_menu = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close_menu);

        // button click animation
        buttonClick = new AlphaAnimation(1F, 0.8F);
    }

    @Override
    public void applyPasswordChange(String old_pass, String new_pass1, String new_pass2) {
        // call change password function
    }

    @Override
    public void onClick(View v) {
        // default method for handling onClick Events...
        switch (v.getId()) {
            case R.id.btn_menu:
                btn_menu.startAnimation(buttonClick);
                if(menu_item.getVisibility() == View.VISIBLE){
                    menu_item.startAnimation(close_menu);
                    btn_menu.setRotation(0);
                    menu_item.setVisibility(View.INVISIBLE);
                    bottom_menu_with_alpha.setVisibility(View.INVISIBLE);
                }

                else if(menu_item.getVisibility() == View.INVISIBLE){
                    bottom_menu_with_alpha.setVisibility(View.VISIBLE);
                    menu_item.setVisibility(View.VISIBLE);
                    menu_item.startAnimation(open_menu);
                    btn_menu.setRotation(180);
                }
                break;

            case R.id.btn_change_password:
                ChangePasswordDialog changePasswordDialog = new ChangePasswordDialog();
                changePasswordDialog.show(getSupportFragmentManager(), "Change password dialog");
                break;

            case R.id.btn_profile:
                Intent intent = new Intent(CustomerMainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_about:
                break;

            case R.id.btn_cart:
                break;

            case R.id.btn_customer_wallet:
                break;
        }
    }

}
