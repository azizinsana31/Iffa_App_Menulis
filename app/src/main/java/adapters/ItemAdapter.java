package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<ItemModel> {
    Context context;
    int layout;
    List<ItemModel> items;

    public ItemAdapter(Context context, int layout, List<ItemModel> listItems){
        super(context, layout, listItems);
        this.context = context;
        this.layout = layout;
        this.items = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ItemViewHolder ivHolder;

        if(v == null){
            LayoutInflater viewInflater = ((Activity)context).getLayoutInflater();
            v = viewInflater.inflate(layout, parent, false);
            ivHolder = new ItemViewHolder();
            ivHolder.imageView = (ImageView) v.findViewById(R.id.item_image);
            v.setTag(ivHolder);
        }
        else{
            ivHolder = (ItemViewHolder) v.getTag();
        }

        ItemModel item = items.get(position);
        ivHolder.imageView.setImageResource(item.getItemImage());

        return v;
    }

    static class ItemViewHolder{
        ImageView imageView;
    }
}


