package eas.com.androidnix.persistence.dao

import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import eas.com.androidnix.persistence.entity.Rule

/**
 * Class for handle the DataBase.
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
class DataBase(context: Context, name: String, factory: CursorFactory, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Rule.schema.TB_SQL_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(Rule.schema.TB_SQL_DROP)
        onCreate(db)
    }
}
