package ars15.com.mycalc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ars15 on 12/22/2016.
 */

public class MainActivity extends AppCompatActivity {
    //public final static String Int_Extra = "ars15.com.mycalc.convert.n";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button prefixcalci=(Button)findViewById(R.id.prefixcalc);
        Button postfixcalci=(Button)findViewById(R.id.postfixcalc);
        Button infix=(Button)findViewById(R.id.infix);
        Button infixc=(Button)findViewById(R.id.button24);
        Button postfixc=(Button)findViewById(R.id.button21);
        Button prefixc=(Button)findViewById(R.id.button23);
        prefixcalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefixcalclaunch(v);
            }
        });
        postfixcalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postfixcalclaunch(v);
            }
        });
        infix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infixlaunch(v);
            }
        });
        infixc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch("1");
            }
        });
        prefixc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch("2");
            }
        });
        postfixc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch("3");
            }
        });
    }
    void launch(String s)
    {
        Intent intent=new Intent(this,convert.class);
        intent.putExtra("Extra",s);
        startActivity(intent);
    }
    public void prefixcalclaunch(View view)
    {
        Intent intent=new Intent(this,prefix.class);
        startActivity(intent);
    }
    public void postfixcalclaunch(View view) {
        Intent intent = new Intent(this, postfix.class);
        startActivity(intent);
    }
    public void infixlaunch(View view)
    {
        Intent intent=new Intent(this,infix.class);
        startActivity(intent);
    }
}
