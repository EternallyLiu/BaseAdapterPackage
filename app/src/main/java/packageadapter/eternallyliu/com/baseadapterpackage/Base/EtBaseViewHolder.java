package packageadapter.eternallyliu.com.baseadapterpackage.Base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by liupei on 2017/4/24.
 * 对ViewHolder进行了一个封装，防止频繁创建ViewHolder对象
 */

public class EtBaseViewHolder extends RecyclerView.ViewHolder{
    public SparseArray<View> Views;
    public View ItemView;

    public EtBaseViewHolder(View itemView) {
        super(itemView);
        this.ItemView = itemView;
        Views = new SparseArray<>();
    }

    public <V extends View> V retrieveView(int resId) {
        View view = Views.get(resId);
        if (view == null) {
            view = ItemView.findViewById(resId);
            Views.put(resId, view);
        }
        return (V) view;
    }


    public TextView getTextView(int resId) {
        return retrieveView(resId);
    }

    public Button getButton(int resId) {
        return retrieveView(resId);
    }

    public ImageView getImageView(int resId) {
        return retrieveView(resId);
    }

    public View getView(int resId) {
        return retrieveView(resId);
    }
}
