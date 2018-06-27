package skullper.world.selector.utils

import android.util.Log
import timber.log.Timber

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Timber tree which will be work in release build
 */
class TimberCrashReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }
        //todo log to bug tracker
    }

}