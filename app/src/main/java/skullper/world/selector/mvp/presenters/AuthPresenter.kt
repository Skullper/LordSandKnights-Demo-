package skullper.world.selector.mvp.presenters

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import skullper.world.selector.api.RestClient
import skullper.world.selector.api.mappers.WorldMapper
import skullper.world.selector.api.responses.GameWorldsResponse
import skullper.world.selector.mvp.contracts.AuthContract
import skullper.world.selector.utils.AppPreferences
import java.net.NetworkInterface
import java.util.*

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class AuthPresenter(override val view: AuthContract.View) : AuthContract.Presenter {

    override fun login(login: String, password: String, deviceType: String, deviceId: String) =
            RestClient.api.signIn(login, password, deviceType, deviceId)
                    .enqueue(object : Callback<GameWorldsResponse> {
                        override fun onFailure(call: Call<GameWorldsResponse>?, t: Throwable) {
                            view.onLoginError(t)
                        }

                        override fun onResponse(call: Call<GameWorldsResponse>?,
                                                response: Response<GameWorldsResponse>?) {
                            AppPreferences.login = login
                            AppPreferences.password = password
                            val body = response?.body()
                            if (body != null) {
                                val mapper = WorldMapper()
                                view.onDataFetched(mapper.transform(body.allAvailableWorlds))
                            }
                        }
                    })

    override fun getMacAddress(): String {
        try {
            val all = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0", true)) continue
                val macBytes = nif.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }
                if (res1.isNotEmpty()) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (e: Exception) {
            //ignored in this case
        }
        return "02:00:00:00:00:00" // default value
    }
}