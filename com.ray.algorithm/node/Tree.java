package node;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String[] args) {
        Node node5 = new Node(4, 1, "ROOT_2_1", null);
        Node node2 = new Node(1, 0, "ROOT_2", List.of(node5));
        Node node4 = new Node(3, 2, "ROOT_3_1", null);
        Node node3 = new Node(2, 0, "ROOT_3", List.of(node4));
        Node node6 = new Node(5, 0, "ROOT_3", null);
        Node root = new Node(0, null, "ROOT", List.of(node6, node2, node3));
        List<Node> nodeList = root.childList;

        List<Node>childList = new ArrayList<>();
        Node node = new Node(0, null, "ROOT", childList);

        nodeList.forEach(o-> {
            if(query(o, "ROOT_3")) {
                childList.add(o);
            }
        });

        System.out.println(node);


        System.out.println(sub("assdsawewsdsdasasddaldlssssddaaerfrelsdldsfesefewfeferfrefrefefqqfefawefqwefesssdsdsd", "assdsawewsdsdasasddaldlssssddaaerfrelsdldsfesefewfeferfrefrefefqqfefawefqwefe"));


    }

    public static boolean query(Node root, String key) {
       if (root == null) {
           return false;
       }
       if (root.key.equals(key)) {
           return true;
       }
        System.out.println(root.key);
        List<Node> childList = root.childList;
       if (childList != null) {
           childList.forEach(o-> {
               query(o, key);
           });
       }
       return false;
    }

    public static class Node {
        Integer id;

        Integer parentId;

        String key;

        List<Node> childList;

        public Node (Integer id, Integer parentId, String key, List<Node> childList){
            this.id = id;
            this.parentId = parentId;
            this.key = key;
            this.childList = childList;
        }
    }


    public static boolean sub(String str, String subStr) {
        char[] chr = str.toCharArray();
        char[] subChr = subStr.toCharArray();
        int length = subChr.length;
        for (int i = 0; i < chr.length; i++) {
            if (i + length > chr.length) {
                return false;
            }
            String s = String.valueOf(chr[i]);
            for (int j = i + 1; j < i + length; j++) {
                s = s + chr[j];
            }
            if (s.equals(subStr)) {
                return true;
            }
        }
        return false;
    }
}
