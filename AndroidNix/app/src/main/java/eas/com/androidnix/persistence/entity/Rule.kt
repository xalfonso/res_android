package eas.com.androidnix.persistence.entity

import android.provider.BaseColumns
import java.util.*

/**
 * Rule Entity.
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
class Rule {
    var id: Long = 0

    var name: String = ""

    var limitDate: String = ""

    var description: String = ""

    object schema : BaseColumns {
        const val TB_TABLE = "rule_tb"
        const val COL_NAME = "name"
        const val COL_LIMIT_DATA = "limitDate"
        const val COL_DESCRIPTION = "description"
        const val TB_SQL_CREATE = "CREATE TABLE $TB_TABLE (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COL_NAME TEXT," +
                "$COL_LIMIT_DATA TEXT," +
                "$COL_DESCRIPTION TEXT)"
        const val TB_SQL_DROP = "DROP TABLE IF EXISTS $TB_TABLE"
    }
}