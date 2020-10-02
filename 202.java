int sumDigits(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n%10;
            sum+=(digit*digit);
            n/=10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int slowSum = n;
        int fastSum = n;
        do {
            slowSum=sumDigits(slowSum);
            fastSum=sumDigits(fastSum);
            fastSum=sumDigits(fastSum);
        }while(slowSum!=fastSum);
        return slowSum==1;
    }
