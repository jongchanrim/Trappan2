package kr.co.trappan.Adapter;

/**
 * Created by thfad_000 on 2016-11-09.
 */
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import android.support.v7.widget.RecyclerView;

import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Item.Horizontal_item;
import kr.co.trappan.R;

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.ViewHolder> {

    Context context;
    List<Horizontal_item> items;
    int item_layout;

    public HorizontalListAdapter(Context context, List<Horizontal_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Horizontal_item item=items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());


        holder.image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                intent.putExtra("title", item.getTitle());
                v.getContext().startActivity(intent);
            }
         });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(final View itemView) {

            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.list_iamge);
            title=(TextView)itemView.findViewById(R.id.list_text);
/*
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), SearchActivity.class);
                    intent.putExtra("title",items.get(position).getTitle());
                    Toast.makeText(context,items.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(intent);
                }
            });*/

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}