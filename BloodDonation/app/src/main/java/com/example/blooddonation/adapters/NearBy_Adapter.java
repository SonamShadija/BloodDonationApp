package com.example.blooddonation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blooddonation.R;
import com.example.blooddonation.models.NearBY;

import java.util.List;

public class NearBy_Adapter extends RecyclerView.Adapter<NearBy_Adapter.NearByViewHolder>{

    private Context context;
    private List<NearBY> nearBYList;
    private static final String TAG="aman";

    public NearBy_Adapter(Context context, List<NearBY> nearBYList) {
        this.context = context;
        this.nearBYList = nearBYList;
    }

    @NonNull
    @Override
    public NearByViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG,"inside create");
        View view = LayoutInflater.from(context).inflate(R.layout.request_layout_holder,viewGroup,false);
        return new NearByViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearByViewHolder viewHolder, int i) {
        NearBY n = nearBYList.get(i);
        viewHolder.name.setText(n.getName());
        viewHolder.address.setText(n.getAddress());
        viewHolder.type.setText(n.getBloodType());
        viewHolder.unit.setText(n.getCapacity().toString());
        viewHolder.phone.setText(n.getPhone());

    }

    @Override
    public int getItemCount() {
        return nearBYList.size();
    }

    class NearByViewHolder extends RecyclerView.ViewHolder{

        TextView type,unit,address,name,phone;

        public NearByViewHolder(@NonNull View view){
            super(view);

            name = view.findViewById(R.id.tv_name);
            type = view.findViewById(R.id.tv_type);
            unit = view.findViewById(R.id.tv_unit_rlh);
            address = view.findViewById(R.id.tv_address);
            phone = view.findViewById(R.id.tv_phone);
        }

    }
}
