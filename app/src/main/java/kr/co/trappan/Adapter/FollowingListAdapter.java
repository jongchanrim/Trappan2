package kr.co.trappan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.List;

import kr.co.trappan.Bean.Member;
import kr.co.trappan.Item.List_item;
import kr.co.trappan.R;

import static android.support.v7.appcompat.R.id.image;

/**
 * Created by thfad_000 on 2016-11-17.
 */

public class FollowingListAdapter extends RecyclerView.Adapter<FollowingListAdapter.ViewHolder> {

    Context context;
    List<Member> items;
    int item_layout;
    AQuery aq;


    public FollowingListAdapter (Context context, List<Member> items, int item_layout) {

        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public FollowingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_following,parent,false);
        FollowingListAdapter.ViewHolder holder = new FollowingListAdapter.ViewHolder(v);
        aq = new AQuery(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FollowingListAdapter.ViewHolder holder, int position) {

        final Member item =items.get(position);

        if(item.getPro_img() ==null) {
            aq.id(holder.image).image(R.drawable.profile_default_image);
        }else{
            aq.id(holder.image).image(item.getPro_img());
        }
        holder.userId.setText(item.getId());
        holder.desc.setText(item.getIntro());

    }

    public void setItems(List<Member> items) {
        this.items = items;
    }
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView userId;
        TextView desc;

        public ViewHolder(View itemView) {

            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.following_image);
            userId = (TextView) itemView.findViewById(R.id.follwing_user);
            desc = (TextView) itemView.findViewById(R.id.following_desc);

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}

