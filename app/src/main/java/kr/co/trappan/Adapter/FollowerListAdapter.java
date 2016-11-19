package kr.co.trappan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.List;

import kr.co.trappan.Bean.Member;
import kr.co.trappan.R;

/**
 * Created by thfad_000 on 2016-11-18.
 */

public class FollowerListAdapter extends RecyclerView.Adapter<FollowerListAdapter.ViewHolder> {

    Context context;
    List<Member> items;
    int item_layout;
    AQuery aq;


    public FollowerListAdapter (Context context, List<Member> items, int item_layout) {

        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public FollowerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower,parent,false);
        FollowerListAdapter.ViewHolder holder = new FollowerListAdapter.ViewHolder(v);
        aq = new AQuery(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FollowerListAdapter.ViewHolder holder, int position) {

        final Member item =items.get(position);

        aq.id(holder.image).image(item.getPro_img());
        holder.userId.setText(item.getId());
        holder.desc.setText(item.getIntro());
        holder.f_button.setBackgroundResource(R.drawable.follow);

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView userId;
        TextView desc;
        Button f_button;

        public ViewHolder(View itemView) {

            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.followingImage);
            userId = (TextView) itemView.findViewById(R.id.follower_user);
            desc = (TextView) itemView.findViewById(R.id.follower_desc);
            f_button = (Button) itemView.findViewById(R.id.follower_button);

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}
