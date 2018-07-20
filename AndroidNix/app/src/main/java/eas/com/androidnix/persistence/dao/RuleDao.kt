package eas.com.androidnix.persistence.dao

import android.content.ContentValues
import eas.com.androidnix.persistence.entity.Rule

/**
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
class RuleDao(private val dataBase: DataBase) {

    fun insert(rule: Rule) {
        val db = dataBase.writableDatabase

        val values = ContentValues()
        values.put(Rule.schema.COL_NAME, rule.name)
        values.put(Rule.schema.COL_LIMIT_DATA, rule.limitDate)
        values.put(Rule.schema.COL_DESCRIPTION, rule.description)


        val idRule = db?.insert(Rule.schema.TB_TABLE, null, values)
        db.close()
        rule.id = idRule!!
    }
}