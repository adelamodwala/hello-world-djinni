package com.mycompany.helloworld.state;

import com.mycompany.helloworld.HelloWorld;

/**
 * Created by adel on 20/12/17.
 */

public class HelloWorldState {

    private HelloWorld helloWorldService;

    public void init() {
        this.helloWorldService = HelloWorld.create();
    }

    public String getHelloWorld() {
        return this.helloWorldService.getHelloWorld();
    }

    public int getCount() {
        return this.helloWorldService.getCount();
    }
}