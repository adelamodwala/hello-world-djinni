package com.mycompany.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    HelloWorld helloWorldService;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init services
        helloWorldService = HelloWorld.create();

        // Set up view
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        final Button helloButton = (Button) findViewById(R.id.sample_button);
        final Button countButton = (Button) findViewById(R.id.count_button);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.sample_text);
        final TextView textView = new TextView(this);
        scrollView.addView(textView);

        helloButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(helloWorldService.getHelloWorld() + "\n" + textView.getText());
            }
        });

        // This is a STATEFUL call to the C++ backend
        countButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(helloWorldService.getCount() + "\n" + textView.getText());
            }
        });

    }
}
