package com.jay.java.MyContainer;

import java.util.ArrayList;

/**
 * 
 * @author jay
 * 模拟实现JDK中的ArrayList类，往里面可以丢Object
 *
 */
public class MyArrayList {
	//抄StringBuilder
	 /**
     * The value is used for Object storage.
     */
    private Object[] value;

    /**
     * The count is the number of characters used.
     */
    private int count=0;
    
    /**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	public MyArrayList() {
    	//value = new Object[16];
    	this(16);
    }
    
    public MyArrayList(int size) {
    	if(size < 0) {
    		try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	value = new Object[size];
    }
    
    public void add(Object obj) {
    	value[count] = obj;
    	count++;
    	if(count >= value.length) {
    		//expand array
    		int newCapacity = value.length * 2;
    		Object[] newList = new Object[newCapacity];
    		//System.arraycopy(value, 0, newList, 0, value.length);
    		for(int i = 0; i < value.length; i++) {
    			newList[i] = value[i];
    		}
    		value = newList;
    	}
    }
    
    public Object get(int index) {
    	rangeCheck(index);
    	return value[index];
    }
    
    
    public int indexOf(Object obj) {
       if(obj == null) {
    	   return -1;
       }else {
    	   for(int i = 0; i < value.length; i++) {
    		   if(obj == value[i]) {
    			   return i;
    		   }
    	   }
    	   return -1;
       }
    }

    public int lastIndexOf(Object obj) {
        if(obj == null) {
     	   return -1;
        }else {
     	   for(int i = value.length - 1; i >= 0; i--) {
     		   if(obj == value[i]) {
     			   return i;
     		   }
     	   }
     	   return -1;
        }
     }
    public void rangeCheck(int index) {
    	if(index < 0|| index > count -1) {
    		try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public Object set(int index, Object obj) {
    	rangeCheck(index);
		Object old = value[index];
		value[index] = obj;
		return old;
    }

    public static void main(String[] args) {
    	MyArrayList list = new MyArrayList(2);
    	list.add("ab");
    	list.add(new Human("jay"));
    	list.add(22);
    	ArrayList list2 = new ArrayList();
    	Human h = (Human) list.get(1);
    	System.out.println(h.name);
    	System.out.println(list.get(1));
    }
    
}
