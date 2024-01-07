package jp.co.u0235.floating_ai_agent_plugin.template

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

class TemplateContentProvider : ContentProvider() {

    private val tool = arrayOf("get weather", "get_current_weather", "Get the current weather in a given location", "{\n" +
                    "          \"type\": \"object\",\n" +
                    "          \"properties\": {\n" +
                    "            \"location\": {\n" +
                    "              \"type\": \"string\",\n" +
                    "              \"description\": \"The city and state, e.g. Tokyo\"\n" +
                    "            }\n" +
                    "          },\n" +
                    "          \"required\": [\"location\"]\n" +
                    "        }")

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor {
        val pathSegments = uri.pathSegments
        if (pathSegments.isEmpty()) return MatrixCursor(arrayOf("Error"))
        val functionName = pathSegments.last()
        return if (functionName == "functions") {
            val cursor = MatrixCursor(arrayOf("displayName", "functionName", "description", "parametersSchema"))
            cursor.addRow(tool)
            cursor
        } else {
            val cursor = MatrixCursor(arrayOf("result"))
            if (tool[1] != functionName) return cursor
            val location = uri.getQueryParameter("location")
            if (location.equals("tokyo", ignoreCase = true)) {
                cursor.addRow(arrayOf("{\"Weather\": \"snow\", \"3 Celsius\"}"))
            } else if (location.equals("london", ignoreCase = true)) {
                cursor.addRow(arrayOf("{\"Weather\": \"rain\", \"15 Celsius\"}"))
            } else {
                cursor.addRow(arrayOf("not support location"))
            }
            cursor
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        throw UnsupportedOperationException("Not yet implemented")
    }
}