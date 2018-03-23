package curesoft.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Typeface.createFromAsset;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity
{
   Button  signUp,signIn;
    TextView slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp= (Button) findViewById(R.id.signup);
        signIn= (Button) findViewById(R.id.signin);
        slogan = (TextView) findViewById(R.id.textSlogan);
        //Typeface face=Typeface.createFromAsset(getAssets(),"F:\\AndroidEatit\\app\\src\\main\\assets\\fonts\\nabila-59d4693f7a1c3.ttf");
        //slogan.setTypeface(face);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignIn.class);
                startActivity(i);
            }
        });
        //this is my test code

    }
}
