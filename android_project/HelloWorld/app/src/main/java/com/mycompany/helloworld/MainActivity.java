package com.mycompany.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TEST_MESSAGE = "testTextMessage";
    private GlobalStateContainer gs;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    protected void startTester() {
        Intent testerIntent = new Intent(this, TesterActivity.class);
        testerIntent.putExtra(TEST_MESSAGE, "some call me a chickin'");
        startActivity(testerIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init services
        gs  = (GlobalStateContainer) getApplication();
        gs.init();

        // Set up view
        setContentView(R.layout.activity_main);

        // Get references to view components
        final Button helloButton = (Button) findViewById(R.id.sample_button);
        final Button countButton = (Button) findViewById(R.id.count_button);
        final TextView textView = (TextView) findViewById(R.id.text_messages);
        final TextView userNameView = (TextView) findViewById(R.id.user_name);
        userNameView.setText(gs.getUserName());
        textView.setText(gs.helloWorldState.getHelloWorld());

        helloButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startTester();
            }
        });

        countButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(gs.helloWorldState.getCount() + "\n" + textView.getText());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView userNameView = (TextView) findViewById(R.id.user_name);
        userNameView.setText(gs.getUserName());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        final TextView textView = (TextView) findViewById(R.id.text_messages);
        textView.setText(savedInstanceState.getString("mSampleText"));

        TextView userNameView = (TextView) findViewById(R.id.user_name);
        userNameView.setText(gs.getUserName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save custom state
        TextView textMessages = (TextView) findViewById(R.id.text_messages);
        outState.putString("mSampleText", textMessages.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
