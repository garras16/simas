package id.ac.unila.fmipa.simas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ProductViewHolder> {
    private Context mContext;
    private List<Barang> productList;

    public AdapterBarang(Context mContext, List<Barang> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_list, null);
        return new ProductViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Barang product = productList.get(position);
        Glide.with(mContext)
                .load("http://192.168.43.81/simas/login/img/" + product.getGambar())
                .into(holder.imageView);

        holder.textNama.setText(product.getNama());
        holder.textDeskripsi.setText(product.getJumlah());
        holder.textJumlah.setText(product.getDeskripsi() + " pcs.");
        holder.textKode.setText(product.getKode());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textNama, textDeskripsi, textJumlah, textKode;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.textNama);
            textDeskripsi = itemView.findViewById(R.id.textDeskripsi);
            textJumlah = itemView.findViewById(R.id.textJumlah);
            textKode=itemView.findViewById(R.id.textKode);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
