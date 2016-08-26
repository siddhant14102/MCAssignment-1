package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HintActivity extends AppCompatActivity {

    private static final String TAG = "HintActivity";

    boolean prime(int n) {
        for (int i = 2; i <= n/2; i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint2);
        Intent i=getIntent();
        int r=i.getIntExtra("one",0);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"monofonto.ttf");

        TextView hinttext=(TextView)findViewById(R.id.textViewHint);
        hinttext.setTypeface(mytypeface);

     //   String mystring=String.valueOf(r);



        for(int n=2;n<r/2;n++)
        {
            if(r%2==0) {

                    String hint;
                    hint=r+" is divisble by 2";
                    hinttext.setText(hint);

            }

            else if(r%3==0)
            {
                String hint;
                hint=r+ " is divisble by 3";
                hinttext.setText(hint);
            }

           else if(r%7==0)
            {
                String hint=r+ " is divisible by 7";
                hinttext.setText(hint);
            }
           else if(r%5==0 && r%2==0)
            {
             String hint=r+ " is divisble by 5 and 2";
                hinttext.setText(hint);
            }

             else if(r%5==0)
            {
                String hint=r+ " is divisble by 5";
                hinttext.setText(hint);
            }

            else if(r%3==0 && r%7==0)
            {
                String hint=r+ " is divisble by 3 and 7";
                hinttext.setText(hint);
            }

            else if(r%19==0)
            {
                String hint=r+ " is divisble by 19";
                hinttext.setText(hint);
            }

            else if(r%23==0)
            {
                String hint=r+ " is divisble by 23";
                hinttext.setText(hint);
            }
           else if(r%11==0)
            {
                String hint=r+ " is divisble by 11";
                hinttext.setText(hint);
            }
            else if(r%23==0)
        {
            String hint=r+ " is divisble by 23";
            hinttext.setText(hint);
        }
            else if(r%29==0)
            {
                String hint=r+ " is divisble by 29";
                hinttext.setText(hint);
            }
            else if(r%31==0)
            {
                String hint=r+ " is divisble by 31";
                hinttext.setText(hint);
            }

            else if(prime(r))
            {
                String hint= r+ " may be a prime number";
                hinttext.setText(hint);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnREsume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    public void back(View view)
    {
        finish();
    }
}
