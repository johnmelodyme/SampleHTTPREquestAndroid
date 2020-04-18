package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Adapter.CustomAdapter;
import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model.GetDataService;
import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model.ModelRequest;
import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestActivity extends AppCompatActivity {
    public static final String TAG = "SampleHttpRequest";
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    public void DeclarationInit() {
        recyclerView = findViewById(R.id.rv);
        progressDialog = new ProgressDialog(RequestActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + RequestActivity.class.getSimpleName());
        DeclarationInit();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<ModelRequest>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<ModelRequest>>() {
            @Override
            public void onResponse(Call<List<ModelRequest>> call, Response<List<ModelRequest>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelRequest>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RequestActivity.this,
                        getResources().getString(R.string.app_error),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void generateDataList(List<ModelRequest> photolist) {
        adapter = new CustomAdapter(this, photolist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RequestActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
