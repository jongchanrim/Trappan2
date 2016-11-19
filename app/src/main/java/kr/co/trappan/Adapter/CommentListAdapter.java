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

import kr.co.trappan.Bean.Comment;
import kr.co.trappan.R;

import static android.support.v7.appcompat.R.id.image;

/**
 * Created by thfad_000 on 2016-11-17.
 */

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder> {

    Context context;
    List<Comment> items;
    int item_layout;
    AQuery aq;


    public CommentListAdapter (Context context, List<Comment> items, int item_layout) {

        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public CommentListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        CommentListAdapter.ViewHolder holder = new CommentListAdapter.ViewHolder(v);
        aq = new AQuery(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentListAdapter.ViewHolder holder, int position) {

        final Comment item =items.get(position);

//       aq.id(holder.image).image(item.getPro_img());
//         holder.userId.setText(item.getId());
//        holder.desc.setText(item.getIntro());

        holder.userId.setText(item.getId());
        holder.date.setText(item.getC_date());
        holder.desc.setText(item.getComment_content());

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView date;
        TextView desc;

        public ViewHolder(View itemView) {

            super(itemView);

            userId = (TextView) itemView.findViewById(R.id.comment_user);
            date = (TextView) itemView.findViewById(R.id.comment_date);
            desc = (TextView) itemView.findViewById(R.id.comment_desc);

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}

