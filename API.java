package ApplicationTestData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface API
{
    String Base_URL="http://192.168.43.227:9000/person/";


    @GET("demointent")
    Call<String> getStringResponse();

    @POST("posts")
    Call<String> getMessage();

}
