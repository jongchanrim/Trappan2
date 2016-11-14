package kr.co.trappan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Bean.ListBean;
import kr.co.trappan.R;
import kr.co.trappan.Util.HttpClient;

/**
 * Created by thfad_000 on 2016-11-11.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    List<ListBean> items;
    int item_layout;
    AQuery aq;
   //


    public SearchListAdapter (Context context, List<ListBean> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        SearchListAdapter.ViewHolder holder = new SearchListAdapter.ViewHolder(v);
        aq = new AQuery(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchListAdapter.ViewHolder holder, int position) {

        final ListBean item=items.get(position);

        aq.id(holder.image).image(item.getFirstimage());
        holder.title.setText(item.getTitle());
        holder.rate.setText(item.getRate());
        holder.like.setText(item.getLike());
        holder.stamp.setText(item.getStamp());
        holder.sigunguName.setText(item.getSigunguName());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
