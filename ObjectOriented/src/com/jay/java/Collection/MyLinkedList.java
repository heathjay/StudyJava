package com.jay.java.Collection;
/**
 * linkedlist
 * 对Node构造函数进行改进，加快速度
 * @author jay
 *
 */
public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	/**
	 * @return the first
	 */
	public Node getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(Node first) {
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public Node getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(Node last) {
		this.last = last;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public void add(Object obj) {
		Node node = new Node(obj);
		if(this.first == null) {
			this.first = node;
			this.last = node;
			this.size++;
		}else {
			node.setPre(this.last);
			this.last.setNext(node);
			this.last = node;
			this.size++;
		}
	}
	
	private void rangeCheck(int index) {
		if(index >= this.size || index<0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Object get(int index) {
		this.rangeCheck(index);
		Node tmp = first;
		if(first != null){
			
			for(int i = 0; i < index ; i++) {
				tmp = tmp.getNext();
			}
		}
		return tmp.getObj();
		
	}
	public Node contains(int index) {
		this.rangeCheck(index);
		Node tmp = null;
		if(first != null){
			
			if(index < (this.size >> 1)) {
				tmp=first;
				for(int i = 0; i < index ; i++) {
					tmp = tmp.getNext();
				}
			}else {
				tmp = this.last;
				for(int i = this.size -1; i > index; i--) {
					tmp = tmp.getNext();
				}
			}
			return tmp;
		}
		
		return null;
	}
	public void remove(int index) {
		Node tmp = this.contains(index);
		
		if(tmp != null) {
			Node pre = tmp.getPre();
			Node next = tmp.getNext();
			pre.setNext(next);
			next.setPre(pre);
			this.size--;
		}
		
		
	}
	
	public void add(int index, Object obj) {
		Node node = new Node(obj);
		this.rangeCheck(index);
		Node tmp = this.contains(index);
	
		if(tmp!= null) {
			Node pre = tmp.getPre();
			node.setNext(tmp);
			tmp.setPre(node);
			node.setPre(pre);
			if(pre != null) {
				pre.setNext(node);
				

			
			}else {
				tmp.setPre(node);
				this.first=node;
			}
			this.size++;
		}

			
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(0, "ddd");
		System.out.println(list.size);
		System.out.print(list.get(0));
	}
	
	

}
class Node{
	private Node pre;
	private Object obj;
	private Node next;
	public Node() {
		
	}
	
	
	
	public Node(Object obj) {
		this.pre = null;
		this.next = null;
		this.obj = obj;
	}
	/**
	 * @return the pre
	 */
	public Node getPre() {
		return pre;
	}
	/**
	 * @param pre the pre to set
	 */
	public void setPre(Node pre) {
		this.pre = pre;
	}
	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	
}