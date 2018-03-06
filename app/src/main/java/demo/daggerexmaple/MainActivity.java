package demo.daggerexmaple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import demo.daggerexmaple.Data.GitPojo;
import demo.daggerexmaple.modules.ContextModule;
import demo.daggerexmaple.network.ApiCalls;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiCalls apiCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityComponent component = DaggerActivityComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        component.injectMainActivity(this);

        apiCalls.getUserDetails("pranay1494")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitPojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GitPojo gitPojo) {
                        Log.v("sahb", "login-ID: " + gitPojo.getLogin());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
