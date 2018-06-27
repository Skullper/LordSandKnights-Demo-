package skullper.world.selector.mvp.contracts

import skullper.world.selector.api.models.WorldItem
import skullper.world.selector.skeleton.presentation.BasePresenter
import skullper.world.selector.skeleton.presentation.BaseView

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

interface AuthContract {

    interface View : BaseView {
        fun onDataFetched(worlds: List<WorldItem>)

        fun onLoginError(error: Throwable)
    }

    interface Presenter : BasePresenter<View> {
        fun login(login: String, password: String, deviceType: String, deviceId: String)

        /**
         * Used in app as device id
         */
        fun getMacAddress() : String
    }
}