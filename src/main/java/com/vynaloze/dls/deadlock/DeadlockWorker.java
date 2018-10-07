package com.vynaloze.dls.deadlock;

public class DeadlockWorker implements Runnable {
    private final Obj a;
    private final Obj b;

    public DeadlockWorker(Obj a, Obj b) {
        this.a = a;
        this.b = b;
    }

    private void swapValues() {
        System.out.println(String.format("Before: a=%s b=%s", a, b));
        int oldA = a.getValue();
        synchronized (a) {
            System.out.println(String.format("Setting: a (%s) to %s", a, b));
            a.setValue(b.getValue());
            synchronized (b) {
                System.out.println(String.format("Setting b (%s) to %s", b, oldA));
                b.setValue(oldA);
            }
        }
        System.out.println(String.format("After: a=%s b=%s", a, b));
    }

    @Override
    public void run() {
        swapValues();
    }
}
