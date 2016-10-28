package com.example.rapid.stickyrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderAdapter;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;

/**
 * REcyclerAdapter
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements
        StickyHeaderAdapter<RecyclerAdapter.HeaderHolder> {

    final String TAG = "RecyclerAdapter";

    private List<Contact> mData;
    private Context mContext;

    public RecyclerAdapter(List<Contact> data, Context context) {
        mData = data;
        mContext = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item;

        public ViewHolder(View itemView) {
            super(itemView);

            item = (TextView) itemView.findViewById(R.id.tv_recycler_item);
        }
    }

    static class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView header;

        public HeaderHolder(View itemView) {
            super(itemView);

            header = (TextView) itemView.findViewById(R.id.tv_recycler_header);
        }
    }


    @Override
    public HeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.recycler_header_layout, parent, false);
        return new HeaderHolder(view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final View view = inflater.inflate(R.layout.recycler_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Contact contact = mData.get(i);

        String details = "\nName: " + contact.getName()
                + "\nEmail: " + contact.getEmail()
                + "\nPhone No: " + contact.getPhoneNo()
                + "\nInvite Status: " + contact.getInviteStatus();


        viewHolder.item.setText(details);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderHolder viewholder, int position) {
        viewholder.header.setText("Header " + getHeaderId(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public long getHeaderId(int position) {
        return (long) position / 2;
    }




/*    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {

        Contact contact = mData.get(itemIndex);

        String details = "Name: " + contact.getName()
                + "\nEmail: " + contact.getEmail()
                + "\nPhone No: " + contact.getPhoneNo()
                + "\nInvite Status: " + contact.getInviteStatus();


        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        ivh.personNameTextView.setText(details);
    }*/
}
