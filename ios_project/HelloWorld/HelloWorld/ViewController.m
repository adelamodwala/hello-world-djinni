//
//  ViewController.m
//  HelloWorld
//
//  Created by Adel Amodwala on 2017-09-20.
//  Copyright © 2017 Adel Amodwala. All rights reserved.
//

#import "ViewController.h"
#import "HWHelloWorld.h"

@interface ViewController ()

@end

@implementation ViewController {
    HWHelloWorld *_helloWorldService;
    UIButton *_button;
    UITextView *_textView;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Instantiate the HelloWorld Service
    _helloWorldService = [HWHelloWorld create];
    
    // Create a button programmatically for the demo
    _button = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    [_button addTarget:self action:@selector(buttonWasPressed:) forControlEvents:UIControlEventTouchUpInside];
    [_button setTitle:@"Get Message" forState:UIControlStateNormal];
    _button.frame = CGRectMake(20.0, 20.0, 280.0, 40.0);
    [self.view addSubview:_button];
    
    // Create a text view for message display
    _textView = [[UITextView alloc] init];
    _textView.frame = CGRectMake(20.0, 80.0, 280.0, 380.0);
    [self.view addSubview:_textView];
}

- (void)buttonWasPressed:(UIButton*)sender
{
    NSString *response = [_helloWorldService getHelloWorld];
    _textView.text = [NSString stringWithFormat:@"%@\n%@", response, _textView.text];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
