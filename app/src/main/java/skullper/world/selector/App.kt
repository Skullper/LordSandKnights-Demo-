package skullper.world.selector

import android.app.Application
import android.content.Context
import skullper.world.selector.utils.TimberCrashReportingTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(TimberCrashReportingTree())
        }
    }

    companion object {

        @Volatile
        private var instance: App? = null

        val context: Context
            get() = instance!!.applicationContext
    }

}
