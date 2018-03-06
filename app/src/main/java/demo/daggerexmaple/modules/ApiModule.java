package demo.daggerexmaple.modules;

import dagger.Module;
import dagger.Provides;
import demo.daggerexmaple.MainActivityScope;
import demo.daggerexmaple.network.ApiCalls;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saransh on 05/03/18.
 */
@Module
public class ApiModule {

    @Provides
    @MainActivityScope
    public ApiCalls apiCalls(Retrofit retrofit)
    {
        return retrofit.create(ApiCalls.class);
    }

    @Provides
    @MainActivityScope
    public Retrofit retrofitClient()
    {
        return new Retrofit.Builder().baseUrl("https://api.github.com/users/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
