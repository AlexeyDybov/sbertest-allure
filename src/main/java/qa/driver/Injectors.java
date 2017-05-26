package qa.driver;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import qa.listeners.FetaModule;

/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class Injectors {

    private static Injector injector;

    public static synchronized Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new FetaModule());
        }
        return injector;
    }

    public static synchronized Injector getInjector(Module module){
        if (injector == null) {
            injector = Guice.createInjector(module);
        }
        return injector;
    }
}
