package com.epam3.CustomCollection;

//import java.util.AbstractList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
/*public static <T> List<T> asList(T[] a)
{
	return new CustomCollection<T>(a);
}*/

public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
        CustomCollection<Integer> list=new CustomCollection<Integer>();
        list.add(20);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        System.out.println(list.get(3));
        System.out.println(list.remove(3));
        list.print();
    }
}
class CustomCollection<T> //extends AbstractList<T>
{
    private Object arr[]= {};
    private int size=0;
    private int capacity=10;
   CustomCollection()
   {
	   arr=new Object[capacity];
   }
   public T get(int index)
   {
	   if(index<0||index>=size) throw new IndexOutOfBoundsException("index: "+index);
	   return (T)arr[index];
   }
   public void add(T ele)
   {
	   if(size==arr.length)
	   {
		   ensureCapacity();
	   }
	   arr[size++]=ele;
   }
   public T remove(int index)
   {
	   if(index<0||index>=size) throw new IndexOutOfBoundsException("index: "+index);
	   T removedEle=(T)arr[index];
	   for(int i=index;i<size-1;i++)
		   arr[i]=arr[i+1];
	   size--;
	   return removedEle;
   }
   public void print()
   {
	   for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
   }
   private void ensureCapacity()
   {
	   int newCapacity=arr.length*2;
	   arr=Arrays.copyOf(arr, newCapacity);
   }
   
}