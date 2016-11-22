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

import com.androidquery.AQuery;

import java.util.List;

import kr.co.trappan.Bean.Review;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    Context context;
    List<Review> items;
    AQuery aq;

    public ReviewListAdapter(Context context, List<Review> items) {
        this.context=context;
        this.items=items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_infomation,parent,false);
        ViewHolder holder = new ViewHolder(v);
        aq=new AQuery(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Review item=items.get(position);

        if(item.getImg_1()==null){

        }else{
            aq.id(holder.image).image(item.getImg_1());
        }

        holder.title.setText(item.getReview_title());
        holder.id.setText(item.getId());
        holder.content.setText(item.getReview_content());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void setItems(List<Review> items) {
        this.items = items;
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


