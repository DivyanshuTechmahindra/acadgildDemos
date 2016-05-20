package divyanshu.aclaglid.in.aclagliddemos.ListViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 29/04/16.
 */
public class CustomAdapter extends BaseAdapter{

    String[] result;
    Context context;
    int[]  imageID;
    public static LayoutInflater inflater = null;

    public CustomAdapter(DynamicListView mainActivity, String[]prgmNameList, int[] prgnImages){
        result = prgmNameList;
        context = mainActivity;
        imageID = prgnImages;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.tv = (TextView)rowView.findViewById(R.id.textView1);
        holder.img = (ImageView)rowView.findViewById(R.id.imageView1);


        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageID[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You Click "+result[position],Toast.LENGTH_SHORT).show();
            }
        });


        return rowView;
    }
}
