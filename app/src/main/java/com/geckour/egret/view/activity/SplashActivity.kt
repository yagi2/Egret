package com.geckour.egret.view.activity

import android.content.Context
import android.os.Bundle
import com.geckour.egret.R
import com.geckour.egret.util.OrmaProvider
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class SplashActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val intent = if (hasCertified()) MainActivity.getIntent(this) else LoginActivity.getIntent(this)
        startActivity(intent)
    }

    fun hasCertified(): Boolean {
        return !OrmaProvider.db.selectFromAccessToken().isEmpty
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
