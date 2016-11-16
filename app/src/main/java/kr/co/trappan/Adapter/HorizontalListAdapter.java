package kr.co.trappan.Adapter;

/**
 * Created by thfad_000 on 2016-11-09.
 */
import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Horizontal_item item=items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.image.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
        holder.title.setText(item.getTitle());
        holder.code.setText(item.getCode());
        holder.title.setVisibility(View.GONE);
        holder.code.setVisibility(View.GONE);



//        holder.image.setOnClickListener(new View.OnClickListener() {
//
//            boolean selected = true;
//
//
//
//            @Override
//            public void onClick(View v) {
//
//                holder.title.setBackgroundColor(Color.argb(80, 189, 189, 189));
//
//
//
//                if (item.getTitle()== "서울" && selected == true) {
//
//                        TabFragment2.view_detail.setVisibility(View.VISIBLE);
//                        TabFragment2.view_seoul.setVisibility(View.VISIBLE);
//
//                        TabFragment2.region_name.setText(item.getTitle());
//                        TabFragment2.region_code.setText(item.getCode());
//
//                        holder.image.setImageResource(R.drawable.seoul_1_c);
//
//                        selected = false;
//
//                    }
//                else if (item.getTitle()=="경기"){
//
//                        TabFragment2.view_detail.setVisibility(View.VISIBLE);
//                        TabFragment2.view_gyeonggi.setVisibility(View.VISIBLE);
//
//                        TabFragment2.region_name.setText(item.getTitle());
//                        TabFragment2.region_code.setText(item.getCode());
//
//                        holder.image.setImageResource(R.drawable.gyeonggi_31_c);
//                }
//
//                else if (item.getTitle()=="부산"){
//
//                        TabFragment2.view_detail.setVisibility(View.VISIBLE);
//                        TabFragment2.view_pusan.setVisibility(View.VISIBLE);
//
//                        TabFragment2.region_name.setText(item.getTitle());
//                        TabFragment2.region_code.setText(item.getCode());
//
//                        holder.image.setImageResource(R.drawable.pusan_6_c);
//                    }
//
//                else if (item.getTitle()=="대구"){
//
//                        TabFragment2.view_detail.setVisibility(View.VISIBLE);
//                        TabFragment2.view_daegu.setVisibility(View.VISIBLE);
//                        TabFragment2.view_incheon.setVisibility(View.GONE);
//                        TabFragment2.view_gyeonggi.setVisibility(View.GONE);
//                        TabFragment2.view_seoul.setVisibility(View.GONE);
//                        TabFragment2.view_pusan.setVisibility(View.GONE);
//
//                        TabFragment2.region_name.setText(item.getTitle());
//                        TabFragment2.region_code.setText(item.getCode());
//                        holder.image.setImageResource(R.drawable.daegu_4_c);
//                }
//
//                else if (item.getTitle()=="인천" && selected == true){
//
//                        TabFragment2.view_detail.setVisibility(View.VISIBLE);
//                        TabFragment2.view_incheon.setVisibility(View.VISIBLE);
//                        TabFragment2.view_seoul.setVisibility(View.GONE);
//                        TabFragment2.view_gyeonggi.setVisibility(View.GONE);
//                        TabFragment2.view_pusan.setVisibility(View.GONE);
//                        TabFragment2.view_daegu.setVisibility(View.GONE);
//
//                        TabFragment2.region_name.setText(item.getTitle());
//                        TabFragment2.region_code.setText(item.getCode());
//
//                        holder.image.setImageResource(R.drawable.incheon_2_c);
//                        selected = false;
//                }
//                else {
//                    holder.image.setImageResource(item.getImage());
//                    TabFragment2.view_detail.setVisibility(View.GONE);
//                    TabFragment2.view_seoul.setVisibility(View.GONE);
//                    TabFragment2.view_gyeonggi.setVisibility(View.GONE);
//                    TabFragment2.view_pusan.setVisibility(View.GONE);
//                    TabFragment2.view_incheon.setVisibility(View.GONE);
//                    TabFragment2.view_daegu.setVisibility(View.GONE);
//
//                    selected = true;
//                }
//            }
//
//
//        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView code;

        public ViewHolder(final View itemView) {

            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.list_iamge);
            title=(TextView)itemView.findViewById(R.id.list_text);
            code = (TextView)itemView.findViewById(R.id.region_code);
        }
    }
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}