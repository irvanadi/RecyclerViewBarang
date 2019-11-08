package rvan.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {

    Context context;
    ArrayList<Barang> barangArrayList;

    public BarangAdapter(Context context, ArrayList<Barang> barangArrayList) {
        this.context = context;
        this.barangArrayList = barangArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Barang result = barangArrayList.get(position);
        holder.namaBarang.setText(result.getNama());
        holder.harga.setText("Rp. " + String.valueOf(result.getHarga()));
        holder.imgBarang.setImageResource(result.getImage());
    }

    @Override
    public int getItemCount() {
        return barangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView namaBarang, harga;
        private ImageView imgBarang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaBarang = itemView.findViewById(R.id.txtNamaBarang);
            harga = itemView.findViewById(R.id.txtHargaBarang);
            imgBarang = itemView.findViewById(R.id.imgBarang);
        }

    }
}
