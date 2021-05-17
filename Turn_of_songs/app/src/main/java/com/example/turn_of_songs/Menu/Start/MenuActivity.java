package com.example.turn_of_songs.Menu.Start;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.turn_of_songs.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSign;
    private Button btnLog;
    private Pair[] nbrAnimation;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supposed to make the notification bar disappear
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        //initialization of the data
        btnSign = findViewById(R.id.btnSign);
        btnLog = findViewById(R.id.btnLogin);
        nbrAnimation = new Pair[1];
        counter = 0;

        //adding an event listener to buttons
        btnLog.setOnClickListener(this);
        btnSign.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        counter++;
        if(counter==2){
            counter=0;
            this.finishAffinity();
        }
        else{
            Toast.makeText(this, "Clic twice to exit", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //if the user click on the button with the id of the login button
            case R.id.btnLogin:
                Intent intentLog = new Intent(MenuActivity.this, LoginActivity.class);
                //animation part
                nbrAnimation[0] = new Pair<View,String>(btnLog,"transition_menu_login_btn");
                //if the user used an upper or an equal version that the LOLLIPOP one
                //he can have an animated transition to the login screen
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MenuActivity.this,nbrAnimation);
                    startActivity(intentLog,options.toBundle());
                }
                //else he don't have a transition and the login screen is launch automatically
                else{
                    startActivity(intentLog);
                }
            break;
             //if the user click on the button with the id of the sign in button
            case R.id.btnSign:
                Intent intentSign = new Intent(MenuActivity.this,SignupActivity.class);
                //animation part
                nbrAnimation[0] = new Pair<View,String>(btnSign,"transition_menu_sign_btn");
                //if the user used an upper or an equal version that the LOLLIPOP one
                //he can have an animated transition to the login screen
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MenuActivity.this,nbrAnimation);
                    startActivity(intentSign,options.toBundle());
                }
                //else he don't have a transition and the login screen is launch automatically
                else{
                    startActivity(intentSign);
                }
            break;

        }
    }
}