//264. 길 찾기 게임

import java.util.*;

class Solution {
    static class Node {
        int x, y, idx;
        Node l, r;
        Node(int x, int y, int idx) { this.x=x; this.y=y; this.idx=idx; }
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        for (int i=0;i<nodeinfo.length;i++)
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        list.sort((a,b)->a.y==b.y? a.x-b.x : b.y-a.y);

        Node root = list.get(0);
        for (int i=1;i<list.size();i++) insert(root, list.get(i));

        List<Integer> pre = new ArrayList<>(), post = new ArrayList<>();
        traverse(root, pre, post);

        int n=nodeinfo.length;
        int[][] ans = {pre.stream().mapToInt(i->i).toArray(),
                post.stream().mapToInt(i->i).toArray()};
        return ans;
    }

    void insert(Node p, Node c) {
        if (c.x < p.x) { if (p.l==null) p.l=c; else insert(p.l,c); }
        else { if (p.r==null) p.r=c; else insert(p.r,c); }
    }

    void traverse(Node n, List<Integer> pre, List<Integer> post) {
        if (n==null) return;
        pre.add(n.idx);
        traverse(n.l, pre, post);
        traverse(n.r, pre, post);
        post.add(n.idx);
    }
}