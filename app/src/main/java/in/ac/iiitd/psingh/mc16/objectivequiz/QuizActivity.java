package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    public Button hintbutton;
    public Button cheatbutton;
    public Integer score=0;

    private static final String TAG = "QuizActivity";
    public Random r;
    public int number;
    public boolean hintenable=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"monofonto.ttf");
        TextView mytextview=(TextView) findViewById(R.id.textViewer);
        TextView truetext=(TextView) findViewById(R.id.TrueButton);
        TextView falsetext=(TextView) findViewById(R.id.FalseButton);
        TextView nexttext=(TextView) findViewById(R.id.next_button);
        TextView scoretext=(TextView) findViewById(R.id.editText);


        scoretext.setTypeface(mytypeface);
        mytextview.setTypeface(mytypeface);
        truetext.setTypeface(mytypeface);
        falsetext.setTypeface(mytypeface);
        nexttext.setTypeface(mytypeface);

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked True");
            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
            }
        });


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

   boolean prime(int n) {
        for (int i = 2; i <= n/2; i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void generate(View view) {
         r = new Random();
         number = r.nextInt(1000) + 1;
        TextView mytext = (TextView) findViewById(R.id.textViewer);
        String mystring = String.valueOf(number);
        String question = "Is " + mystring + " a prime number?";
        mytext.setText(question);
        hintbutton=(Button)findViewById(R.id.button2);
        cheatbutton=(Button)findViewById(R.id.button);
        mTrueButton=(Button)findViewById(R.id.TrueButton);
        hintbutton.setClickable(true);
        cheatbutton.setClickable(true);
        hintbutton.setAlpha(1f);
        cheatbutton.setAlpha(1f);
        mTrueButton.setEnabled(true);
        mTrueButton.setAlpha(1f);
        mFalseButton.setEnabled(true);
        mFalseButton.setAlpha(1f);





        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(prime(number)) {
                    Toast.makeText(QuizActivity.this, "Correct :D", Toast.LENGTH_SHORT).show();
                    score++;
                }
                else
                {
                    Toast.makeText(QuizActivity.this, "Incorrect :(", Toast.LENGTH_SHORT).show();
                    score--;

                }
                mTrueButton.setClickable(false);
                mTrueButton.setAlpha(.5f);

            }


        });

        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(prime(number)) {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    score--;
                }
                else
                {
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    score++;

                }
                mFalseButton.setClickable(false);
                mFalseButton.setAlpha(.5f);
            }
        });

        TextView scoreview=(TextView)findViewById(R.id.editText);


        String displayscore="Your Score is: "+score;

        scoreview.setText(displayscore);



    }
    public void hint(View view)
    {
        //Button button=(Button) v;
        Intent i=new Intent(this,HintActivity.class);
        TextView no=(TextView)findViewById(R.id.textViewHint);
      //  Button hintbutton=(Button)findViewById(R.id.button2);
        hintbutton=(Button)findViewById(R.id.button2);

        i.putExtra("one",number);
        hintbutton.setClickable(false);
        hintbutton.setAlpha(.5f);
        startActivity(i);
//        if(!hintbutton.onclick()==false)
//        {
//            Toast.makeText(QuizActivity.this, "Hint can only be used once", Toast.LENGTH_SHORT).show();
//
//        }
    }





    public void cheat(View view)
    {
        Intent i=new Intent(this,CheatActivity.class);
        i.putExtra("one", number);
        hintbutton=(Button)findViewById(R.id.button2);
        cheatbutton=(Button)findViewById(R.id.button);
        cheatbutton.setClickable(false);
        hintbutton.setClickable(false);
        cheatbutton.setAlpha(.5f);
        hintbutton.setAlpha(.5f);
        startActivity(i);
    }


}

