package mobileprogramming.unimelb.com.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String FIRSTLOG = "My Application";
    private static final String BTNCLICK = "Btn Click";
    public static String MESSAGE = "Message";
    public static int MESSAGE_RECEIVE = 1;

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.received_message)
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1: Show log message
        Log.d(FIRSTLOG, "onCreate: This is the first log");

        //Step 2: Show button behaviour
        //        button = findViewById(R.id.button);
        //        button.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Log.d(BTNCLICK,"Button was clicked");
        //            }
        //        });

        //Step 3: Use ButterKnife to add listener to a button
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void outputlog(){

        Log.d(BTNCLICK,"Button was clicked using Butter Knife");
//        Explicit Intents
//        Intent intent = new Intent(this, Main2Activity.class);
//        intent.putExtra(MESSAGE, "Hello from the first activity.");
//        startActivity(intent);

//        Implicit Intents
//        Intent intent = new Intent();
//        intent.setAction("SecondActivity");
//        intent.putExtra(MESSAGE, "Hello from the first activity.");
//        startActivity(intent);

        //Start Activity for Results
        Intent intent = new Intent();
        intent.setAction("SecondActivity");
        intent.putExtra(MESSAGE, "Hello from the first activity.");
        startActivityForResult(intent, MESSAGE_RECEIVE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == MESSAGE_RECEIVE){
            if(resultCode == RESULT_OK){
                message.setText(data.getStringExtra(Main2Activity.RECEIVED_MESSAGE));
            }
        }
    }
}
