import java.util.ArrayList;


/**
 * Created by user on 11.05.2017.
 */

public class Main {




    public static void main(String[] args) {
//        String allLetters=Letters.allLetters;
//    String text="рок-группа"
//            +", основанная в 1993 году Дианой Арбениной и Светланой Сургановой. Постоянный участник крупнейших российских рок-фестивалей. Наибольшую известность получили такие песни коллектива, как «31 весна», «Ты дарила мне розы», «Рубеж», «Столица», «Асфальт», «Актриса».";
//
//
//    String shifrTxt=shifrTxt(allLetters,text);
//
//        System.out.println(shifrTxt);
//        System.out.println(deshifrTxt(allLetters,shifrTxt));
//
//    }
//
//    public static int cleanFormula(int x, int size){
//        int res=formula(x);
//        return res<0?size-(Math.abs(res)%size):res%size;
//    }
//
//    public static int formula(int x){
//        return -2*x*x+x*(-3)+9;
//    }
//
//
//    public static ArrayList<Integer> appraisal(int size){
//        ArrayList<Integer> numbers=new ArrayList<>();
//        for (int i =0;i< size;i++){
//            numbers.add(cleanFormula(i,size));
//        }
//        return numbers;
//    }
//
//    public static String shifrTxt(String allLetters,String text){
//        int size=allLetters.length();
//        ArrayList<Integer> numbers=appraisal(size);
//
//        String res="";
//        int textSize=text.length();
//        for (int i = 0,indexOfLetters,buf; i < textSize; i++) {
//            indexOfLetters=allLetters.indexOf(text.charAt(i));
//            if(indexOfLetters>0){
//                buf=cleanFormula(indexOfLetters,size);
//                res+=allLetters.charAt(buf);
//                if(numbers.indexOf(buf)!=numbers.lastIndexOf(buf)){
//                    res+=allLetters.charAt((buf>indexOfLetters?size:0)+indexOfLetters-buf);
//                }
//            }else{
//                res+=text.charAt(i);
//            }
//        }
//        return res;
//    }
//
//    public static String deshifrTxt(String allLetters,String text){
////        System.out.println(text);
//        int size=allLetters.length();
//        ArrayList<Integer> numbers=appraisal(size);
//
//        String res="";
//        int textSize=text.length();
//        for (int i = 0,indexOfLetters,buf; i < textSize; i++) {
//            indexOfLetters=allLetters.indexOf(text.charAt(i));
//            if(indexOfLetters>0){
//                if(numbers.indexOf(indexOfLetters)!=numbers.lastIndexOf(indexOfLetters)){
//                    buf=allLetters.indexOf(text.charAt(++i));
//                    res+=allLetters.charAt((indexOfLetters+buf)%size);
//                }else{
//                    res+=allLetters.charAt(numbers.indexOf(indexOfLetters));
//                }
//            }else{
//                res+=text.charAt(i);
//            }
//        }
//        return res;


//        new Shifr(2,3,4,"Я Роман").run();
//        System.out.println(Result.res);
//        new Deshifr(2,3,4,Result.res).run();
//        System.out.println(Result.res);
    }

}
