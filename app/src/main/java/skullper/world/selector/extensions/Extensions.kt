package skullper.world.selector.extensions

import android.content.Context
import android.content.res.Resources
import android.support.annotation.*
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.jetbrains.anko.bundleOf
import skullper.world.selector.App
import java.util.*

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

//GLOBAL
val appContext: Context = App.context

val appRes: Resources = App.context.resources

//VIEWS
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false)
        : View = LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun Context.inflate(@LayoutRes layoutRes: Int,
                    root: ViewGroup? = null,
                    attachToRoot: Boolean = false)
        : View = LayoutInflater.from(this)
        .inflate(layoutRes, root, attachToRoot)

//SPANNABLE, TEXT
val EditText.string: String
    get() = this.text.toString()

//OTHER
inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}

inline fun <reified T : Fragment> newInstance(vararg params: Pair<String, Any>): T = T::class.java.newInstance().apply {
    arguments = bundleOf(*params) //This won't work without Anko library: https://github.com/Kotlin/anko
}

//RESOURCES
fun getString(@StringRes source: Int, vararg params: Any?)
        : String = String.format(Locale.getDefault(), appRes.getString(source), *params)

fun getString(@StringRes source: Int): String = appRes.getString(source)

fun getColor(@ColorRes source: Int): Int = ContextCompat.getColor(appContext, source)

fun getDimens(@DimenRes source: Int) = appRes.getDimensionPixelOffset(source)

fun getFont(@FontRes source: Int) = ResourcesCompat.getFont(appContext, source)