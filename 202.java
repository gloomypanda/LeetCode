class Solution {
  public boolean isHappy(int n) {
          Set<Integer> set = new HashSet<>();
          int sum = n;
          while(true) {
              n = sum;
              sum = 0;
              while(n!=0) {
                  sum+=Math.pow(n%10, 2);
                  n/=10;
              }
              if(set.contains(sum)) break;
              if(sum==1) return true;
              set.add(sum);
          }
          return false;
  }
}
