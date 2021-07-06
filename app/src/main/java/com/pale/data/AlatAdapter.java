package com.pale.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.pale.R;

import java.util.ArrayList;

public class AlatAdapter extends RecyclerView.Adapter<AlatAdapter.AlatViewHolder> {

    private ArrayList<Alat> dataList;

    public AlatAdapter(ArrayList<Alat> dataList){
        this.dataList = dataList;
    }


    @Override
    public AlatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_alat, parent, false);
        return new AlatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlatViewHolder holder, int position){
        holder.txtIdAlat.setText(dataList.get(position).getId());
        holder.txtIdKolam.setText(dataList.get(position).getIdKolam());
        holder.txtNamaKolam.setText(dataList.get(position).getNamaKolam());
        holder.txtNamaPemilik.setText(dataList.get(position).getPemilik());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class AlatViewHolder extends RecyclerView.ViewHolder{

        private TextView txtIdAlat,txtIdKolam, txtNamaKolam,txtNamaPemilik;

        public AlatViewHolder(View itemView){
            super(itemView);
            txtIdAlat = (TextView) itemView.findViewById(R.id.txt_id_alat);
            txtIdKolam = (TextView) itemView.findViewById(R.id.txt_id_kolam);
            txtNamaKolam = (TextView) itemView.findViewById(R.id.txt_nama_alat);
            txtNamaPemilik = (TextView) itemView.findViewById(R.id.txt_nama_pemilik);

        }
    }
}
