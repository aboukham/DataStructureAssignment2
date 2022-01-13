package lab3.Question2;

public class StudentArray {
    private Student[]   a;
    private int         nElements;

    public StudentArray(int max){
        nElements = 0;
        a = new Student[max];
    }

    public Student find(int id){
        for (Student s: a){
            if (s != null && s.getId() == id)
                return s;
        }
        return null;
    }

    public void insert(int id, String name, int mark){
        if (find(id) != null)
            return ;
        Student std = new Student(id, name, mark);
        if (nElements == a.length)
            System.out.println("The array is full");
        else {
            a[nElements] = std;
            nElements++;
            System.out.println("The Student added successfully");
        }
    }

    public Student remove(int index){
        if (index < 0 || index >= nElements)
            throw new ArrayIndexOutOfBoundsException();
        Student temp = a[index];
        for (int i = index + 1; i < nElements; i++){
            a[i - 1] = a[i];
        }
        nElements--;
        return temp;
    }

    public boolean delete(int id){
        for (int i = 0; i < nElements; i++) {
            if (a[i] != null && a[i].getId() == id) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayAll(){
        System.out.print("[");
        for (int i = 0; i < nElements; i++){
            a[i].displayStudent();
            System.out.println();
        }
    }

    public Student minMark(){
        int minMark = a[0].getMark();
        //min = 0;
        Student     std = a[0];
        for (int i = 0; i < nElements; i++){
            if (a[i] != null && a[i].getMark() < minMark) {
                minMark = a[i].getMark();
                std = a[i];
            }
        }
        return std;
    }

    public Student maxMark(){
        int         maxMark = a[0].getMark();
        Student     std = a[0];
        for (int i = 1; i < nElements; i++){
            if (a[i].getMark() > maxMark) {
                maxMark = a[i].getMark();
                std = a[i];
            }
        }
        return std;
    }

    public static void main(String[] args){
        StudentArray    arr = new StudentArray(5);
        arr.insert(111, "abdelaziz", 100);
        arr.insert(112, "nab", 97);
        arr.insert(113,"taye", 96);
        System.out.println("---------------------------list of students-------------------------");
        arr.displayAll();
        arr.insert(114, "aboukhame", 92);
        arr.insert(115, "zioui", 88);
        arr.insert(116,"lemma", 90);
        System.out.println("---------------------------list of students-------------------------");
        arr.displayAll();
        Student std = arr.find(114);
        System.out.println("---------------------------find a student by id---------------------");
        if (std != null)
            std.displayStudent();
        std = arr.find(222);
        if (std != null)
            std.displayStudent();
        System.out.println("--------------list of students after removing 112-------------------");
        arr.delete(112);
        arr.displayAll();
        System.out.println("-------------the student who has the minimum mark-------------------");
        arr.minMark().displayStudent();
        System.out.println("-------------the student who has the maximum mark-------------------");
        arr.maxMark().displayStudent();
    }
}
