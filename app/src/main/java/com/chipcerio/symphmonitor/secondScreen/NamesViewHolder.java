package com.chipcerio.symphmonitor.secondScreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class NamesViewHolder extends RecyclerView.ViewHolder {

    private TextView mText;

    public NamesViewHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public void setTitle(String name) {
        mText.setText(name);
    }
}
