package eas.com.androidnix.persistence.dao

import android.content.ContentValues
import android.provider.BaseColumns
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
        values.put(Rule.schema.COL_FACTOR, rule.factor)


        val idRule = db?.insert(Rule.schema.TB_TABLE, null, values)
        db.close()
        rule.id = idRule!!
    }

    fun list(): List<Rule> {
        val db = dataBase.readableDatabase

        val cursor = db.query(Rule.schema.TB_TABLE, null, null, null, null, null, null)

        val rules = mutableListOf<Rule>()

        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val name = getString(getColumnIndexOrThrow(Rule.schema.COL_NAME))
                val limitData = getString(getColumnIndexOrThrow(Rule.schema.COL_LIMIT_DATA))
                val description = getString(getColumnIndexOrThrow(Rule.schema.COL_DESCRIPTION))
                val factor = getFloat(getColumnIndexOrThrow(Rule.schema.COL_FACTOR))

                val rule = Rule(id, name, limitData, description, factor)
                rules.add(rule)
            }
        }

        return rules
    }
}