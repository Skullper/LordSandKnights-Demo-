package skullper.world.selector.skeleton.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import org.jetbrains.anko.startActivity
import skullper.world.selector.R
import skullper.world.selector.extensions.consume
import skullper.world.selector.extensions.gone
import skullper.world.selector.extensions.inflate
import skullper.world.selector.extensions.visible
import skullper.world.selector.skeleton.presentation.BasePresenter
import skullper.world.selector.skeleton.presentation.BaseView
import skullper.world.selector.utils.KeyboardController

/*
  Created by pugman on 27.06.18.
  Contact the developer - sckalper@gmail.com
  company - A2Lab
 */

/**
 * Class designed as parent for all Activities created in project.
 *
 * @param <P> presenter for created activity. The instance should be passed in [createPresenter()] method
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity(), BaseView, KeyboardController {

    protected lateinit var presenter: P

    /**
     * Place your layout resource as return parameter
     *
     * @return resourceId of layout which designed for current fragment
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * You should create an instance of your presenter here. After that you can use [presenter] everywhere in created activity
     *
     * @return an instance of presenter for created activity
     */
    protected abstract fun createPresenter(): P

    /**
     * Initialize all views here.
     * This method do the same as [android.app.Activity.onCreate]
     */
    protected abstract fun initViews()

    private lateinit var progressView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        progressView = generateProgressView()
        presenter = createPresenter()
        initViews()
        addContentView(progressView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
    // Respond to the action bar's Up/Home button
        android.R.id.home -> consume { closeKeyboard() }
        else -> super.onOptionsItemSelected(item)
    }

    override fun showProgressView() {
        runOnUiThread {
            progressView.visible()
        }
    }

    override fun hideProgressView() {
        runOnUiThread {
            progressView.gone()
        }
    }

    override fun closeKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun getContext(): Context = this

    /**
     * Start next and finishes current activity
     */
    protected inline fun <reified T : Activity> startAffinity(vararg params: Pair<String, Any?>) {
        startActivity<T>(*params)
        finishAffinity()
    }

    /**
     * Creates progress view. You can implement your own progress view. <br></br>
     * Just replace first parameter of inflate() method on your own implementation
     *
     * @return generated progress view
     */
    private fun generateProgressView(): View = inflate(R.layout.widget_progress_view)

}