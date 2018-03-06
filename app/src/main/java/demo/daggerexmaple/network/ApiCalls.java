package demo.daggerexmaple.network;


import demo.daggerexmaple.Data.GitPojo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by saransh on 05/03/18.
 */

public interface ApiCalls {
    @GET("{user}")
    Observable<GitPojo> getUserDetails(@Path("user") String user);
}
