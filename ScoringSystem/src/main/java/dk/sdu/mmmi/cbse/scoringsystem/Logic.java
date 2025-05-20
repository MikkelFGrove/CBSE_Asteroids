package dk.sdu.mmmi.cbse.scoringsystem;

import org.springframework.stereotype.Service;

@Service
public class Logic {
    private int count = 0;

    public synchronized int set(int input) {
        count = input;
        return count;
    }

    public int get() {
        return count;
    }
}