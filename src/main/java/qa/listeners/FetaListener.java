package qa.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.driver.StepInterceptor;
import qa.driver.StepListener;
import ru.yandex.qatools.allure.junit.AllureRunListener;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class FetaListener extends AllureRunListener implements StepListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetaListener.class);


    @Override
    public void stepStarted() {
    }

    @Override
    public void stepFailed(Throwable failure) {
    }

    @Override
    public void stepFinished() {
        LOGGER.info("thread " + this.toString());
    }
}
