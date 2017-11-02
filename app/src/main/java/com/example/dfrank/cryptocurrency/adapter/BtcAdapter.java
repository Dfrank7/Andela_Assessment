package com.example.dfrank.cryptocurrency.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dfrank.cryptocurrency.R;
import com.example.dfrank.cryptocurrency.controller.ConversionActivity;
import com.example.dfrank.cryptocurrency.model.BTC;

import java.util.List;

/**
 * Created by dfrank on 11/1/17.
 */

public class BtcAdapter extends RecyclerView.Adapter<BtcAdapter.viewHolder> {

    private Context context;
    private List<BTC> names;
    public BtcAdapter(Context context, List<BTC> names){
        this.context = context;
        this.names = names;
    }
    @Override
    public BtcAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowcard, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(BtcAdapter.viewHolder holder, int position) {
        holder.country.setText("Country: "+names.get(position).getCname());
        holder.currency.setText("Shortcode: "+names.get(position).getScode());
        holder.btc.setText("1 value : "+String.valueOf(names.get(position).getCurrency()));


    }

    @Override
    public int getItemCount() {
        return names.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView currency, country, btc;

        public viewHolder(final View view) {
            super(view);
            currency = view.findViewById(R.id.currency);
            country = view.findViewById(R.id.country);
            btc = view.findViewById(R.id.btc);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION){
                        Intent go = new Intent(v.getContext(), ConversionActivity.class);
                        go.putExtra("btc", names.get(position).getCurrency())
                                .putExtra("Currency",names.get(position).getCname())
                                .putExtra("Scode",names.get(position).getScode());
                        v.getContext().startActivity(go);
                    }
                }
            });
        }
    }
}
