package qa.driver;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class StepEventBus {

    private static ThreadLocal<StepEventBus> stepEventBusThreadLocal = new ThreadLocal<>();

    public static StepEventBus getEvent() {
        if (stepEventBusThreadLocal.get() == null) {
            stepEventBusThreadLocal.set(new StepEventBus());
        }
        return stepEventBusThreadLocal.get();
    }


}
