package com.example.deni.webviewdeni;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipeRefreshLayout;
    WebView webView;
    WebSettings webSettings;
    String url = "http://deniace.blogspot.co.id/";
    //String url = "https://www.tokopedia.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_fress);
        webView = (WebView)findViewById(R.id.web_view);

        swipeRefreshLayout.setOnRefreshListener(this);

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getUseWideViewPort();

        webView.setWebChromeClient(new WebChromeClient(){
            public void inProgressChanged(WebView view, int newProgress)
            {
                //menampilkan loading ketika web progres
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            //ketika webview error atau selesai load page loading akan dismis
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError eror)
            {
                swipeRefreshLayout.setRefreshing(false);
            }

            public void onPageFinished(WebView view, String url){
                swipeRefreshLayout.setRefreshing(true);
            }

        });
        webView.loadUrl(url);
    }


    public void onBackPressed()
    {
        //jika webview bisa di back maka backward page sebelumnya
        if(webView.canGoBack())
        {webView.goBack();}
        else
        {finish();
            System.exit(0);}
    }

    @Override
    public void onRefresh() {
        //untuk refresh dengan swipe
        webView.reload();
    }
}
