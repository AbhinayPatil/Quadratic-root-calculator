package com.example.quadraticroots;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText a,b,c;
    TextView Ans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DecimalFormat df = new DecimalFormat("#0.00");
        button = findViewById(R.id.button);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        Ans = findViewById(R.id.Ans);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
                double a1 = Double.parseDouble(a.getText().toString());
                double b1 = Double.parseDouble(b.getText().toString());
                double c1 = Double.parseDouble(c.getText().toString());
                double sumOfZeroes = -b1/a1;
                double productOfZeroes = c1/a1;
                double s = (sumOfZeroes/2.0);
                String sf = df.format(s);
                double u = (sumOfZeroes/2.0)*(sumOfZeroes/2.0);
                double v = u - productOfZeroes;
                double x = Math.sqrt(v);
                double r1 = (sumOfZeroes/2.0)-x;
                double r2 = (sumOfZeroes/2.0)+x;
                String rf1 = df.format(r1);
                String rf2 = df.format(r2);

                if(v>=0){
                    Ans.setText("Roots of equation are:"+rf1+" ans "+rf2);
                }
                if(v<0){
                    double y =  Math.sqrt(-v);
                    String yf = df.format(y);
                    Ans.setText(" The roots are: "+sf+"+i"+yf+" and "+sf+"-i"+yf);
                }
            }
        });
    }
}