package packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtBaseViewHolder;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtCell;
import packageadapter.eternallyliu.com.baseadapterpackage.R;

/**
 * Created by liupei on 2017/4/24.
 */

//cell封装的实现
public class LoadingCell extends EtCell{
    private View mLoadindView;

    public LoadingCell(Context context,Object mData) {
        super(context,mData);
    }

    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public EtBaseViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        if (mLoadindView == null) {
            return new EtBaseViewHolder(inflater.inflate(R.layout.cell_loading, parent, false));
        } else {
            return new EtBaseViewHolder(mLoadindView);
        }
    }

    @Override
    public void BindData(EtBaseViewHolder holder, int position) {

    }


    public void setLoadindView(View loadindView) {
        mLoadindView = loadindView;
    }

}
