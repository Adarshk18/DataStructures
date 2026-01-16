import java.util.*;

public class AlienDictionary {

    private static List<Integer> topoSort(int V, List<List<Integer>> adj){
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) q.add(it);
            }
        }
        return topo;
    }
    public static String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(),s2.length());
            boolean foundDiff = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    foundDiff = true;
                    break;
                }
            }

            //edge case 1 : if all matching and the first one is larger than the second one \
            if(!foundDiff && s1.length()>s2.length()){
                return "";
            }
        }

        List<Integer> topoSortt = topoSort(K,adj);

        //edge case 2 : if it contains cycle
        if(topoSortt.size() < K){
            return "";
        }

        StringBuilder ans = new StringBuilder();
        for (int it : topoSortt) {
            ans.append((char) (it + 'a'));
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int N = in.nextInt();
            int K = in.nextInt();

           String[] ans = new String[N];
            for (int i = 0; i < N; i++) {
                ans[i] = in.next();
            }

            String order = findOrder(ans,N,K);
            System.out.println(order + " ");

        }
        in.close();
    }
}
