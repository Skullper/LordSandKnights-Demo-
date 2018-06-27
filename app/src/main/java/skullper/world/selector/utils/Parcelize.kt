package skullper.world.selector.utils

import android.os.Parcel
import android.os.Parcelable

/*
 * Created by pugman on 23.05.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Simple wrap on existing [Parcelable] interface to avoid overriding one excessive method
 */
interface Parcelize : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(parcel: Parcel, flags: Int)
}