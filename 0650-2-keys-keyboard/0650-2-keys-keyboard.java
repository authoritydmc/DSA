class Solution {

    private List<Integer> getFactors(int n)
    {
         ArrayList<Integer> primeFactors = new ArrayList<>();

        // Divide by 2 until n is odd
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        // Check for odd divisors from 3 onwards
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        // If n is still greater than 2, it must be a prime number
        if (n > 2) {
            primeFactors.add(n);
        }

        return primeFactors;
    }
    public int minSteps(int n) {
        List<Integer> factors=getFactors(n);
        return factors.stream().reduce(0,(a,b)->a+b);
    }
}