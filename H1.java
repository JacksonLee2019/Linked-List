//Jackson Lee

import java.util.*;
import java.io.*;

public class H1<T extends Comparable <?super T>> {
    //CS 340 Fall 2016 Homework 1
    //Implement a generic singly linked sorted list of comparable objects
    //The list is sorted in ascedning order
    
    private class Node {
        T data;
        Node next;
        Node(T d, Node n) {
            data = d;
            next = n;
        }
    }
    
    private Node head;
    
    public H1() {
        head = null;//no sentinel node
    }
    
    public void insert(T d) {
        if(head == null) {
            head = new Node(d, null);
            return;
        }
        
        if(head != null && head.data.compareTo(d) > 0) {
            head = new Node(d, head); 
            return;
        }
        
        Node temp = head;
        while(temp.next != null && temp.next.data.compareTo(d) < 0) {
            temp = temp.next;
        }
        temp.next = new Node(d, temp.next);
    }
    
    public String toString() {
        return toString(head);
    }
    
    private String toString(Node node) {
        if(node == null) {
            return "";
        }
        
        String s = "";
        s = s + node.data + ", " + toString(node.next);
        
        return s.replaceAll(", $", "");
    }
    
    public static void main(String args[])throws IOException {
        BufferedReader b = new BufferedReader(new FileReader(args[0]));
        String line = b.readLine();
        
        while(line != null) {
            Scanner scan = new Scanner(line);
            scan.useDelimiter(":");
            
            if(scan.next().equals("Integer")) {
                H1 <Integer> list = new H1<Integer>();
                String s = scan.next();
                scan = new Scanner(s);
                scan.useDelimiter(",");
                
                while(scan.hasNextInt()) {
                    int i = scan.nextInt();
                    list.insert(i);
                }                
                scan.close();
                System.out.println(list);
                line = b.readLine();                
            } else {               
                H1 <String> list = new H1<String>();
                String s1 = scan.next();
                scan = new Scanner(s1);
                scan.useDelimiter(",");
                
                while(scan.hasNext()) {
                    String s = scan.next();
                    list.insert(s);
                }               
                scan.close();
                System.out.println(list);
                line = b.readLine();
            }
        }
    }
}