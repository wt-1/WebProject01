package Utils;

import java.util.*;

public class AriUtils {
    private int[] a1 = new int[3];
    private int[] a2 = new int[3];
    private int[] a3 = new int[3];
    private int[] a4 = new int[3];
    private int[] a5 = new int[3];
    private int[] a6 = new int[3];
    private int[] a7 = new int[3];
    private int[] a8 = new int[3];
    private int[] a9 = new int[3];
    private int[] a10 = new int[3];
    private int[] b1 = new int[3];
    private int[] b2 = new int[3];
    private int[] b3 = new int[3];
    private int[] b4 = new int[3];
    private int[] b5 = new int[3];
    private int[] b6 = new int[3];
    private int[] b7 = new int[3];
    private int[] b8 = new int[3];
    private int[] b9 = new int[3];
    private int[] b10 = new int[3];
    private int[] c1 = new int[3];
    private int[] c2 = new int[3];
    private int[] c3 = new int[3];
    private int[] c4 = new int[3];
    private int[] c5 = new int[3];
    private int[] c6 = new int[3];
    private int[] c7 = new int[3];
    private int[] c8 = new int[3];
    private int[] c9 = new int[3];
    private int[] c10 = new int[3];


    private int n = 20;
    //生成整式
    public Map<String, Integer> FourAri() {
         int[] result = new int[25];
        Map<String, Integer> map = new HashMap();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            a1[i] = 49 + random.nextInt(51)/(51);
            a2[i] = 49 + random.nextInt(51);
            a3[i] = random.nextInt(100) + 1;
            a4[i] = random.nextInt(100) + 1;
            a5[i] = random.nextInt(100) + 1;
            a6[i] = random.nextInt(100) + 1;
            a7[i] = 49 + random.nextInt(51);
            a8[i] = 9 + random.nextInt(11);
            a9[i] = 49 + random.nextInt(51);
            a10[i] = random.nextInt(100) + 1;
            b1[i] = random.nextInt(50) + 1;
            b2[i] = random.nextInt(50) + 1;
            b3[i] = random.nextInt(100) + 1;
            b4[i] = random.nextInt(100) + 1;
            b5[i] = random.nextInt(50) + 1;
            b6[i] = random.nextInt(50) + 1;
            b7[i] = random.nextInt(10) + 1;
            b8[i] = 9 + random.nextInt(11);
            b9[i] = random.nextInt(50) + 1;
            b10[i] = random.nextInt(10) + 1;
            c1[i] = random.nextInt(50) + 1;
            c2[i] = random.nextInt(100) + 1;
            c3[i] = random.nextInt(100) + 1;
            c4[i] = random.nextInt(100) + 1;
            c5[i] = random.nextInt(10) + 1;
            c6[i] = random.nextInt(100) + 1;
            c7[i] = random.nextInt(10) + 1;
            c8[i] = random.nextInt(100) + 1;
            c9[i] = random.nextInt(10) + 1;
            c10[i] = random.nextInt(10) + 1;
        }
        int j = 0;
        for (int i = 0; i < 2; i++) {
            result[j] = a1[i] + b1[i] - c1[i];
            result[j++] = a2[i] - b2[i] + c2[i];
            result[j++] = a3[i] + b3[i] * c3[i];
            result[j++] = a4[i] * b4[i] + c4[i];
            result[j++] = a5[i] + b5[i] / c5[i];
            result[j++] = a6[i] / b6[i] + c6[i];
            result[j++] = a7[i] - b7[i] * c7[i];
            result[j++] = a8[i] * b8[i] - c8[i];
            result[j++] = a9[i] - b9[i] / c9[i];
            result[j++] = a10[i] / b10[i] - c10[i];
            j++;
        }
        j = 0;

        for (int i = 0; i < 2; i++) {
            map.put(a1[i] + "+" + b1[i] + "-" + c1[i] + "=", result[j++]);
            map.put(a2[i] + "-" + b1[i] + "+" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "+" + b1[i] + "*" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "*" + b1[i] + "+" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "+" + b1[i] + "÷" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "÷" + b1[i] + "+" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "-" + b1[i] + "×" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "×" + b1[i] + "-" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "-" + b1[i] + "÷" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "÷" + b1[i] + "-" + c1[i] + "=", result[j++]);
        }
        return map;
    }

    //生成带括号式子
    public Map<String, Integer> BacketAri() {
        int[] result = new int[25];
        Map<String, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            a1[i] = 49 + random.nextInt(51);
            a2[i] = 49 + random.nextInt(51);
            a3[i] = random.nextInt(100);
            a4[i] = random.nextInt(100);
            a5[i] = random.nextInt(50);
            a6[i] = 49 + random.nextInt(51);
            a7[i] = 49 + random.nextInt(51);
            a8[i] = 9 + random.nextInt(11);
            a9[i] = 49 + random.nextInt(51);
            a10[i] = 49 + random.nextInt(51);
            b1[i] = random.nextInt(50) + 1;
            b2[i] = random.nextInt(25) + 1;
            b3[i] = random.nextInt(100) + 1;
            b4[i] = random.nextInt(100) + 1;
            b5[i] = random.nextInt(100) + 1;
            b6[i] = random.nextInt(10) + 1;
            b7[i] = random.nextInt(50) + 1;
            b8[i] = 49 + random.nextInt(51);
            b9[i] = random.nextInt(50) + 1;
            b10[i] = 49 + random.nextInt(51);
            c1[i] = random.nextInt(50) + 1;
            c2[i] = random.nextInt(25) + 1;
            c3[i] = random.nextInt(100) + 1;
            c4[i] = random.nextInt(100) + 1;
            c5[i] = random.nextInt(50) + 1;
            c6[i] = random.nextInt(10) + 1;
            c7[i] = random.nextInt(10) + 1;
            c8[i] = random.nextInt(50) + 1;
            c9[i] = random.nextInt(10) + 1;
            c10[i] = random.nextInt(50) + 1;
        }
        int j = 0;
        for (int i = 0; i < 2; i++) {
            result[j++] = (a1[i] + b1[i]) - c1[i];
            result[j++] = a2[i] - (b2[i] + c2[i]);
            result[j++] = (a3[i] + b3[i]) * c3[i];
            result[j++] = a4[i] * (b4[i] + c4[i]);
            result[j++] = (a5[i] + b5[i]) / c5[i];
            result[j++] = a6[i] / (b6[i] + c6[i]);
            result[j++] = (a7[i] - b7[i]) * c7[i];
            result[j++] = a8[i] * (b8[i] - c8[i]);
            result[j++] = (a9[i] - b9[i]) / c9[i];
            result[j++] = a10[i] / ((b10[i] + 1) - c10[i]);
        }
        j = 0;
        for (int i = 0; i < 2; i++) {
            map.put("(" + a1[i] + "+" + b1[i] + ")" + "-" + c1[i] + "=", result[j++]);
            map.put(a2[i] + "-" + "(" + b1[i] + "+" + c1[i] + ")" + "=", result[j++]);
            map.put("(" + a1[i] + "+" + b1[i] + ")" + "*" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "*" + "(" + b1[i] + "+" + c1[i] + ")" + "=", result[j++]);
            map.put("(" + a1[i] + "+" + b1[i] + ")" + "÷" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "÷" + "(" + b1[i] + "+" + c1[i] + ")" + "=", result[j++]);
            map.put("(" + a1[i] + "-" + b1[i] + ")" + "×" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "×" + "(" + b1[i] + "-" + c1[i] + ")" + "=", result[j++]);
            map.put("(" + a1[i] + "-" + b1[i] + ")" + "÷" + c1[i] + "=", result[j++]);
            map.put(a1[i] + "÷" + "(" + (b1[i] + 1) + "-" + c1[i] + ")" + "=", result[j++]);
        }
        return map;
    }

}
