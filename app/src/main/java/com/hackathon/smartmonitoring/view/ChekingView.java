package com.hackathon.smartmonitoring.view;

public interface ChekingView {
    void checkMemory(String msg);
    void checkStates(String msg);
    void checkChachingratio(String msg);
    void checkChachingratioIndex(String msg);
    void errorMessage(String msg);

}
