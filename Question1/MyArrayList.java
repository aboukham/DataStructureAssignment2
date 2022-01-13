package lab3.Question1;

import java.util.Arrays;
import java.util.Random;

public class MyArrayList {
    private int[]   arr;
    private int     size = 0;

    public void insert(){
        arr = new int[50];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(101);
            size++;
        }
    }
    public int remove(int index){
        if (index < 0 || index >= arr.length)
            throw new ArrayIndexOutOfBoundsException();
        int temp = arr[index];
        for (int i = index + 1; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        size--;
        return temp;
    }
    public void removeDuplicates(){
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                if (arr[i] == arr[j])
                    remove(j);
            }
        }
    }

    public void clear(){
        arr = new int[0];
        size = 0;
    }

    public int size(){
        return size;
    }

    public int get(int index){
        if (index < 0 || index >= arr.length)
            throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    public int[] subList(int start, int end){
        if (start < 0 || start >= size || end < 0 || end > size)
            throw new ArrayIndexOutOfBoundsException();
        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public int set(int index, int newValue){
        if (index < 0 || index >= arr.length)
            throw new ArrayIndexOutOfBoundsException();
        int oldValue = arr[index];
        arr[index] = newValue;
        return oldValue;
    }

    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        list.insert();
        System.out.println("The number of element s is " + list.size() + "\n" + Arrays.toString(list.arr));
        list.removeDuplicates();
        System.out.println("The number of element s is " + list.size() + "\n" + Arrays.toString(list.arr));
        System.out.println(list.get(2));
        System.out.println(list.set(2, -7));
        System.out.println("The number of element s is " + list.size() + "\n" + Arrays.toString(list.arr));
        System.out.println(Arrays.toString(list.subList(2, 5)));
        list.clear();
        System.out.println(Arrays.toString(list.arr));
    }
}
