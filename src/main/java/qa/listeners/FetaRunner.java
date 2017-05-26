package qa.listeners;

import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import qa.annotations.Driver;
import qa.annotations.Steps;
import qa.driver.StepEventBus;
import qa.driver.StepFactory;
import qa.driver.WebDriverFactory;
import qa.listeners.FetaListener;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class FetaRunner extends BlockJUnit4ClassRunner {

    private FetaListener stepListener;

    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public FetaRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
//
//    @Override
//    public void run(final RunNotifier notifier) {
////        if (skipThisTest()) { return; }
//
//        try {
//            RunNotifier localNotifier = initializeRunNotifier(notifier);
//            super.run(localNotifier);
////            fireNotificationsBasedOnTestResultsTo(notifier);
//        } catch (Throwable someFailure) {
//            someFailure.printStackTrace();
//            throw someFailure;
//        } finally {
////            notifyTestSuiteFinished();
////            generateReports();
////            dropListeners(notifier);
////            closeDrivers();
//        }
//    }

    private RunNotifier initializeRunNotifier(RunNotifier notifier) {
        RunNotifier notifierForSteps = new RunNotifier();
        notifierForSteps.addListener(getStepListener());
        return notifierForSteps;
    }

    protected RunListener getStepListener() {
        if (stepListener == null) {
            buildAndConfigureListeners();
        }
        return stepListener;
    }

    private void buildAndConfigureListeners() {

//        if (webTestsAreSupported()) {
//            initPagesObjectUsing(webdriverManager.getWebdriver(requestedDriver));
        FetaListener fetaListener = new FetaListener();
        setStepListener(fetaListener);

        initStepEventBus(fetaListener);

//            initStepFactoryUsing(getPages());
//        } else {
//            setStepListener(initListeners());
//            initStepFactory();
//        }
    }

    private void setStepListener(FetaListener fetaListener) {
        this.stepListener = fetaListener;
    }

    private void initStepEventBus(FetaListener fetaListener) {
        StepEventBus.getEventBus().init(fetaListener);
    }

    private boolean webTestsAreSupported() {
        return getAnnotatedFields(Driver.class).size() > 0;
    }

    /**
     * Running a unit test, which represents a test scenario.
     */
    @Override
    protected Statement methodInvoker(final FrameworkMethod method, final Object test) {

        if (webTestsAreSupported()) {
            WebDriver driver = WebDriverFactory.getDriver();
            injectDriverInto(driver, test);
            injectScenarioStepsInto(driver,test);
//            buildAndConfigureListeners();
//            initPagesObjectUsing(driverFor(method));
//            injectAnnotatedPagesObjectInto(test);
//            initStepFactoryUsing(getPages());
        }

//        injectEnvironmentVariablesInto(test);
//        useStepFactoryForDataDrivenSteps();

//        Statement baseStatement = super.methodInvoker(method, test);
//        return new SerenityStatement(baseStatement, stepListener.getBaseStepListener());
        return super.methodInvoker(method, test);
    }

    private void injectScenarioStepsInto(WebDriver driver, Object test) {
        Set<Field> stepFields = getAnnotatedFields(Steps.class);
        for (Field field : stepFields) {
            try {
                Object steps = StepFactory.getInstance().initNewStepLibrary(field.getType(), driver);
                field.setAccessible(true);
                field.set(test, steps);
            } catch (IllegalAccessException e) {
                throw new Error("Could not access or set step field: "
                    + field
                    + " - is this field public?", e);
            }
        }
    }

    private void injectDriverInto(WebDriver driver, Object test) {
        Set<Field> sd = getAnnotatedFields(Driver.class);
        for (Field field : sd) {
            try {
                field.setAccessible(true);
                field.set(test, driver);
            } catch (IllegalAccessException e) {
                throw new Error("Could not access or set web driver field: "
                    + field
                    + " - is this field public?", e);
            }
        }
    }

    private Set<Field> getAnnotatedFields(Class<? extends Annotation> ann) {
        Set<Field> set = new HashSet<>();
        Class<?> c = getTestClass().getJavaClass();
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(ann)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }
}