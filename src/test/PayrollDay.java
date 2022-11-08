package test;

/**
 * @ClassName PayrollDay
 * @Author jackchen
 * @Date 2022/11/5 15:57
 * @Description TODO
 **/
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKDAY), SUNDAY(PayType.WEEKDAY);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY);
    }
}
