package test;

/**
 * @ClassName PayType
 * @Author jackchen
 * @Date 2022/11/5 16:00
 * @Description TODO
 **/
public enum PayType {
    WEEKDAY {
        @Override
        int overtimePay(int minsWorked, int payRate) {
            return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
        }
    },
    WEEKEND {
        @Override
        int overtimePay(int minsWorked, int payRate) {
            return minsWorked * payRate / 2;
        }
    };

    abstract int overtimePay(int mins, int payRate);

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minsWorked, int payRate) {
        int basePay = minsWorked * payRate;
        return basePay + overtimePay(minsWorked, payRate);
    }
}
