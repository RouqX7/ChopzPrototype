package com.example.chopstemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseAUser extends AppCompatActivity {

    Button Chef,Customer,DeliveryPerson;
    Intent intent;
    String type;
    ConstraintLayout bgimage;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_auser);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getDrawable(R.drawable.bgimg2),3000);
        animationDrawable.addFrame(getDrawable(R.drawable.bgimg1),3000);

        bgimage = findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        Chef =findViewById(R.id.chef);
        DeliveryPerson= findViewById(R.id.delivery);
        Customer = findViewById(R.id.customer);

        Chef.setOnClickListener(v -> {
            if(type.equals("Email")){
                Intent loginemail = new Intent(ChooseAUser.this, com.example.chopstemplate.Chef.class);
                startActivity(loginemail);
                finish();
            }
            if(type.equals("Phone")){
                Intent loginphone = new Intent(ChooseAUser.this,Chefloginphone.class);
                startActivity(loginphone);
                finish();
            }
            if(type.equals("SignUp")){
                Intent Register = new Intent(ChooseAUser.this, Delivery_Registration.class);
                startActivity(Register);
            }
        });

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Email")){
                    Intent loginemailcust = new Intent(ChooseAUser.this,Login.class);
                    startActivity(loginemailcust);
                    finish();
                }
                if(type.equals("Phone")){
                    Intent loginphonecust = new Intent(ChooseAUser.this,Loginphone.class);
                    startActivity(loginphonecust);
                    finish();
                }
                if(type.equals("SignUp")){
                    Intent Registercust = new Intent(ChooseAUser.this,Registration.class);
                    startActivity(Registercust);
                }
            }
        });

        DeliveryPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")) {
                    Intent loginemailcust = new Intent(ChooseAUser.this, Delivery_Login.class);
                    startActivity(loginemailcust);
                    finish();
                }
                if (type.equals("Phone")) {
                    Intent loginphone = new Intent(ChooseAUser.this, Delivery_Loginphone.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("SignUp")) {
                    Intent Registerdelivery = new Intent(ChooseAUser.this, Delivery_Registration.class);
                    startActivity(Registerdelivery);
                }

            }

        });


    }
}