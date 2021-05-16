package dalian.razvan.cucer.githubandroidrepos.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseModel

data class Repo(@SerializedName("name") val name: String = "",
                @SerializedName("display_name") val displayName: String = "",
                @SerializedName("short_description") val shortDescription: String = "",
                @SerializedName("description") val description: String = "",
                @SerializedName("created_by") val createdBy: String = "",
                @SerializedName("released") val released: String = "",
                @SerializedName("featured") val isFeatured: Boolean = false,
                @SerializedName("curated") val isCurated: Boolean = false,
                @SerializedName("score") val score: Double = 1.1): BaseModel(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(displayName)
        parcel.writeString(shortDescription)
        parcel.writeString(description)
        parcel.writeString(createdBy)
        parcel.writeString(released)
        parcel.writeByte(if (isFeatured) 1 else 0)
        parcel.writeByte(if (isCurated) 1 else 0)
        parcel.writeDouble(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Repo> {
        override fun createFromParcel(parcel: Parcel): Repo {
            return Repo(parcel)
        }

        override fun newArray(size: Int): Array<Repo?> {
            return arrayOfNulls(size)
        }
    }
}
