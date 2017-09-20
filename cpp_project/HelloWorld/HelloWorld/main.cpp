//
//  main.cpp
//  HelloWorld
//
//  Created by Adel Amodwala on 2017-09-19.
//  Copyright © 2017 Adel Amodwala. All rights reserved.
//

#include <iostream>
#include "hello_world_impl.hpp"

int main(int argc, const char * argv[]) {

    helloworld::HelloWorldImpl hw = helloworld::HelloWorldImpl();
    
    std::string myString = hw.get_hello_world();
    
    std::cout << myString << "\n";
    
    return 0;
}
