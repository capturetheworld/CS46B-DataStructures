package linked;

import java.util.*;


public class CharLinkedList 
{
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity()
	{
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null)
		{
			if (visitedNodes.contains(node))
				return false;		// Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}
		
		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}
	
	//finds the CharNode that has the same data
	
	public CharNode find(char ch) {
		//empty
		if (head==null) {
			return null;
		}
		//1 element
		else if (head == tail) {
			if(head.getData()==ch)
				return head;
			else
				return null;
		}
		//vanilla
		else {
			CharNode current = head; //start at head
			while(current.getData()!=ch) {
				if(current != tail) {
					current = current.getNext(); //keep looking
				}
				else {
					return null; //it's the tail and no match
				}
			}
			return current;//found a match
			
		}
		
	}
	
	//duplicates the node and adds after
	public void duplicate(char ch) {
		CharNode duplicateThis = this.find(ch); 
		//there are no matches, or list is empty
		if(duplicateThis == null) {
			return;
		}
		//creates a copy
		CharNode copy = new CharNode(duplicateThis.getData());
		//if there's 1 element
		if(duplicateThis == head && head == tail) {
			duplicateThis.setNext(copy);
			tail = copy;
		}
		//at tail, but there are others left
		
		else {
			//System.out.println("we are duplicating" + ch);
		copy.setNext(duplicateThis.getNext());
		if(duplicateThis.getNext() == null) {
			tail = copy;
		}
		duplicateThis.setNext(copy);
			
		}
		
	}
	
	
	static void sop(Object x) 		{ System.out.println(x); }
}
