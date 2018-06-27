package skullper.world.selector.screens

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import skullper.world.selector.R
import skullper.world.selector.api.models.WorldItem
import skullper.world.selector.extensions.string
import skullper.world.selector.mvp.contracts.AuthContract
import skullper.world.selector.mvp.presenters.AuthPresenter
import skullper.world.selector.skeleton.activity.BaseActivity


class MainActivity : BaseActivity<AuthContract.Presenter>(), AuthContract.View {

    private val deviceType = "${android.os.Build.MODEL} ${android.os.Build.VERSION.RELEASE}"
    private val isLoginNotEmpty: Boolean by lazy(LazyThreadSafetyMode.NONE) {
        et_main_login.string.isNotBlank()
    }
    private val isPasswordNotEmpty: Boolean by lazy(LazyThreadSafetyMode.NONE) {
        et_main_pass.string.isNotBlank()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun createPresenter(): AuthPresenter = AuthPresenter(this)

    override fun initViews() {
        btn_main_sign_in.setOnClickListener {
            if (et_main_login.string.isNotBlank() && et_main_pass.string.isNotBlank()) {
                val deviceId = presenter.getMacAddress()
                presenter.login(et_main_login.text.toString(), et_main_pass.text.toString(), deviceType, deviceId)
            } else {
                toast(R.string.auth_credentials_exception)
            }
        }
    }

    override fun onDataFetched(worlds: List<WorldItem>) =
            startAffinity<WorldsActivity>(WorldsActivity.EXTRA_WORLDS to worlds)

    override fun onLoginError(error: Throwable) {
        toast(error.localizedMessage)
    }

}
