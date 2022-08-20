package DSA.API_CALL;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Optional;

public class Api_retrofit {

    public static void main(String[] args) throws IOException {
        Retrofit client=RetrofitClient.getClient();

        serviceCalls serviceCalls= client.create(DSA.API_CALL.serviceCalls.class);
      Response<userResponse> userResponse=  serviceCalls.getUser(null).execute();
        Response<BookReponse> bookReponse=  serviceCalls.getBooks().execute();


        System.out.println(userResponse.message());
        for (userDataResponse userDataResponse:userResponse.body().getData())
        {
            System.out.println(userDataResponse);
        }

        for (BookDataResponse bookDataResponse:bookReponse.body().getData())
        {
            System.out.println(bookDataResponse);
        }

    }
}
