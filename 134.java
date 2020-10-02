public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum=0;
        for(int i = 0; i < gas.length; i++) {
            gas[i]-=cost[i];
            sum+=gas[i];
        }
        if(sum<0) return -1;
        
        for(int i = 0; i < gas.length; i++) {
            int j = i;
            int tcost = 0;
            while(true) {
                if((j+1)%len == i) {
                    break;
                }
                tcost+=gas[j];
                if(tcost<0) {
                    i = j;
                    break;
                }
                j = (j+1)%len;
            }
            if(tcost>=0) return i;
        }
        return 0;
    }
