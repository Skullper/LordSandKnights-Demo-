package skullper.world.selector.skeleton.presentation

import android.content.Context

/*
  Created by pugman on 27.06.18.
  Contact the developer - sckalper@gmail.com
  company - A2Lab
 */
interface BaseView {

    /**
     * Use this to block UI(e.g. when sending request to server).
     * When you have no need to block UI run [.hideProgressView] method
     * <br></br><br></br>
     * You can use your progress view implementation. Check getProgressView() in BaseActivity
     */
    fun showProgressView()

    /**
     * Hides previously showed progress view.
     * You MUST call this method after long term operation finished otherwise
     * user will always behold on progress view
     */
    fun hideProgressView()

    /**
     * Retrieve current context of view
     */
    fun getContext(): Context

}
