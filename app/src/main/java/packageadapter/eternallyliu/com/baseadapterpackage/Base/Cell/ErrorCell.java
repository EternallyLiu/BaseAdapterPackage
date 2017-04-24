package packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtBaseViewHolder;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtCell;
import packageadapter.eternallyliu.com.baseadapterpackage.R;

/**
 * Created by liupei on 2017/4/24.
 */

//cell封装的实现
public class ErrorCell extends EtCell{
    public ErrorCell(Context context,Object mData) {
        super(context,mData);
    }

    @Override
    public int getItemType() {
        return 2;
    }

    @Override
    public EtBaseViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        return new EtBaseViewHolder(inflater.inflate(R.layout.cell_error, parent, false));
    }

    @Override
    public void BindData(EtBaseViewHolder holder, int position) {

    }
}
