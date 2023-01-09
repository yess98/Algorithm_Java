package Programmers;
import java.util.*; 
class Node {
    int num;
    int x ; 
    int y; 
    Node left; 
    Node right; 
    public Node (int n,int x, int y,  Node l, Node r){
        this.num = n ; 
        this. x = x; 
        this.y = y; 
        this.left = l; 
        this.right = r; 
    }
}
public class Solution_길찾기게임 {
    static int [][] answer; 
    static int index = 0; 
    static ArrayList <int [] > al = new ArrayList <>(); 
    public int[][] solution(int[][] nodeinfo) {
        answer = new int [2][nodeinfo.length];

        for(int i = 0 ; i < nodeinfo.length ; i ++){
            al.add(new int [] {i +1, nodeinfo[i][0], nodeinfo[i][1]}); 
        }
        Collections.sort(al,  new Comparator <int[]>(){
            @Override 
            public int compare (int [] a, int [] b ){
                if (a[2] == b[2]) {
                    return a[0] -b[0]; 
                }
                else return b[2]-a[2]; 
            }
        }); 
        int [] root = al.get(0); 
        Node parent = new Node (root[0],root[1], root[2],null, null); 
        for(int i = 1; i < al.size(); i ++){
            int [] leaf = al.get(i); 
            Node child = new Node(leaf[0], leaf[1], leaf[2], null, null); 
            connect(parent, child); 
        }
        index = 0 ; 
        preorder(parent); 
         index = 0 ; 
        postorder(parent); 
        return answer;
    }
    public static void postorder(Node root){
        if (root.left != null){
            postorder(root.left);
        }
        if (root.right != null){
            postorder(root.right);
        }
         answer[1][index ++] = root.num;
    }
    public static void preorder(Node root){

        answer[0][index ++] = root.num; 
        if (root.left != null){
            preorder(root.left); 
        }

        if(root.right != null){
            preorder(root.right); 
        }
    }
    public static void connect(Node p, Node c){
        if(p.x < c.x) {
            if(p.right == null) {
                p.right = c; 
            }
            else connect(p.right,c); 
        }
        else {
            if (p.left == null){
                p.left = c; 
            }
            else connect(p.left, c); 
        }
    }
}