package lab3.Question3;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List<Marketing> list = new ArrayList<>();

    public void add(Marketing mark){
        list.add(mark);
    }

    public Marketing remove(int index){
        return list.remove(index);
    }

    public Marketing set(int index, Marketing mark){
        return list.set(index, mark);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("[");
       for (Marketing m : list){
           sb.append(m + ",\n ");
       }
       sb.append(" ]");
       return sb.toString();
    }

    public int size(){
        return list.size();
    }

    public void totalSalesAmount(){
        double  total = 0.0;
        for (Marketing m : list){
            total += m.getSalesAmount();
        }
        System.out.println("The total sales amount: " + total);
    }

    public static void main(String[] args){
        MyList  arr = new MyList();
        Marketing m1 = new Marketing("abdelaziz", "car", 12000);
        Marketing m2 = new Marketing("abdelilah", "laptop", 2000);
        Marketing m3 = new Marketing("mariam", "phone", 700);
        Marketing m4 = new Marketing("kareem", "house", 172000);
        Marketing m5 = new Marketing("brahim", "car", 7000);

        arr.add(m1);
        arr.add(m2);
        arr.add(m3);
        arr.add(m4);

        System.out.println("#####################################################################");
        System.out.println(arr);
        System.out.println("size: " + arr.size());
        arr.totalSalesAmount();

        arr.set(1, m5);
        System.out.println("#####################################################################");
        System.out.println(arr);
        System.out.println("size: " + arr.size());
        arr.totalSalesAmount();

        arr.remove(0);
        System.out.println("#####################################################################");
        System.out.println(arr);
        System.out.println("size: " + arr.size());
        arr.totalSalesAmount();
        System.out.println("#####################################################################");
        System.out.println(arr.list.get(2));

        arr.list.clear();
        System.out.println("#####################################################################");
        System.out.println(arr);
        System.out.println("size: " + arr.size());
        arr.totalSalesAmount();
        System.out.println("#####################################################################");

    }
}
