package rvan.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BarangAdapter barangAdapter;
    ArrayList<Barang> results = new ArrayList<>();
    String[] dataTitle;
    int[] dataHarga;
    TypedArray dataPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recBarang);

        barangAdapter = new BarangAdapter(MainActivity.this, results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(barangAdapter);

        preparing();
        load();
    }

    public void preparing(){
        dataTitle = getResources().getStringArray(R.array.menu_barang);
        dataPhoto = getResources().obtainTypedArray(R.array.img_barang);
        dataHarga = getResources().getIntArray(R.array.harga_barang);
    }

    public void load(){
        Log.d("TESTING_RESULT","LOAD");
        Log.d("TESTING_RESULT", String.valueOf(dataTitle.length));
        for (int i = 0; i < dataTitle.length; i++){
            Barang barang = new Barang();
            barang.setHarga(dataHarga[i]);
            barang.setNama(dataTitle[i]);
            barang.setImage(dataPhoto.getResourceId(i,-1));
            Log.d("TESTING_RESULT",String.valueOf(barang.getHarga()));
            results.add(barang);
        }

        Log.d("TESTING_RESULT",String.valueOf(results.size()));
        barangAdapter = new BarangAdapter(MainActivity.this, results);
        recyclerView.setAdapter(barangAdapter);
        barangAdapter.notifyDataSetChanged();
        Log.d("TESTING_RESULT","DONE1");
    }
}
