package gui;
import beings.Being;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface OutputAdapter {
    abstract public void output(Being being);
    abstract public void move(Being being, int newx, int newy, int oldx, int oldy);
}
