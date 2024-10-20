import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger bigA = new BigInteger(a, 2);
        BigInteger bigB = new BigInteger(b, 2);

        return bigA.add(bigB).toString(2);
    }
}