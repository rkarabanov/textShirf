package window.logic;

import java.util.ArrayList;

/**
 * Created by user on 17.05.2017.
 */
public class Common {
    public static int a=0;
    public static int b=0;
    public static int c=0;
    static String text="";
    static String allLetters=Letters.allLetters;

    Common(int a,int b, int c, String text){
        this.a=a;
        this.b=b;
        this.c=c;
        this.text=text;
    }
    public static int cleanFormula(int x,int a,int b, int c, int size){
        int res=formula(x,a,b,c);
        return res<0?size-(Math.abs(res)%size):res%size;
    }

    public static int getA() {
        return a;
    }

    public  static int getB() {
        return b;
    }

    public   static int getC() {
        return c;
    }

    public static String getText() {
        return text;
    }

    public static String getAllLetters() {
        return allLetters;
    }

    public static int formula(int x, int a, int b, int c){
        return a*x*x+x*b+c;
    }


    public static ArrayList<Integer> appraisal(int size){
        ArrayList<Integer> numbers=new ArrayList<>();
        for (int i =0;i< size;i++){
            numbers.add(cleanFormula(i,getA(),getB(),getC(),size));
        }
        return numbers;
    }


}
