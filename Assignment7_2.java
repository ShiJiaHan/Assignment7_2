import java.util.*;

/**
 * Write a description of class Assignment7_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Assignment7_2
{
    public static ArrayList<Integer> findPrime(int n){
        int p = 0;
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 2; i <= n; i++)
        ans.add(i);
        
        while (index < ans.size()){
            p = ans.get(index);
            for (int i = index+1; i < ans.size(); i++){
                if (ans.get(i)%p == 0){
                ans.remove(i);
                i--;
                }
            }
            index++;
        }    
        
        return ans;
    }
    
    public static void primeSum(int n){
        ArrayList<Integer> primes = findPrime(n);
        int index = 0;
        int prime1 = 0;
        int prime2 = 0;
        
        while (index < primes.size()){
            prime1=primes.get(index);
            if (primes.indexOf(n-prime1) != -1){
            prime2 = n-prime1;
            break;
            }
            else
            index++;
            
        }
        
        System.out.println(n+"="+prime1+"+"+prime2);
    }
    
    public static ArrayList<Integer> add(ArrayList<Integer> bigInt1,ArrayList<Integer> bigInt2){
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int index1 = bigInt1.size() - 1;
        int index2 = bigInt2.size() - 1;
        int addingOne = 0;
    
        while (index1 >= 0 || index2 >= 0){
            if (index1 >= 0 && index2 >= 0) {
                int digit1 = bigInt1.get(index1);
                int digit2 = bigInt2.get(index2);
                int result = digit1 + digit2 + addingOne;
                if (result > 9) {
                    addingOne = 1;
                    result = result - 10;
                } else {
                    addingOne = 0;
                }
                ans.add(0, result);
                index1--;
                index2--;
            } else if (index1 >= 0) {
                int digit1 = bigInt1.get(index1);
                int result = digit1 + addingOne;
                if (result > 9) {
                    addingOne = 1;
                    result = result - 10;
                } else {
                    addingOne = 0;
                }
                ans.add(0, result);
                index1--;
            } else if (index2 >= 0) {
                int digit2 = bigInt2.get(index2);
                int result = digit2 + addingOne;
                if (result > 9) {
                    addingOne = 1;
                    result = result - 10;
                } else {
                    addingOne = 0;
                }
                ans.add(0, result);
                index2--;
            }
        }
    
        if (addingOne > 0) ans.add(0, 1);
        
        return ans;
    }
}
