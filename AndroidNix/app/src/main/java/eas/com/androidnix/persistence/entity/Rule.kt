package eas.com.androidnix.persistence.entity

import android.provider.BaseColumns

/**
 * Rule Entity.
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
class Rule(var id: Long, var name: String, var limitDate: String, var description: String, var factor: Float) {

    constructor(name: String, limitDate: String, description: String, factor: Float) : this(1L, name, limitDate, description, factor)

    override fun toString(): String {
        return "$id $name $factor $limitDate $description"
    }

    object schema : BaseColumns {
        const val TB_TABLE = "rule_tb"
        const val COL_NAME = "name"
        const val COL_LIMIT_DATA = "limitDate"
        const val COL_DESCRIPTION = "description"
        const val COL_FACTOR = "factor"
        const val TB_SQL_CREATE = "CREATE TABLE $TB_TABLE (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COL_NAME TEXT," +
                "$COL_LIMIT_DATA TEXT," +
                "$COL_FACTOR REAL," +
                "$COL_DESCRIPTION TEXT)"
        const val TB_SQL_DROP = "DROP TABLE IF EXISTS $TB_TABLE"
    }
}