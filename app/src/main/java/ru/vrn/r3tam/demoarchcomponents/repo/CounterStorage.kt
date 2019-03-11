package ru.vrn.r3tam.demoarchcomponents.repo

import android.content.Context
import javax.inject.Inject

class CounterStorage @Inject constructor(context: Context) {

    val sh = context.getSharedPreferences("COUNTER", Context.MODE_PRIVATE)

    var counter
        get() = sh.getInt("C", 0)
        set(value) {
            sh.edit().putInt("C", value).apply()
        }

}