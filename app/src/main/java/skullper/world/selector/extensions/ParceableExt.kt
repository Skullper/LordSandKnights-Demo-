package skullper.world.selector.extensions

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by pugman on 23.05.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Use this extension method to eliminate creation of Parcelable CREATOR
 */
inline fun <reified T> parcelableCreator(
        crossinline create: (Parcel) -> T) =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel) = create(source)
            override fun newArray(size: Int) = arrayOfNulls<T>(size)
        }