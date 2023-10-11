package cn.mcwhirl.chapter.chapter3.work2;

import java.math.BigInteger;

public class PrimeRunnable implements Runnable{
    private final BigInteger number;

    public PrimeRunnable(BigInteger number){
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("检测 " + number);
        boolean isPrime = number.isProbablePrime(100); // certainty parameter can be adjusted
        if (isPrime) {
            System.out.println(number + " 是素数");
        } else {
            System.out.println(number + " 不是素数");
        }
    }
}
