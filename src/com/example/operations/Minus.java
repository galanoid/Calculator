package com.example.operations;

import com.example.interfaces.Operation;

public class Minus implements Operation {

    public int operation(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }
}
