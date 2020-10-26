package zadanie2;

public class LinkedQueue extends AbstractQueue {
    private ListNode head;
    private ListNode tail;

    public Object element() {
        assert size > 0;
        return head.value;
    }

    public void clear() {
        ListNode node = head;
        while(node != null) {
            ListNode newNode = node.next;
            node = newNode;
        }
        size = 0;
    }

    public void enqueue(Object element) {
        assert element != null;
        tail = new ListNode(element, tail, null);
        if(tail.prev != null) {
            tail.prev.next = tail;
        }
        if (size == 0) {
            head = tail;
        }
        size++;
    }

    public Object dequeue() {
        assert size > 0;
        Object ret = element();
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
        }
        size--;
        return ret;
    }

    @Override
    public String toString() {
        String s = ""; ListNode t = head;
        while (t != null) {
            s +=  " " + t.value;
            t = t.next;
        }
        return super.toString() + " elements: " + s;
    }
}