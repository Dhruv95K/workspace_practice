/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.*;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class Node{
    int id;
    List<edge> edges;
    long dist;
    public Node(int id){
        this.id = id;
        edges = new ArrayList<>();
        dist = Long.MAX_VALUE;
    }
}
class edge{
    int to;
    long w;
    public edge(int to,long w){
        this.to = to;
        this.w = w;
    }
}
class Reachability {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Node> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int id = sc.nextInt();
            map.put(id,new Node(id));
        }
        
        int e = sc.nextInt();
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            long w = sc.nextLong();
            
            map.get(x).edges.add(new edge(y,w));
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        long canReach = dijkstra(map.get(start),map.get(end),map);
        
        System.out.println(canReach);
        

    }
    
    public static long dijkstra(Node start,Node end,Map<Integer,Node> map){
        Set<Node> visited = new HashSet();
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            
            public int compare(Node o1,Node o2){
                if(o1.dist <= o2.dist)
                    return -1;
                
                return 1;    
            }
            
        });
        start.dist = 0;
        for(Node n :map.values())
            pq.offer(n);
        
        while(!pq.isEmpty()){
            Node u = pq.poll();
            if(u == end)
                return u.dist;
                
            visited.add(u);
            for(edge e : u.edges){
                Node v = map.get(e.to);
                if(!visited.contains(v) && ((u.dist + e.w) < v.dist)){
                    pq.remove(v);
                    v.dist = (u.dist + e.w);
                    pq.offer(v);
                }
            }
        }
        
        return -1;
    }
    
      public static boolean bfs(Node start,Node end,Map<Integer,Node> map){
        Set<Node> visited = new HashSet();
        visited.add(start);
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            Node t = q.poll();
            if(t == end)
                return true;
            
            for(int id : t.nodes){
                Node neighbour = map.get(id);
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    q.add(neighbour);
                }
            }    
        }
        
        return visited.contains(end);
    }
}
