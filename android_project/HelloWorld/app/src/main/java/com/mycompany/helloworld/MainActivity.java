package com.mycompany.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button) findViewById(R.id.sample_button);
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.sample_text);
                tv.setText(helloWorldService.getHelloWorld() + "\n" + tv.getText());
            }
        });

    }
}
