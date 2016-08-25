package retrofitrxandroid.android.com.tutoretrofitrxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.adapters.UsersListAdapter;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.models.User;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.retrofitconfig.interfaces.UsersService;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;

    @BindView(R.id.rlContainer)
    RelativeLayout rlContainer;

    private UsersListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setRetrofit();
    }

    private void setRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getString(R.string.url_json))
                .build();

        UsersService usersService = retrofit.create(UsersService.class);
        Observable<List<User>> usersObservable = usersService.getUsersData();

        usersObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userObserver);
    }

    Observer<List<User>> userObserver = new Observer<List<User>>() {
        @Override
        public void onCompleted() {
            Toast.makeText(MainActivity.this, getString(R.string.message_fetch), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(List<User> users) {
            if (users != null) {
                mAdapter = new UsersListAdapter(users);

                rvUsers.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvUsers.setHasFixedSize(true);
                rvUsers.setAdapter(mAdapter);
            }
        }
    };
}
