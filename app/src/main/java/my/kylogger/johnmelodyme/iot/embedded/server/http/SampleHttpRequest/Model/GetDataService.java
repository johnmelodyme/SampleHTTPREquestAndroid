package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("https://raw.githubusercontent.com/johnmelodyme/SampleHTTPREquestAndroid/master/app/src/main/java/my/kylogger/johnmelodyme/iot/embedded/server/http/SampleHttpRequest/Model/data.json")
    Call<List<ModelRequest>> getAllPhotos();
}
