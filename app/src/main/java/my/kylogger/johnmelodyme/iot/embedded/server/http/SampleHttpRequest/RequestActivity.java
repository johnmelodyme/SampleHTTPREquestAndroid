package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RequestActivity extends AppCompatActivity {
    public static final String TAG = "SampleHttpRequest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + RequestActivity.class.getSimpleName());
    }

}
