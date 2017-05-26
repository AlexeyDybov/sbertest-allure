package qa.driver;

import com.google.common.collect.Lists;
import qa.listeners.FetaListener;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class StepEventBus {

    private boolean isTestFailed = false;
    private Throwable testFailure;

    private List<StepListener> registeredListeners = new ArrayList<>();
    private static ThreadLocal<StepEventBus> stepEventBusThreadLocal = new ThreadLocal<>();

    public static StepEventBus getEventBus() {
        if (stepEventBusThreadLocal.get() == null) {
            stepEventBusThreadLocal.set(Injectors.getInjector().getInstance(StepEventBus.class));
        }
        return stepEventBusThreadLocal.get();
    }


    public void stepFailed(Throwable failure) {
        for (StepListener stepListener : getAllListeners()) {
            stepListener.stepFailed(failure);
        }
        this.isTestFailed = true;
        this.testFailure = failure;
    }


    protected List<StepListener> getAllListeners() {
        return Lists.newArrayList(registeredListeners);
//        allListeners.addAll(getCustomListeners());
//        return ImmutableList.copyOf(allListeners);
    }

    public void init(StepListener stepListener) {
        registeredListeners.add(stepListener);
    }

    public void stepFinished() {
        for (StepListener stepListener : getAllListeners()) {
            stepListener.stepFinished();
        }
    }
}
