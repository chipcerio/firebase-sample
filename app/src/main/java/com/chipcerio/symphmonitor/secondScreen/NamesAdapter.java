package com.chipcerio.symphmonitor.secondScreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chipcerio.symphmonitor.data.Employee;

import java.util.List;

class NamesAdapter extends RecyclerView.Adapter<NamesViewHolder> {

    private List<Employee> mNames;

    public NamesAdapter(List<Employee> employees) {
        mNames = employees;
    }

    @Override
    public NamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(
                android.R.layout.simple_list_item_1, parent, false);
        return new NamesViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NamesViewHolder holder, int position) {
        holder.setTitle(mNames.get(position).getFullname());
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }
}
