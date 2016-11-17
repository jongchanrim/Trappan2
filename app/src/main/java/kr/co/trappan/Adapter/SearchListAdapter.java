package kr.co.trappan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.List;

import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    List<SearchLists_item> items;
    int item_layout;
    AQuery aq;
   //
   private static int TYPE_HEADER = 0;
    private static int TYPE_FOOTER = 3;




    public SearchListAdapter (Context context, List<SearchLists_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    public void setItems(List<SearchLists_item> items) {
        this.items = items;
    }

    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        SearchListAdapter.ViewHolder holder = new SearchListAdapter.ViewHolder(v);
        aq = new AQuery(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchListAdapter.ViewHolder holder, int position) {

        final SearchLists_item item=items.get(position);

        aq.id(holder.image).image(item.getFirstimage());
        holder.image.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        holder.title.setText(item.getTitle());
//        holder.rate.setText(item.getRate());
//        holder.like.setText(item.getLike());
//        holder.stamp.setText(item.getStamp());
       holder.sigunguName.setText(item.getSigunguName());

       //holder.title.setText("0");
        holder.rate.setText("0");
        holder.like.setText("0");
        holder.stamp.setText("0");
       // holder.sigunguName.setText("0");

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout Header;
        ImageView image;
        TextView title;
        TextView sigunguName;
        TextView rate;
        TextView like;
        TextView stamp;




        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.search_imageVIew);
            sigunguName=(TextView)itemView.findViewById(R.id.search_sigungu);
            title = (TextView)itemView.findViewById(R.id.search_title);
            rate = (TextView)itemView.findViewById(R.id.search_star);
            like = (TextView)itemView.findViewById(R.id.search_like);
            stamp = (TextView)itemView.findViewById(R.id.search_stamp);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
