package kr.co.trappan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.ArrayList;
import java.util.List;

import kr.co.trappan.Bean.Tour;
import kr.co.trappan.Item.SearchFragmentItem;
import kr.co.trappan.R;

/**
 * Created by jongchanrim on 2016. 11. 20..
 */

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentAdapter.ViewHolder>{

    Context context;
    ArrayList<SearchFragmentItem> items;
    int item_layout;
    AQuery aq;
    //
    private static int TYPE_HEADER = 0;
    private static int TYPE_FOOTER = 3;




    public SearchFragmentAdapter (ArrayList<SearchFragmentItem> items) {
        this.items=items;
    }


    @Override
    public SearchFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        SearchFragmentAdapter.ViewHolder holder = new SearchFragmentAdapter.ViewHolder(v);
        aq = new AQuery(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(SearchFragmentAdapter.ViewHolder holder, int position) {

        final SearchFragmentItem item=items.get(position);

        aq.id(holder.image).image(item.getImage());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;





        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.search_fragment_img);

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }
}
