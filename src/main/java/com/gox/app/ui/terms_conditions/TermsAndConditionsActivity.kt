package com.gox.app.ui.terms_conditions

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gox.app.R
import com.gox.basemodule.BaseApplication
import com.gox.basemodule.data.PreferenceKey

class TermsAndConditionsActivity : Activity() {

    private lateinit var mTermsConditions: WebView
    private val preference = BaseApplication.getCustomPreference

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_conditions)

        val termsUrl = preference!!.getString(PreferenceKey.TERMS_CONDITION, "")

        Log.d("TERMSANDCONDITION_T", "TERMSANDCONDITION" + termsUrl)

        mTermsConditions = findViewById(R.id.terms_conditions)
        mTermsConditions.loadUrl(termsUrl)
        mTermsConditions.webViewClient = MyWebViewClient()
        mTermsConditions.settings.domStorageEnabled = true
        mTermsConditions.settings.javaScriptEnabled = true
    }

    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return false
        }
    }

    override fun onBackPressed() {
        if (mTermsConditions.canGoBack())
            mTermsConditions.goBack()
        else
            super.onBackPressed()
    }
}
