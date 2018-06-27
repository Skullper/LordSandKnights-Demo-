package skullper.world.selector.api.mappers

import skullper.world.selector.api.models.AllAvailableWorld
import skullper.world.selector.api.models.WorldItem

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class WorldMapper {

    fun transform(data: List<AllAvailableWorld>): List<WorldItem> = data.map {
        WorldItem(it.name, it.language, it.country, it.worldStatus.description)
    }
}