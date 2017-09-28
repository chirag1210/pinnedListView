package example.android.com.pinnedlistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmpChatRecyclerAdapter extends RecyclerView.Adapter<EmpChatRecyclerAdapter.ViewHolder> {
    private ArrayList<ChatItemData> android;
    private Context context;

    public EmpChatRecyclerAdapter(Context context, ArrayList<ChatItemData> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public EmpChatRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_chat_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmpChatRecyclerAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.lTime.setText(android.get(i).getDate());
        viewHolder.lTitle.setText(android.get(i).getTitle());
        viewHolder.lSubTitle.setText(android.get(i).getSubtitle());
        SimpleDateFormat dfDate = new SimpleDateFormat("dd-MMM-yyyy");

        /**
         * for Showing top date
         */
        if (i!=0) {
            if (android.get(i).getDate().equalsIgnoreCase(android.get(i - 1).getDate())) {
                viewHolder.lTime.setVisibility(View.GONE);

            } else {
                viewHolder.lTime.setVisibility(View.VISIBLE);
                viewHolder.lTime.setText(android.get(i).getDate());
            }


        }else{
            viewHolder.lTime.setVisibility(View.VISIBLE);
            viewHolder.lTime.setText(android.get(i).getDate());
        }


    }
    @Override
    public int getItemCount() {
        return android.size();
    }

    public ChatItemData  getItem(int position)
    {

        return this.android.get(position) ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lTime;
        private TextView lTitle;
        private TextView lSubTitle;


        public ViewHolder(View view) {
            super(view);

            lTime = (TextView) view.findViewById(R.id.chatitem_parentdate);
            lTitle = (TextView) view.findViewById(R.id.chat_Message_left);
            lSubTitle = (TextView) view.findViewById(R.id.chat_Message_time_left);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("clicked","clicked");
                }
            });
        }
    }

}