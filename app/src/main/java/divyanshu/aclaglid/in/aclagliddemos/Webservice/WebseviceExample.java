//package divyanshu.aclaglid.in.aclagliddemos.Webservice;
//
//import android.app.ListActivity;
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import divyanshu.aclaglid.in.aclagliddemos.R;
//
///**
// * Created by divyanshu on 06/06/16.
// */
//public class WebseviceExample extends ListActivity {
//
//    private ProgressDialog pDialog;
//    private static String url ="http://api.themoviedb.org/3/tv/top_rated?api_key=8496be0b2149805afa458ab8ec27560c";
//
//    private static final String TAG_RESULT="results";
//    private static final String TAG_ID="id";
//    private static final String TAG_NAME="name";
//    private static final String TAG_VOTEAVG="vote_average";
//
//
//    JSONArray tvShows = null;
//
//    ArrayList<HashMap<String,String>> tvShowList;
//    ListView lv;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_webservices);
//
//        tvShowList = new ArrayList<HashMap<String, String>>();
//        lv = getListView();
//
//
//    }
//
//
//    private class GetMovieDetails extends AsyncTask<Void,Void,Void>{
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pDialog = new ProgressDialog(WebseviceExample.this);
//            pDialog.setMessage("Please wait while loading........");
//            pDialog.setCancelable(false);
//            pDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//
//            ServiceHandler sh = new ServiceHandler();
//
//            String jsonStr = sh.makeServiceCall(url,ServiceHandler.GET);
//            System.out.println("Response::::"+jsonStr);
//
//            try{
//                if(jsonStr!=null){
//                    JSONObject jsonObject = new JSONObject(jsonStr);
//
//                    tvShows = jsonObject.getJSONArray(TAG_RESULT);
//
//                    for(int i=0 ; i< tvShows.length() ;i++){
//                        JSONObject c = tvShows.getJSONObject(i);
//                        String id = c.getString(TAG_ID);
//                        String name = c.getString(TAG_NAME);
//                        String voteravg = c.getString(TAG_VOTEAVG);
//
////                        JSONArray jArray = c.getJSONArray("origin_country");
////                        String s= jArray.getString(0);
//
//                        HashMap<String,String> tvShow =new HashMap<String, String>();
//                        tvShow.put(TAG_ID,id);
//                        tvShow.put(TAG_NAME,name);
//                        tvShow.put(TAG_VOTEAVG,voteravg);
//
//                        tvShowList.add(tvShow);
//
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            if(pDialog.isShowing()){
//                pDialog.dismiss();
//            }
//
//            ListAdapter adapter = new SimpleAdapter(
//                    WebseviceExample.this, tvShowList, R.layout.webservice_list_item,
//                    new String[]{TAG_ID,TAG_NAME,TAG_VOTEAVG}, new int[]{R.id.no, R.id.name, R.id.voteavg});
//            setListAdapter(adapter);
//        }
//    }
//}
