package com.example.dfrank.cryptocurrency.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dfrank.cryptocurrency.R;
import com.example.dfrank.cryptocurrency.adapter.BtcAdapter;
import com.example.dfrank.cryptocurrency.api.Client;
import com.example.dfrank.cryptocurrency.api.Service;
import com.example.dfrank.cryptocurrency.model.BTC;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dfrank on 11/1/17.
 */

public class BtcFragment extends android.support.v4.app.Fragment {
    ProgressDialog progressDialog;
    SwipeRefreshLayout refreshLayout;
    List<BTC> names = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.btc, container, false);
        recyclerView = view.findViewById(R.id.recycler_btc);
        refreshLayout = view.findViewById(R.id.swipe);
        initView();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.smoothScrollToPosition(0);
                Extras();
            }
        });
        return view;

    }
    private void initView(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Fetching Data");
        progressDialog.setCancelable(false);
        progressDialog.show();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));;
        recyclerView.smoothScrollToPosition(0);
        Extras();
    }
    private void Extras(){
        Client client = new Client();
        Service serviceEndpoint = client.getClient().create(Service.class);
        Call<BTC> call = serviceEndpoint.getCurrency();
        call.enqueue(new Callback<BTC>() {
            @Override
            public void onResponse(Call<BTC> call, Response<BTC> response) {
                Log.e("response","Successful");
                names.add(new BTC("Nigeria", "NGN", response.body().getNGN()));
                names.add(new BTC("United Kingdom", "GBP", response.body().getGBP()));
                names.add(new BTC("Ghana", "GHS", response.body().getGHS()));
                names.add(new BTC("United State","USD",response.body().getUSD()));
                names.add(new BTC("Germany","EUR",response.body().getEUR()));
                names.add(new BTC("South Korea","KRW",response.body().getKRW()));
                names.add(new BTC("Canada","CAD",response.body().getCAD()));
                names.add(new BTC("Brazil","BRL",response.body().getBRL()));
                names.add(new BTC("Egypt","EGP",response.body().getEGP()));
                names.add(new BTC("Argentina","ARS",response.body().getARS()));
                names.add(new BTC("Afghanistan","AFN",response.body().getAFN()));
                names.add(new BTC("Albania","ALL",response.body().getALL()));
                names.add(new BTC("Japan","JPY",response.body().getJPY()));
                names.add(new BTC("China","CNY",response.body().getCNY()));
                names.add(new BTC("Saudi Arabia", "SAR",response.body().getSAR()));
                names.add(new BTC("Colombia","COP",response.body().getCOP()));
                names.add(new BTC("Denmark", "DKK",response.body().getDKK()));
                names.add(new BTC("Hong Kong","HKD",response.body().getHKD()));
                names.add(new BTC("South Africa","ZAR",response.body().getZAR()));
                names.add(new BTC("Congo", "XAF",response.body().getXAF()));
                BtcAdapter adapter = new BtcAdapter(context, names);
                recyclerView.setAdapter(adapter);
                if (refreshLayout.isRefreshing()){
                    refreshLayout.setRefreshing(false);

                }
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<BTC> call, Throwable t) {
                progressDialog.dismiss();
                refreshLayout.setRefreshing(false);

                 Log.e("response","Unsuccessful");
                Toast.makeText(getContext(),"No/poor Internet Access, Please Refresh" , Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar.make(getView().findViewById(R.id.LinearLayout), "Poor/No Internet", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Refresh", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                initView();
                            }
                        }); snackbar.show();

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
