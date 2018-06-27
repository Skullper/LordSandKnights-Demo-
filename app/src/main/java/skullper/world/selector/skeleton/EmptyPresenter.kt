package skullper.world.selector.skeleton

import skullper.world.selector.skeleton.presentation.BasePresenter
import skullper.world.selector.skeleton.presentation.BaseView

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Used when activity doesn't require a Presenter class
 */
class EmptyPresenter(override val view: BaseView) : BasePresenter<BaseView>
