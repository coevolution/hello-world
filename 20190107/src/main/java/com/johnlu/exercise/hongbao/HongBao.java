package com.johnlu.exercise.hongbao;

/**
 * @author lxp
 * @date 2019/8/2 下午10:03
 * @Version 1.0
 */
public class HongBao {
    private int count;
    private int amount;
    private int currentCount;

    public HongBao(int count, int amount) {
        this.count = count;
        this.amount = amount;
        currentCount = 0;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    @Override public String toString() {
        return "红包{" + "个数=" + count + ", 总金额=" + amount + ", 当前已抢=" + currentCount + '}';
    }
}
