package hash_tables;
public class HashFunctions {
    
    public static int polynomialRolling(String s) {
        int hashValue  = 0;
        int p = 53;
        int p_pow = 1;
        int m = 120;

        for(int i=0; i<s.length(); i++) {
            hashValue += (int)((s.charAt(i) - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }

        return hashValue;
    }

    public static int divisionMethod(int K, int m) {
        return K % m;
    }
}
