package gd.not.testapplication.net;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by stork on 26/12/2015.
 */
public interface ExampleRetrofitService {

    @GET("/thing")
    public Call<Object> getThing();
}
