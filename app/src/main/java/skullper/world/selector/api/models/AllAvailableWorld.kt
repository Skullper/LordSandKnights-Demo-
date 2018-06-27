package skullper.world.selector.api.models

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

data class AllAvailableWorld(
        val id: String,
        val language: String,
        val url: String,
        val country: String,
        val worldStatus: WorldStatus,
        val mapURL: String,
        val name: String
)