package skullper.world.selector.api.models

import android.os.Parcel
import skullper.world.selector.extensions.parcelableCreator
import skullper.world.selector.utils.Parcelize

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

data class WorldItem(val name: String,
                     val language: String,
                     val countryCode: String,
                     val description: String) : Parcelize {

    private constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(name)
        writeString(language)
        writeString(countryCode)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::WorldItem)
    }

}