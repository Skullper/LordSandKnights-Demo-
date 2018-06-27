package skullper.world.selector.screens

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_worlds.*
import org.jetbrains.anko.toast
import skullper.world.selector.R
import skullper.world.selector.adapter.WorldSelectorAdapter
import skullper.world.selector.api.models.WorldItem
import skullper.world.selector.skeleton.EmptyPresenter
import skullper.world.selector.skeleton.activity.BaseActivity
import skullper.world.selector.utils.decoration.VerticalItemDecoration

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class WorldsActivity : BaseActivity<EmptyPresenter>() {

    override fun getLayoutId(): Int = R.layout.activity_worlds

    override fun createPresenter(): EmptyPresenter = EmptyPresenter(this)

    override fun initViews() {
        val worlds = intent.getParcelableArrayListExtra<WorldItem>(EXTRA_WORLDS)
        rv_worlds.apply {
            layoutManager = LinearLayoutManager(this@WorldsActivity)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(VerticalItemDecoration())
            adapter = WorldSelectorAdapter(worlds) {
                toast(getString(R.string.worlds_congrats, it.name))
            }
        }
    }

    companion object {
        const val EXTRA_WORLDS = "game_worlds"
    }
}