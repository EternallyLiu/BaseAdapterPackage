package packageadapter.eternallyliu.com.baseadapterpackage.Base.Cell;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import packageadapter.eternallyliu.com.baseadapterpackage.Base.Bean.ShowBean;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtBaseViewHolder;
import packageadapter.eternallyliu.com.baseadapterpackage.Base.EtCell;
import packageadapter.eternallyliu.com.baseadapterpackage.R;

/**
 * Created by liupei on 2017/4/24.
 */

//cell封装的实现
public class ShowCell<ShowBean> extends EtCell{
    public ShowCell(Context context,ShowBean mData) {
        super(context, mData);
    }

    @Override
    public int getItemType() {
        return 4;
    }

    @Override
    public EtBaseViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        return new EtBaseViewHolder(inflater.inflate(R.layout.cell_show, parent, false));
    }

    @Override
    public void BindData(EtBaseViewHolder holder, int position) {
        holder.getTextView(R.id.show_cell_text).setText("这个是第"+position+"个内容");
    }
}
