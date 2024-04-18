public class StackOverflowErrorExample {
    public void print(int myInt) {
        System.out.println(myInt);
        print(myInt);
    }

    public static void main(String[] args) {
        StackOverflowErrorExample soee = new StackOverflowErrorExample();
        soee.print(0);
    }
}
