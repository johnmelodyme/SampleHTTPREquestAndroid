package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/data.json")
    Call<List<ModelRequest>> getAllPhotos();
}
