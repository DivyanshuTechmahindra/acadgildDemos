package divyanshu.aclaglid.in.aclagliddemos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyanshu on 29/04/16.
 */
public class GridViewExmple extends Activity{


    List<String> list;
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);


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


        ArrayAdapter<String> adp = new ArrayAdapter<String>(GridViewExmple.this,android.R.layout.simple_dropdown_item_1line,list);
        grid.setAdapter(adp);



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewExmple.this,"You clicked   :"+list.get(position),Toast.LENGTH_SHORT).show();

            }
        });



    }
}
