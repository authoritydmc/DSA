package DSA.API_CALL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Optional;

public interface serviceCalls {



    @GET("users")
    public Call<userResponse> getUser(@Query("_quantity") Integer quantity);

    @GET("books")
    public Call<BookReponse> getBooks();
}
