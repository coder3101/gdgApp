package com.softminds.gdg.helpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.softminds.gdg.R;
import com.softminds.gdg.utils.GdgEvents;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class LongEventAdapter extends RecyclerView.Adapter<LongEventAdapter.EventHolder> {

    public List<GdgEvents> events;

    private Context ctx;

    public LongEventAdapter(List<GdgEvents> events1){
        this.events = events1;
    }


    @Override
    public EventHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.long_event_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        GdgEvents event = this.events.get(position);
        holder.title.setText(event.getName());
        holder.date.setText(SimpleDateFormat.getDateInstance().format(new Date(event.getTime())));
        holder.extra.setText(event.getExtra_details());

        Glide.with(ctx).setDefaultRequestOptions(RequestOptions.centerInsideTransform()).asBitmap().load(event.getHeadIconUrl()).into(holder.headIcon);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventHolder extends RecyclerView.ViewHolder{

        TextView title, date, extra;
        ImageView headIcon;

        EventHolder(View itemView) {
            super(itemView);
            headIcon  = itemView.findViewById(R.id.image_long_adapter);
            title = itemView.findViewById(R.id.long_adapter_event_title);
            date = itemView.findViewById(R.id.long_adapter_event_date);
            extra = itemView.findViewById(R.id.long_adapter_extra_details);
        }
    }
}