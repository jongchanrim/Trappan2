package kr.co.trappan.Adapter;


/**
 * Created by thfad_000 on 2016-11-08.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.trappan.Item.DetailInfoComment_item;
import kr.co.trappan.R;

public class DetailInfoCommentAdapter extends RecyclerView.Adapter<DetailInfoCommentAdapter.ViewHolder> {

    Context context;
    List<DetailInfoComment_item> items;

    public DetailInfoCommentAdapter(Context context, List<DetailInfoComment_item> items) {
        this.context=context;
        this.items=items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_infomation,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final DetailInfoComment_item item=items.get(position);

        holder.image.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        holder.id.setText(item.getId());
        holder.content.setText("111");

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        ImageView image;
        TextView title;
        TextView content;

        public ViewHolder(View itemView) {

            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.detail_image);
            title=(TextView)itemView.findViewById(R.id.detail_title);
            content = (TextView)itemView.findViewById(R.id.detail_content);
            id = (TextView)itemView.findViewById(R.id.detail_id);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}


