package demo.daggerexmaple;

import dagger.Component;
import demo.daggerexmaple.modules.ApiModule;
import demo.daggerexmaple.modules.ContextModule;
import demo.daggerexmaple.network.ApiCalls;

/**
 * Created by saransh on 05/03/18.
 */

@Component(modules = {ApiModule.class, ContextModule.class})
@MainActivityScope
public interface ActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
