package com.chipcerio.symphmonitor.secondscreensamp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chipcerio.symphmonitor.data.Employee;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jermaine on 05/11/2016.
 */
public class EmployeesAdapterSamp extends RecyclerView.Adapter<EmployeesAdapterSamp.EmployeeViewHolder> {

    private Context mContext;
    private DatabaseReference mReference;
    private ChildEventListener mChildEventListener;

    private List<String> mEmployeeIds = new ArrayList<>();
    private List<Employee> mEmployees = new ArrayList<>();

    public EmployeesAdapterSamp(Context context, DatabaseReference reference) {
        mContext = context;
        mReference = reference;

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // new employee has been added, add it to the displayed list
                Employee employee = dataSnapshot.getValue(Employee.class);

                mEmployeeIds.add(dataSnapshot.getKey());
                mEmployees.add(employee);
                notifyItemInserted(mEmployees.size() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // an employee has been edited/changed, use the key to determine if we are
                // displaying this employee already, if so update the item
                Employee updatedEmployee = dataSnapshot.getValue(Employee.class);
                String employeeKey = dataSnapshot.getKey();

                int employeeIndex = mEmployeeIds.indexOf(employeeKey);
                if (employeeIndex > -1) {
                    // replace with the new data
                    mEmployees.set(employeeIndex, updatedEmployee);

                    // update the recyclerview
                    notifyItemChanged(employeeIndex);
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // An employee has been removed, use the key to determine if we are displaying
                // this employee, if so we remove it from the list.
                String employeeKey = dataSnapshot.getKey();

                int employeeIndex = mEmployeeIds.indexOf(employeeKey);
                if (employeeIndex > -1) {
                    // remove employee from the list
                    mEmployeeIds.remove(employeeIndex);
                    mEmployees.remove(employeeIndex);

                    // update the recyclerview
                    notifyItemRemoved(employeeIndex);
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(mContext, "Failed to load employees.", Toast.LENGTH_SHORT).show();
            }
        };
        mReference.addChildEventListener(mChildEventListener);
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        holder.textView.setText(mEmployees.get(position).getFullname());
    }

    @Override
    public int getItemCount() {
        return mEmployees.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public EmployeeViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    public void removeListener() {
        if (mChildEventListener != null) {
            mReference.removeEventListener(mChildEventListener);
        }
    }
}
