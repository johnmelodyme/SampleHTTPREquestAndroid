package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://raw.githubusercontent.com/johnmelodyme/SampleHTTPREquestAndroid/master/app/src/main/java/my/kylogger/johnmelodyme/iot/embedded/server/http/SampleHttpRequest/Model";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}