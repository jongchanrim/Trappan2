package kr.co.trappan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import kr.co.trappan.Item.SearchList_item;
import kr.co.trappan.R;

import static android.support.v7.appcompat.R.id.image;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    List<SearchList_item> items;
    int item_layout;

    public SearchListAdapter (Context context, List<SearchList_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        SearchListAdapter.ViewHolder holder = new SearchListAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchListAdapter.ViewHolder holder, int position) {

        final SearchList_item item=items.get(position);

        holder.image.setImageResource(item.getImage());
        holder.region.setText(item.getRegion());
        holder.star.setText(item.getStar());
        holder.like.setText(item.getLike());
        holder.stamp.setText(item.getStamp());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView region;
        TextView star;
        TextView like;
        TextView stamp;


        public ViewHolder(View itemView) {
            super(itemView);

            image=(ImageView)itemView.findViewById(R.id.search_imageVIew);
            region=(TextView)itemView.findViewById(R.id.search_region);
            star = (TextView)itemView.findViewById(R.id.search_star);
            like = (TextView)itemView.findViewById(R.id.search_like);
            stamp = (TextView)itemView.findViewById(R.id.search_stamp);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
