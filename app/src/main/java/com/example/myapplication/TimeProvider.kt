package com.example.myapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri


class TimeProvider : ContentProvider() {

    private lateinit var dbHelper: TimeProviderDbHelper

    override fun onCreate(): Boolean {
        dbHelper = context?.let { TimeProviderDbHelper(it) }!!
        return true
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder)
        cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = dbHelper.writableDatabase
        val id = db.insert(TABLE_NAME, null, values)
        context?.contentResolver?.notifyChange(uri, null)
        return Uri.withAppendedPath(CONTENT_URI, id.toString())
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = dbHelper.writableDatabase
        val count = db.update(TABLE_NAME, values, selection, selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return count

    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.$AUTHORITY.$TABLE_NAME"
    }

    companion object {
        const val AUTHORITY = "com.example.myapplication.timeprovider"
        const val TABLE_NAME = "time"
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$TABLE_NAME")
    }
}




