package com.example.weatherdemo.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.annotation.StringRes
import kotlin.reflect.KClass

fun @receiver:StringRes Int.errorDialog(activity: Activity) {
    AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert)
        .setTitle("Error")
        .setMessage(this@errorDialog)
        .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
        .setIcon(android.R.drawable.ic_dialog_alert).show()
}

fun <T : Activity> KClass<T>.start(activity: Activity, finish: Boolean = false) {
    Intent(activity, this.java).apply {
        activity.startActivity(this)
    }

    if (finish)
        activity.finish()

}
