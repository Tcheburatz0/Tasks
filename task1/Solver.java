package task1;

import java.util.Scanner;

public class Solver {

    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int data) {
            value = data;
        }
    }

    static class List {
        ListNode first;
        ListNode last;
        int count;

        public List() {
            count = 0;
            first = null;
            last = null;
        }

        public void Add(int data) {
            ListNode node = new ListNode(data);
            if (count == 0) {
                first = node;
            }
            else {
                last.next = node;
            }
            last = node;
            count++;
        }

        public String MakeList() {
            String list = "";
            ListNode cur = first;
            while (cur != null) {
                list += " " + cur.value;
                cur = cur.next;
            }
            return list;
        }

        static class HashTable {
            public List[] values;
            int N;

            public HashTable(int N) {
                values = new List[N];
                this.N = N;
            }

            public void insert(int newValue) {
                int index = newValue % N;
                if (values[index] == null) {
                    values[index] = new List();
                }
                values[index].Add(newValue);
            }

            public String WriteHash() {
                String hash = "";
                for (int i = 0; i < N; i++) {
                    hash += i + ":";
                    if (values[i] != null) {
                        hash += values[i].MakeList();
                    }
                    if (i != N - 1) hash += System.lineSeparator();
                }
                return hash;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        List.HashTable hashTable = new List.HashTable(N);
        String[] strArray = in.nextLine().split(" +");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
            hashTable.insert(intArray[i]);
        }
        System.out.println(hashTable.WriteHash());
    }
}

