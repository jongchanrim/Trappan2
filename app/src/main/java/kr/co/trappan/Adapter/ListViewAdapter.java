package kr.co.trappan.Adapter;


/**
 * Created by thfad_000 on 2016-11-08.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    Context context;
    List<List_item> items;
    int item_layout;

    public ListViewAdapter (Context context, List<List_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticelist,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final List_item item=items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());
        holder.desc.setText(item.getDesc());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView date;
        TextView desc;

        public ViewHolder(View itemView) {

            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.notice_image);
            title=(TextView)itemView.findViewById(R.id.notice_title);
            date = (TextView)itemView.findViewById(R.id.notice_date);
            desc = (TextView)itemView.findViewById(R.id.notice_desc);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}


