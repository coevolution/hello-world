//
//  ViewController.swift
//  Calculator
//
//  Created by 陆晓鹏 on 2017/4/23.
//  Copyright © 2017年 陆晓鹏. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func operate(_ sender: UIButton) {
        let operation = sender.currentTitle!
        if userIsInTheMiddleOfTypingNumber {
            enter()
        }
        switch operation {
        case "×":performOperation { $0 * $1 }
        case "÷":performOperation { $1 / $0 }
        case "+":performOperation { $0 + $1 }
        case "−":performOperation { $1 - $0 }
        case "√":performOperation { sqrt($0)}
        default: break
        }
    }
    
    func performOperation(operation: (Double, Double) -> Double) {
        if operandStack.count >= 2 {
            displayValue = operation(operandStack.removeLast(), operandStack.removeLast())
            enter()
        }
    }

    @nonobjc
    func performOperation(operation: (Double) -> Double) {
        if operandStack.count >= 1 {
            displayValue = operation(operandStack.removeLast())
            enter()
        }
    }
    var userIsInTheMiddleOfTypingNumber = false
    @IBOutlet weak var display: UILabel!
    @IBAction func appendDigit(_ sender: UIButton) {
        let digit = sender.currentTitle!
        //print("digit = \(digit)")
        if userIsInTheMiddleOfTypingNumber {
            display.text = display.text! + digit
        } else {
            display.text = digit
            userIsInTheMiddleOfTypingNumber = true
        }
        
    }

    var operandStack = Array<Double>()
    @IBAction func enter() {
        userIsInTheMiddleOfTypingNumber = false
        operandStack.append(displayValue)
        print(operandStack)
    }
    
    var displayValue: Double {
        get {
            return NumberFormatter().number(from: display.text!)!.doubleValue
        }
        set {
            display.text = "\(newValue)"
            userIsInTheMiddleOfTypingNumber = false
        }
    }
}

