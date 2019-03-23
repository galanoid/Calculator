package com.example.operations;

import com.example.interfaces.Operation;

public class Plus implements Operation {
    @Override
    public int operation(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
