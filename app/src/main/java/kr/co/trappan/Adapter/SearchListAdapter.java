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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Item.SearchLists_item;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    List<Tour> items;
    int item_layout;
    AQuery aq;
   //
    private static int TYPE_HEADER = 0;
    private static int TYPE_FOOTER = 3;

    public void sortstar(){
        Collections.sort(items, new Comparator<Tour>(){
            public int compare(Tour obj1, Tour obj2)
            {
                // TODO Auto-generated method stub
                return (obj1.getLike() > obj2.getLike()) ? -1: (obj1.getLike() > obj2.getLike()) ? 1:0 ;
            }
        });
    }
    public void sortstamp(){
        Collections.sort(items, new Comparator<Tour>(){
            public int compare(Tour obj1, Tour obj2)
            {
                // TODO Auto-generated method stub
                return (obj1.getStamp() > obj2.getStamp()) ? -1: (obj1.getStamp() > obj2.getStamp()) ? 1:0 ;
            }
        });
    }
    public void sortrate(){
        Collections.sort(items, new Comparator<Tour>(){
            public int compare(Tour obj1, Tour obj2)
            {
                // TODO Auto-generated method stub
                return (obj1.getRate() > obj2.getRate()) ? -1: (obj1.getRate() > obj2.getRate()) ? 1:0 ;
            }
        });
    }


    public SearchListAdapter (Context context, List<Tour> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    public void setItems(List<Tour> items) {
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

        final Tour item=items.get(position);

        aq.id(holder.image).image(item.getFirstimage());
        holder.image.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        holder.title.setText(item.getTitle());
        holder.rate.setText(Double.toString(item.getRate()));
        holder.like.setText(Integer.toString(item.getLike()));
        holder.stamp.setText(Integer.toString(item.getStamp()));



    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView rate;
        TextView like;
        TextView stamp;




        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.search_imageVIew);
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
