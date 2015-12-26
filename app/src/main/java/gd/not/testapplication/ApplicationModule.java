package gd.not.testapplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gd.not.testapplication.net.ExampleRetrofitService;
import retrofit.Retrofit;

/**
 * Created by stork on 26/12/2015.
 */
@Module
public class ApplicationModule {

    TestApplication application;

    public ApplicationModule(TestApplication application) {
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
        return new Retrofit.Builder()
                .baseUrl("http://test")
                .build()
                .create(ExampleRetrofitService.class);
    }

}
