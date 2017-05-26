package qa.driver;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public interface StepListener {

    void stepStarted();
    void stepFailed(Throwable failure);
    void stepFinished();
}
