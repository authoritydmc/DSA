package DSA.API_CALL;

import retrofit2.Call;
import retrofit2.http.GET;

public interface serviceCalls {

    @GET("users")
    public Call<userResponse> getUser();

    @GET("books")
    public Call<BookReponse> getBooks();
}
