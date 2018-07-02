public class Counter {

    private int count;
    private int timeWait;

    public Counter() {

    }

    public Counter(int timeWait) {
        this.count = 0;
        this.timeWait = timeWait;
    }

    public void reset() {
        count = 0;
    }

    public Boolean run() {
        if (this.count == this.timeWait) {
            return true;
        } else {
            count += 1;
            return false;
        }
    }

}
