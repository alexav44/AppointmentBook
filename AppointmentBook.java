
public class AppointmentBook {
    private boolean[][] schedule;
    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }
    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }
    private void reserveBlock(int period, int startMinute, int duration) {
        for (int i = startMinute; i < startMinute + duration; i++)schedule[period - 1][i] = false;
    }
    //Fix from page3
    public int findFreeBlock(int period, int duration) {
    int block = 0;
    for (int i = 0; i < 60; i++) {
        if (isMinuteFree(period, i)) {
            block++;
            if (block == duration)
                return i - duration + 1;
        } else
            block = 0;
    }
    return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
    for (int i = startPeriod; i <= endPeriod; i++) {
        int findFreeBlock = findFreeBlock(i, duration);
        if (findFreeBlock > -1) {
            reserveBlock(i, findFreeBlock, duration);
            return true;
        }
    }
    return false;

}
public void printPeriod(int period) {
    for (int i = 0; i < schedule[period - 1].length - 1; i++)
        System.out.println(i + " " + schedule[period - 1][i]);
}
}