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
    UIButton *_button2;
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
    
    _button2 = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    [_button2 addTarget:self action:@selector(button2WasPressed:) forControlEvents:UIControlEventTouchUpInside];
    [_button2 setTitle:@"Get Count" forState:UIControlStateNormal];
    _button2.frame = CGRectMake(20.0, 80.0, 280.0, 40.0);
    [self.view addSubview:_button2];
    
    // Create a text view for message display
    _textView = [[UITextView alloc] init];
    _textView.frame = CGRectMake(20.0, 160.0, 280.0, 380.0);
    [self.view addSubview:_textView];
}

- (void)buttonWasPressed:(UIButton*)sender
{
    NSString *response = [_helloWorldService getHelloWorld];
    _textView.text = [NSString stringWithFormat:@"%@\n%@", response, _textView.text];
}

- (void)button2WasPressed:(UIButton*)sender
{
    int response = [_helloWorldService getCount];
    _textView.text = [NSString stringWithFormat:@"%d\n%@", response, _textView.text];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
