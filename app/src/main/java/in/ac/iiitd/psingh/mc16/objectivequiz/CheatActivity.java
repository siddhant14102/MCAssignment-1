package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String TAG = "CheatActivity";
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
        setContentView(R.layout.activity_cheat);
        Intent i=getIntent();
        int r=i.getIntExtra("one",0);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"monofonto.ttf");

        TextView cheattext=(TextView)findViewById(R.id.CheattextView);
        cheattext.setTypeface(mytypeface);

        if(prime(r))
        {
            String cheat=r+ " is a prime number";
            cheattext.setText(cheat);
        }
        else
        {

            String cheat=r+ " isn't a prime number";
            cheattext.setText(cheat);
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

    public void back1(View view)
    {
        finish();
    }

}
