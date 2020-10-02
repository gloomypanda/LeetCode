class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dependencies = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) dependencies.add(new ArrayList<>());
        int[] ret = new int[numCourses];
        int index = 0;
        int[] count = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int[] dependency = prerequisites[i];
            count[dependency[0]]++;
            dependencies.get(dependency[1]).add(dependency[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(count[i] ==0) q.add(i);
        }
        for(int j = 0; j < numCourses && q.size()!=0; j++) {
            int top = q.peek();
            for(int i = 0; i < dependencies.get(top).size(); i++) {
                    count[dependencies.get(top).get(i)]--;
                    if(count[i]==0) q.add(dependencies.get(top).get(i));
            }
            ret[index++] = q.poll();
        }
        if(index!=numCourses) return new int[0];
        return ret;
    }
}
