package cn.sunguolei.study.StackTest.Impl;

public class LinkedStack {
    //链栈是栈的链式存储结构，由多个节点组成。在链栈中的栈顶为头节点，节点由数据域和指针域组成
    //对链栈的操作都是间接的通过栈顶(头节点)完成。
    //顺序栈是一种特殊的顺序表
    //链栈是一种特殊链表

    //定义节点类
    private class Node {
        public Object data = null; //数据域
        public Node next = null;   //指针域

        //构造函数初始化
        @SuppressWarnings("unused")
        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }
    }/*Node*/

    private Node top = null; //定义栈顶
    private int size = 0;    //定义栈节点数量

    //判断栈空
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    //压栈
    public boolean push(Object obj) {
        //更新头节点，让新节点指向原来的头节点
        System.out.println("压栈成功:" + obj + "指向->" + top);
        top = new Node(obj, top); //压栈是将节点插入到栈顶之前。也就是更新头节点。改变指针指向
        size++; //栈长度++
        return true;
    }

    //出栈
    public Object pop() {
        if (isEmpty()) {
            System.out.println("对不起，目前是空栈，不能出栈");
            return null;
        }
        Node temp = top;     //头节点引用
        top = top.next;        //更新头节点
        temp.next = null;     //释放引用,删除指针指向
        size--;             //栈节点数量-1
        return temp.data;   //出栈
    }

    //返回栈顶元素，但不弹出栈
    public Object peek() {
        return this.top.data; //直接返回栈顶元素
    }

    //遍历栈并打印
    public void display() {
        //从栈顶节点开始到栈底节点null遍历
        while (top != null) {
            System.out.println(top.data);
            top = top.next;
        }
    }

    //返回元素在栈中的位置
    public int getIndex(Object obj) {
        int i = 0;
        while (top != null) {
            if (peek().equals(obj)) {
                return i;
            }
            top = top.next;
            i++;
        }
        return -1;
    }

    //返回栈的长度
    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
//        stack.display();
        System.out.println(stack.getIndex(9));
    }

}
