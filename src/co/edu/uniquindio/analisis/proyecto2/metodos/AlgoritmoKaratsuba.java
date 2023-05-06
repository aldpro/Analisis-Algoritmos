package co.edu.uniquindio.analisis.proyecto2.metodos;

public class AlgoritmoKaratsuba {

    private static int makeEqualLength(StringBuilder str1, StringBuilder str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                str1.insert(0, '0');
            }
            return len2;
        }
        else if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                str2.insert(0, '0');
            }
        }
        return len1; // If len1 >= len2
    }

    // The main function that adds two bit sequences and
    // returns the addition
    private static StringBuilder addBitStrings(StringBuilder first, StringBuilder second) {
        StringBuilder result = new StringBuilder();
        int length = makeEqualLength(first, second);
        int carry = 0;

        // Add all bits one by one
        for (int i = length - 1; i >= 0; i--) {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';
            result.insert(0, (char)sum);

            // boolean expression for 3-bit addition
            carry = (firstBit & secondBit)
                    | (secondBit & carry)
                    | (firstBit & carry);
        }

        // if overflow, then add a leading 1
        if (carry == 1) {
            result.insert(0, '1');
        }

        return result;
    }

    // A utility function to multiply single bits of strings
    // a and b
    private static int multiplySingleBit(int a, int b) {
        return a * b;
    }

    // The main function that multiplies two bit strings X
    // and Y and returns result as long integer
    public static long multiply(String X, String Y) {
        // Find the maximum of lengths of X and Y and make
        // length of smaller string same as that of larger
        // string
        int n = Math.max(X.length(), Y.length());
        X = String.format("%" + n + "s", X)
                .replace(' ', '0');
        Y = String.format("%" + n + "s", Y)
                .replace(' ', '0');

        // Base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return Integer.parseInt(X)
                    * Integer.parseInt(Y);

        int fh = n / 2; // First half of string
        int sh = n - fh; // Second half of string

        // Find the first half and second half of first
        // string.
        String Xl = X.substring(0, fh);
        String Xr = X.substring(fh);

        // Find the first half and second half of second
        // string
        String Yl = Y.substring(0, fh);
        String Yr = Y.substring(fh);

        // Recursively calculate the three products of
        // inputs of size n/2
        long P1 = multiply(Xl, Yl);
        long P2 = multiply(Xr, Yr);
        long P3 = multiply(Integer.toBinaryString(
                        Integer.parseInt(Xl, 2)
                                + Integer.parseInt(Xr, 2)),
                Integer.toBinaryString(
                        Integer.parseInt(Yl, 2)
                                + Integer.parseInt(Yr, 2)));

        // Combine the three products to get the final
        // result.
        return P1 * (1L << (2 * sh))
                + (P3 - P1 - P2) * (1L << sh) + P2;
    }
}
