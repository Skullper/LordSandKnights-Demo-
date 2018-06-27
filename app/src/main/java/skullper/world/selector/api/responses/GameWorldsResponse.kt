package skullper.world.selector.api.responses

import skullper.world.selector.api.models.AllAvailableWorld


data class GameWorldsResponse(
        val serverVersion: String,
        val allAvailableWorlds: List<AllAvailableWorld>
)