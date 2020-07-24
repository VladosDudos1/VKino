package vlados.dudos.vkino.data

import android.content.Context
import android.content.SharedPreferences

class DataManager {
    private val shared: SharedPreferences
    private val baseContext: Context

    val api = Api.createApi()

    constructor(baseContext: Context){
        this.baseContext = baseContext
        shared = baseContext.getSharedPreferences("WS", Context.MODE_PRIVATE)
    }

    fun isFirstLaunch(): Boolean = shared.getBoolean("isFirstLaunch", true)

    fun endFirstLaunch(): Boolean = shared.edit().putBoolean("isFirstLaunch", false).commit()
}