package retrofitrxandroid.android.com.tutoretrofitrxandroid.retrofitconfig.interfaces;

import java.util.List;

import retrofit2.http.GET;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.models.User;
import rx.Observable;

public interface UsersService {
    @GET("users")
    Observable<List<User>> getUsersData();
}
