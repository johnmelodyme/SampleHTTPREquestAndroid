package my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.Model.ModelRequest;
import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.R;
import my.kylogger.johnmelodyme.iot.embedded.server.http.SampleHttpRequest.RequestActivity;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<ModelRequest> datalist;
    private Context context;

    public CustomAdapter(Context context, List<ModelRequest> datalist) {
        this.datalist = datalist;
        this.context = context;
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView theTextTitle;
        private ImageView theImage;

         CustomViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            theTextTitle = view.findViewById(R.id.thetitle);
            theImage = view.findViewById(R.id.theimage);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View mView = layoutInflater.inflate(R.layout.theview, parent, false);
        return new CustomViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.theTextTitle.setText(datalist.get(position).getTitle());

        Picasso.Builder picBuilder = new Picasso.Builder(context);
        picBuilder.downloader(new OkHttp3Downloader(context));
        picBuilder.build().load(datalist.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.theImage);
    }

    @Override
    public int getItemCount() {
//        return datalist.size();
        return 0;
    }
}
