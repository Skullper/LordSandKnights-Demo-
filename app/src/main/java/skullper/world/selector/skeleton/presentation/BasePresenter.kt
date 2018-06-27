package skullper.world.selector.skeleton.presentation

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

interface BasePresenter<V : BaseView> {
    val view: V
}