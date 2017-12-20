package com.mycompany.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.mycompany.helloworld.MainActivity.TEST_MESSAGE;

/**
 * Created by adel on 17/12/17.
 */

public class TesterActivity extends AppCompatActivity {

    private GlobalStateContainer gs;
    HelloWorld helloWorldService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init services
        gs  = (GlobalStateContainer) getApplication();
        helloWorldService = HelloWorld.create();

        setContentView(R.layout.activity_tester);
        Intent intent = getIntent();

        final Button byeButton = (Button) findViewById(R.id.bye_button);
        final TextView testMessage = (TextView) findViewById(R.id.test_message);
        testMessage.setText(String.format("Count: %d\n%s\n%s\n%s", gs.helloWorldState.getCount(), gs.getUserName(), helloWorldService.getHelloWorld(), intent.getStringExtra(TEST_MESSAGE)));

        byeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gs.setUserName("Robert Mueller");
                finish();
            }
        });
    }
}
