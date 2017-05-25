package qa.driver;

import net.sf.cglib.proxy.Enhancer;
import org.openqa.selenium.WebDriver;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class StepFactory {

    private static final Class<?>[] CONSTRUCTOR_ARG_TYPES = {WebDriver.class};

    private static ThreadLocal<StepFactory> stepFactoryThreadLocal = new ThreadLocal<>();

    public static StepFactory getInstance() {
        if (stepFactoryThreadLocal.get() == null) {
            stepFactoryThreadLocal.set(new StepFactory());
        }
        return stepFactoryThreadLocal.get();
    }


    public <T> T initNewStepLibrary(Class<?> aClass, WebDriver driver) {

        StepInterceptor stepInterceptor = new StepInterceptor(aClass);
        Enhancer e = new Enhancer();
        e.setSuperclass(aClass);
        e.setCallback(stepInterceptor);
        return webEnabledStepLibrary(aClass, e, driver);

    }

    private <T> T webEnabledStepLibrary(Class<?> aClass, Enhancer e, WebDriver driver) {
        Object[] arguments = new Object[1];
        arguments[0] = driver;
        return (T) e.create(CONSTRUCTOR_ARG_TYPES, arguments);
    }
}
