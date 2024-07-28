import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(reversString("reverse"));
        System.out.println(revereStringSwap("reverse"));
        System.out.println(reverseCollection("reverse"));
    }

    /**
     * Use of stream for operate the reverse mode
     * in the iterate method we have to define where we start to process
     * the predicate and the operation that we will process it
     * after it, we convert it
     * @param cad - string value set by user
     * @return String - new cad
     */
    private static String reversString(String cad){
        return Stream.iterate(cad.length()-1,n -> n>=0,n -> n-1).map(cad::charAt).map(String::valueOf).collect(Collectors.joining());
    }

    /**
     * Method to reverse a string using a for loop,
     * The only thing is to think in process only half
     * as we have process the same as we swap from the end
     * @param cad - string value set by user
     * @return String - new cad
     */
    private static String revereStringSwap(String cad){
        char[] cadArray = cad.toCharArray();
        for(int index= 0, indexEnd= cadArray.length-1; index< (cadArray.length -1)/2;index++,indexEnd--){
            char lastChar =cadArray[indexEnd];
            cadArray[indexEnd]=cadArray[index];
            cadArray[index]=lastChar;
        }
        return new String(cadArray);
    }

    /**
     * Method to reverse a string using a Collection,
     * The only thing is to convert in a list,
     * and after it converts the list in a String
     * @param cad - string value set by user
     * @return String - new cad
     */
    private static String reverseCollection(String cad){
        List<Character> newList = cad.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.reverse(newList);
        return newList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}