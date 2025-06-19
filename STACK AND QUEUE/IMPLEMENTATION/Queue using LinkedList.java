/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newnode=new QueueNode(a);
        if(front==null){
            front = newnode;
            rear=newnode;
        }else{
            rear.next=newnode;
            rear=newnode;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front ==null) return -1;
        int res=front.data;
        front=front.next;
        return res;
	}
    //Function to return the front element of the queue.
    int peek()
    {
        // Your code here
        if(front ==null) return -1;
        return front.data;
    }
    //Function to check if the queue is empty or not.
    boolean isEmpty()
    {
        // Your code here
        return front == null;
    }
    //Function to return the size of the queue.
    int size()
    {
        // Your code here
        int count = 0;
        QueueNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    //Function to clear the queue.
    void clear()
    {
        // Your code here
        front = null;
        rear = null;
    }
}




