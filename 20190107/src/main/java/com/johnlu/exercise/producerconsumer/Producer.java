package com.johnlu.exercise.producerconsumer;

import java.util.List;

/**
 * @author lxp
 * @date 2019/8/8 下午2:49
 * @Version 1.0
 */
public class Producer {
    public int produce(List<Shoe> shoes) {
        Shoe shoe = new Shoe();
        boolean b = shoes.add(shoe);
        return b? 1:0;
    }
}
