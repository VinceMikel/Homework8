//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.singlelinkedlist;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Node head = null;
    private Node tail = null;

    public LinkedList() {
    }

    public void append(Node newNode) {
        if (newNode != null) {
            newNode.next = null;
            if (this.head == null) {
                this.head = newNode;
            } else {
                this.tail.next = newNode;
            }

            this.tail = newNode;
        }
    }

    public void prepend(Node newNode) {
        if (newNode != null) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head = newNode;
            }

        }
    }

    public void insertAfter(Node currentNode, Node newNode) {
        if (newNode != null) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else if (currentNode == this.tail) {
                this.tail.next = newNode;
                this.tail = newNode;
            } else {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }

        }
    }

    public void removeAfter(Node currentNode) {
        if (currentNode == null && this.head != null) {
            Node succeedingNode = this.head.next;
            this.head = succeedingNode;
            if (succeedingNode == null) {
                this.tail = null;
            }
        } else if (currentNode != null && currentNode.next != null) {
            Node succeedingNode = currentNode.next.next;
            currentNode.next = succeedingNode;
            if (succeedingNode == null) {
                this.tail = currentNode;
            }
        }

    }

    public long sum() {
        long s = 0L;

        for(Node c = this.head; c != null; c = c.next) {
            s += (long)c.data;
        }

        return s;
    }

    public void print() {
        for(Node c = this.head; c != null; c = c.next) {
            System.out.print(c.data + " ");
        }

        System.out.println();
    }

    public long moveDigit3To(LinkedList dst) {
        long sum = 0L;
        Node prev = null;

        Node nxt;
        for(Node cur = this.head; cur != null; cur = nxt) {
            nxt = cur.next;
            if (sumOfPrimes.hasDigit3(cur.data)) {
                if (prev == null) {
                    this.head = nxt;
                } else {
                    prev.next = nxt;
                }

                if (cur == this.tail) {
                    this.tail = prev;
                }

                cur.next = null;
                dst.append(cur);
                sum += (long)cur.data;
            } else {
                prev = cur;
            }
        }

        return sum;
    }
}
class sumOfPrimes {
    static boolean isPrime(int n) {
        return n < 2 ? false : isPrime(n, 2);
    }

    private static boolean isPrime(int n, int d) {
        if ((long)d * (long)d > (long)n) {
            return true;
        } else {
            return n % d == 0 ? false : isPrime(n, d + 1);
        }
    }

    static boolean hasDigit3(int x) {
        while(x > 0) {
            if (x % 10 == 3) {
                return true;
            }

            x /= 10;
        }

        return false;
    }

    static LinkedList primesUpTo(int n) {
        LinkedList list = new LinkedList();

        for(int x = 2; x <= n; ++x) {
            if (isPrime(x)) {
                list.append(new Node(x));
            }
        }

        return list;
    }
}

