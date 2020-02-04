package ru.job4j.oop.tracker;

import java.util.function.Consumer;

public class StubAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer output) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}