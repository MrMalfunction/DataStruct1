public class Runner {
    public static void main(String[] args) {
        RandomizedQueue rq = new RandomizedQueue();
        rq.size();
        rq.enqueue(1);
        rq.enqueue(2);
        System.out.println(rq.iterator());
    }
}
