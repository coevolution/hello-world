package com.johnlu.exercise.hongbao;

import java.util.Random;

/**
 * @author lxp
 * @date 2019/8/2 下午9:54
 * @Version 1.0
 */
public class User {
    private String name;
    private int amount;
    public boolean getHongBao(HongBao hb) {
        int curse = hb.getCurrentCount() + 1;
        if(curse > hb.getCount()) {
            return false;
        }
        if(hb.getAmount() == 0) {
            return false;
        }
        int a;
        if(curse == hb.getCount() || hb.getAmount() == 1) {
            //当前为最后一个红包 || 红包剩金额余为最小金额0.01元
            a = hb.getAmount();
        } else {
            do {
                a = new Random().nextInt(hb.getAmount());
                System.out.println("while获取a="+a);
            } while (a == 0);
        }
        System.out.println("本次抢得红包金额:"+a);
        hb.setAmount(hb.getAmount() - a);
        System.out.println("红包剩余金额:"+hb.getAmount());
        hb.setCurrentCount(curse);
        amount = a + amount;
        return true;
    }

    public User(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
