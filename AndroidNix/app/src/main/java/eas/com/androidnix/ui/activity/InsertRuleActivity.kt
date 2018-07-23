package eas.com.androidnix.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import eas.com.androidnix.R
import eas.com.androidnix.persistence.dao.DataBase
import eas.com.androidnix.persistence.dao.RuleDao
import eas.com.androidnix.persistence.entity.Rule
import kotlinx.android.synthetic.main.activity_insert_rule.*

class InsertRuleActivity : AppCompatActivity() {

    private var nameInput: EditText? = null

    private var dateInput: EditText? = null

    private var factorInput: EditText? = null

    private var descriptionInput: EditText? = null

    private var buttonAccept: Button? = null

    private val dataBase: DataBase = DataBase(this, "dbDemo", 2)

    private var ruleDao: RuleDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_rule)
        setSupportActionBar(toolbar)
        ruleDao = RuleDao(dataBase)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //Binding elements
        nameInput = findViewById(R.id.nameInput)
        dateInput = findViewById(R.id.dateInput)
        factorInput = findViewById(R.id.factorInput)
        descriptionInput = findViewById(R.id.inputDescription)
        buttonAccept = findViewById(R.id.buttonAccept)

        //Insert Action
        buttonAccept?.setOnClickListener { _ ->
            val rule = Rule(nameInput?.text.toString(), dateInput?.text.toString(), descriptionInput?.text.toString(), factorInput?.text.toString().toFloat())
            ruleDao?.insert(rule)
            println("The rule was inserted. The id is: ${rule.id}")
        }
    }


}
