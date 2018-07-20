package eas.com.androidnix.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eas.com.androidnix.R

import kotlinx.android.synthetic.main.activity_list_rule.*

class ListRuleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_rule)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, InsertRuleActivity::class.java)
            startActivity(intent)
        }
    }

}
