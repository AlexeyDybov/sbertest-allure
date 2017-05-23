package qa.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Driver {
    boolean uniqueSession() default false;
//    ClearCookiesPolicy clearCookies() default BeforeEachTest;
    String driver() default "";
}