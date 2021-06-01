package com.iuh.a7_18068391_nguyenngocbaoduy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context context;
    private List<Employee> employees;

    public EmployeeAdapter(Context context, List<Employee> arrayList) {
        this.context = context;
        this.employees = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvId.setText(employees.get(position).getId()+"");
        holder.tvName.setText(employees.get(position).getName());
        holder.tvAge.setText(employees.get(position).getAge()+"");
        holder.tvDetail.setText(employees.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvId,tvAge,tvDetail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvDetail = itemView.findViewById(R.id.tvDetail);
        }
    }
}
