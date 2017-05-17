package window.logic;

import java.util.ArrayList;

/**
 * Created by user on 17.05.2017.
 */
public class Shifr extends Common implements Runnable  {

//    int a=0, b=0, c=0;
//    String text="";

    public Shifr(int a, int b, int c, String text){
    super(a,b, c, text);
    }

    @Override
    public void run() {
        Result.res=shifrTxt(getText());
        System.out.println(Result.res);
    }



    public static ArrayList<Integer> appraisal(int size){
        ArrayList<Integer> numbers=new ArrayList<>();
        for (int i =0;i< size;i++){
            numbers.add(cleanFormula(i,getA(),getB(),getC(),size));
        }
        return numbers;
    }

    public static String shifrTxt(String text){
        int size=getAllLetters().length();
        ArrayList<Integer> numbers=appraisal(size);

        String res="";
        int textSize=text.length();
        for (int i = 0,indexOfLetters,buf; i < textSize; i++) {
            indexOfLetters=getAllLetters().indexOf(text.charAt(i));
            if(indexOfLetters>0){
                buf=cleanFormula(indexOfLetters,getA(),getB(),getC(),size);
                res+=getAllLetters().charAt(buf);
                if(numbers.indexOf(buf)!=numbers.lastIndexOf(buf)){
                    res+=getAllLetters().charAt((buf>indexOfLetters?size:0)+indexOfLetters-buf);
                }
            }else{
                res+=text.charAt(i);
            }
        }
        return res;
    }
}
