package divyanshu.aclaglid.in.aclagliddemos.ListViewExample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 29/04/16.
 */
public class DynamicListView extends Activity{
    List<String> list;
    ListView li;
    Context context;
    ArrayList prgmName;
    GridView grid;
    TextView textView1;
    boolean condition=true;
    public static int[] prgmImages = {R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2,R.drawable.appicon1, R.drawable.appicon2};
    public static String[] prgmNameList = {"JAVA", "ANDROID", "iOS","RUBY ON RAILS","JAVA", "ANDROID", "iOS","RUBY ON RAILS","JAVA", "ANDROID", "iOS","RUBY ON RAILS","JAVA", "ANDROID", "iOS","RUBY ON RAILS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_layout);

        context = this;
        list = new ArrayList<String>();

        li = (ListView)findViewById(R.id.listView);
        li.setAdapter(new CustomAdapter(DynamicListView.this,prgmNameList,prgmImages));

        grid = (GridView)findViewById(R.id.gridView1);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(condition){
                    li.setVisibility(View.VISIBLE);
                    grid.setVisibility(View.GONE);
                    condition = false;
                }else{
                    grid.setVisibility(View.VISIBLE);
                    li.setVisibility(View.GONE);
                    condition =true;
                }
            }
        });


        list = new ArrayList<String>();
        grid = (GridView) findViewById(R.id.gridView1);

        list.add("Image 1");
        list.add("Image 2");
        list.add("Image 3");
        list.add("Image 4");
        list.add("Image 5");
        list.add("Image 6");
        list.add("Image 7");
        list.add("Image 8");
        list.add("Image 9");
        list.add("Image 10");


        ArrayAdapter<String> adp = new ArrayAdapter<String>(DynamicListView.this,android.R.layout.simple_dropdown_item_1line,list);
        grid.setAdapter(adp);



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DynamicListView.this,"You clicked   :"+list.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
