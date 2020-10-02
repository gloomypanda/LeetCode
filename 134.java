public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum=0;
        int minVal = Integer.MAX_VALUE;
        int start = -1;
        for(int i = 0; i < gas.length; i++) {
            sum+=(gas[i]-cost[i]);
            if(sum<minVal) {
                minVal = sum;
                start = (i+1)%len;
            }
        }
        if(sum<0) return -1;
        return start;
    }
