package gd.not.testapplication;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import gd.not.testapplication.net.ExampleRetrofitService;

/**
 * Created by stork on 26/12/2015.
 */
public class TestApplication extends Application {

    @Inject
    ExampleRetrofitService service;

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerTestApplication_ApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        component.inject(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Singleton
    @Component(modules = {ApplicationModule.class})
    public interface ApplicationComponent {
        void inject(TestApplication app);

        void inject(MainActivity activity);
    }
}
