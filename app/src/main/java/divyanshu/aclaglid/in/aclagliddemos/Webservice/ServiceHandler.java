package divyanshu.aclaglid.in.aclagliddemos.Webservice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by divyanshu on 06/06/16.
 */

public class ServiceHandler {

    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;


    public String makeServiceCall(String url, int method){
        return this.makeServiceCall(url,method,null);
    }

    public String makeServiceCall(String url, int method,List<NameValuePair> parms){
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            if(method == POST){
                HttpPost httpPost = new HttpPost(url);
                if(parms!=null){
                    httpPost.setEntity(new UrlEncodedFormEntity(parms));
                }
                httpResponse = httpClient.execute(httpPost);
            }else if(method == GET){

                if(parms!=null){
                    String parmString = URLEncodedUtils.format(parms,"utf-8");
                    url +="?" + parmString;
                }

                HttpGet httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
            }

            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        }catch (Exception e){
            e.printStackTrace();
        }

        return  response;
    }

}
