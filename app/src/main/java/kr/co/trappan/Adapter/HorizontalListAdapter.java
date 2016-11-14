package kr.co.trappan.Adapter;

/**
 * Created by thfad_000 on 2016-11-09.
 */
import android.content.Context;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import android.support.v7.widget.RecyclerView;

import kr.co.trappan.Activity.SearchActivity;
import kr.co.trappan.Fragment.TabFragment2;
import kr.co.trappan.Item.Horizontal_item;
import kr.co.trappan.R;

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.ViewHolder> {

    private Context context;
    private List<Horizontal_item> items;
    private int item_layout;


  //  View layout_tab2 =  layoutInflater.inflate(R.layout.tabfragment2, null);

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

                if (item.getTitle()=="서울") {

                    TabFragment2.view_detail.setVisibility(View.VISIBLE);
                    TabFragment2.view_seoul.setVisibility(View.VISIBLE);
                    TabFragment2.view_gyeonggi.setVisibility(View.GONE);
                    TabFragment2.view_pusan.setVisibility(View.GONE);
                    TabFragment2.view_incheon.setVisibility(View.GONE);
                    TabFragment2.view_daegu.setVisibility(View.GONE);

                    TabFragment2.region_name.setText(item.getTitle());

                }
                else if (item.getTitle()=="경기"){

                    TabFragment2.view_detail.setVisibility(View.VISIBLE);
                    TabFragment2.view_gyeonggi.setVisibility(View.VISIBLE);
                    TabFragment2.view_seoul.setVisibility(View.GONE);
                    TabFragment2.view_pusan.setVisibility(View.GONE);
                    TabFragment2.view_incheon.setVisibility(View.GONE);
                    TabFragment2.view_daegu.setVisibility(View.GONE);

                    TabFragment2.region_name.setText(item.getTitle());

                }
                else if (item.getTitle()=="부산"){

                    TabFragment2.view_detail.setVisibility(View.VISIBLE);
                    TabFragment2.view_gyeonggi.setVisibility(View.GONE);
                    TabFragment2.view_seoul.setVisibility(View.GONE);
                    TabFragment2.view_incheon.setVisibility(View.GONE);
                    TabFragment2.view_daegu.setVisibility(View.GONE);
                    TabFragment2.view_pusan.setVisibility(View.VISIBLE);

                    TabFragment2.region_name.setText(item.getTitle());
                }
                else if (item.getTitle()=="대구"){

                    TabFragment2.view_detail.setVisibility(View.VISIBLE);
                    TabFragment2.view_daegu.setVisibility(View.VISIBLE);
                    TabFragment2.view_incheon.setVisibility(View.GONE);
                    TabFragment2.view_gyeonggi.setVisibility(View.GONE);
                    TabFragment2.view_seoul.setVisibility(View.GONE);
                    TabFragment2.view_pusan.setVisibility(View.GONE);

                    TabFragment2.region_name.setText(item.getTitle());

                }
                else if (item.getTitle()=="인천"){

                    TabFragment2.view_detail.setVisibility(View.VISIBLE);
                    TabFragment2.view_daegu.setVisibility(View.GONE);
                    TabFragment2.view_incheon.setVisibility(View.VISIBLE);
                    TabFragment2.view_gyeonggi.setVisibility(View.GONE);
                    TabFragment2.view_seoul.setVisibility(View.GONE);
                    TabFragment2.view_pusan.setVisibility(View.GONE);

                    TabFragment2.region_name.setText(item.getTitle());
                }
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

        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}