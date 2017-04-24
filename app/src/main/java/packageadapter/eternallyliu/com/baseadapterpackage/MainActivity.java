package packageadapter.eternallyliu.com.baseadapterpackage;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell.ShowCell;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtBaseAdapter;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtSimpleAdapter;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.LayoutManager.MyLayoutManager;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ShowCell> cells;
    private EtSimpleAdapter etBaseAdapter;
    private RecyclerView recyclerView;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(this);

        initCell();

        initRecyclerView();
    }

    private void initCell() {
        ShowCell showCell;
        cells = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            showCell = new ShowCell(this, null);
            cells.add(showCell);
        }
    }

    private void initRecyclerView() {
        etBaseAdapter = new EtSimpleAdapter(this, cells);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setAdapter(etBaseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        etBaseAdapter.showLoading(inflater.inflate(R.layout.cell_loading2,null, false));
    }
}
