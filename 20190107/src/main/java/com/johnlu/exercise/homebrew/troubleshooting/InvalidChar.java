package com.johnlu.exercise.homebrew.troubleshooting;

/**
 * @author lxp
 * @date 2019/10/17 下午4:33
 * @Version 1.0
 */
public class InvalidChar {
    public static void main(String[] args) {

        byte[] bs = new byte[] {0x1c,0x1d,0x1e,0x1f};
        String s = new String(bs);

        char c = 0x03;
        System.out.println(String.valueOf(c));
    }

}
