package eas.com.androidnix.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import eas.com.androidnix.R
import eas.com.androidnix.persistence.dao.DataBase
import eas.com.androidnix.persistence.dao.RuleDao
import eas.com.androidnix.persistence.entity.Rule

import kotlinx.android.synthetic.main.activity_list_rule.*

class ListRuleActivity : AppCompatActivity() {

    private val dataBase: DataBase = DataBase(this, "dbDemo", 2)

    private var ruleDao: RuleDao? = null

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_rule)
        setSupportActionBar(toolbar)
        ruleDao = RuleDao(dataBase)

        fab.setOnClickListener { _ ->
            val intent = Intent(this, InsertRuleActivity::class.java)
            startActivity(intent)
        }

        //Binding
        listView = findViewById(R.id.listViewRule)


        //Load List
        val listRules = ruleDao?.list()
        val adapter = ArrayAdapter<Rule>(this, android.R.layout.simple_list_item_1, listRules)
        listView?.adapter = adapter


    }

}
