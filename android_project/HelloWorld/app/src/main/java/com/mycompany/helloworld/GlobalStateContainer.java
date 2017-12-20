package com.mycompany.helloworld;

import android.app.Application;

import com.mycompany.helloworld.state.HelloWorldState;

/**
 * Created by adel on 20/12/17.
 */

public class GlobalStateContainer extends Application {

    private String userName = "Bobby Lopez";
    public HelloWorldState helloWorldState = new HelloWorldState();

    public void init() {
        this.helloWorldState.init();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
