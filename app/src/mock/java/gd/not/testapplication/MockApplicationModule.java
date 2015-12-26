package gd.not.testapplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gd.not.testapplication.net.ExampleRetrofitService;
import retrofit.Call;

/**
 * Created by stork on 26/12/2015.
 */
@Module
public class MockApplicationModule {

    TestApplication application;

    public MockApplicationModule(TestApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public TestApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public ExampleRetrofitService provideService() {
        return new ExampleRetrofitService() {
            @Override
            public Call<Object> getThing() {
                return null;
            }
        };
    }
}
