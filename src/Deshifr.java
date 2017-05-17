import java.util.ArrayList;

/**
 * Created by user on 17.05.2017.
 */
public class Deshifr extends Common implements Runnable  {

    Deshifr(int a,int b, int c, String text){
        super(a,b, c, text);
    }

    @Override
    public void run() {

        Result.res=deshifrTxt(getText());

    }

    public static String deshifrTxt(String text){
//        System.out.println(text);
        int size=getAllLetters().length();
        ArrayList<Integer> numbers=appraisal(size);

        String res="";
        int textSize=text.length();
        for (int i = 0,indexOfLetters,buf; i < textSize; i++) {
            indexOfLetters=getAllLetters().indexOf(text.charAt(i));
            if(indexOfLetters>0){
                if(numbers.indexOf(indexOfLetters)!=numbers.lastIndexOf(indexOfLetters)){
                    buf=getAllLetters().indexOf(text.charAt(++i));
                    res+=getAllLetters().charAt((indexOfLetters+buf)%size);
                }else{
                    res+=getAllLetters().charAt(numbers.indexOf(indexOfLetters));
                }
            }else{
                res+=text.charAt(i);
            }
        }
        return res;
    }
}
