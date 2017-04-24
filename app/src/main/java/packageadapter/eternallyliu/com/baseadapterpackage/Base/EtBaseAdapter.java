package packageadapter.eternallyliu.com.baseadapterpackage.Base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liupei on 2017/4/24.
 */

//基类的Adapter
public class EtBaseAdapter<C extends EtCell> extends RecyclerView.Adapter<EtBaseViewHolder> {
    public List<C> mData;
    public Context mContext;

    public EtBaseAdapter(Context context, List<C> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public EtBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (int i = 0; i < getItemCount(); i++) {
            if (viewType == mData.get(i).getItemType()) {
                return mData.get(i).onCreateViewHolder(parent, viewType);
            }
        }

        throw new RuntimeException("Wrong viewType");
    }

    @Override
    public void onBindViewHolder(EtBaseViewHolder holder, int position) {
        onBeforeBindData();
        mData.get(position).BindData(holder, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    public void add(C cell) {
        add(mData.size(), cell);
    }

    public void add(int index, C cell) {
        mData.add(index, cell);
        notifyItemChanged(index);
    }

    public void addAll(List<C> cells) {
        if (cells == null || cells.size() <= 0) {
            return;
        }
        mData.addAll(cells);
        notifyItemRangeChanged(mData.size() - cells.size(), cells.size());
    }

    public void addAll(int index,List<C> cells) {
        if (cells == null || cells.size() <= 0) {
            return;
        }
        mData.addAll(index, cells);
        notifyItemRangeChanged(index,cells.size());
    }

    public void remove(C cell) {
        remove(mData.indexOf(cell));
    }

    public void remove(int index) {
        mData.remove(index);
        notifyItemRemoved(index);
    }

    public void remove(int start, int Count) {
        if (start + Count >= mData.size()) {
            return;
        }
        int size = getItemCount();
        for (int i = start;i<Count;i++) {
            mData.remove(i);
        }
        notifyItemRangeChanged(start,Count);
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void onBeforeBindData(){
        //子类如果需要在ViewHolder绑定数据之前做些操作的话可以重写该方法
    };
}
