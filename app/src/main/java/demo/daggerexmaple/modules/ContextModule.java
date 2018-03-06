package demo.daggerexmaple.modules;

import android.app.Activity;
import android.content.Context;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import demo.daggerexmaple.MainActivityScope;

/**
 * Created by saransh on 05/03/18.
 */
@Module
public class ContextModule {
    Context context;

    public ContextModule(Activity activity) {
        context = activity;
    }

    @Provides
    @MainActivityScope
    public Context activityContext() {
        return context;
    }
}
