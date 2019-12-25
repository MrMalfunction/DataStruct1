public class Runner {
    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<Integer>();
        for (int i = 1; i <= 20; i++)
            queue.addFirst(i);
        for (int i = 1; i <= 20; i++)
            System.out.println(queue.removeFirst());
    }
}
