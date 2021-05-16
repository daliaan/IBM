package dalian.razvan.cucer.githubandroidrepos.core.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.githubandroidrepos.models.Repo

data class ReposResponse(@SerializedName("total_count") val totalCount: Int = 0,
                         @SerializedName("incomplete_results") val hasIncompleteResults: Boolean = false,
                         @SerializedName("items") val repos: ArrayList<Repo> = arrayListOf()): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        arrayListOf<Repo>().apply {
            parcel.readArrayList(Repo::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(totalCount)
        parcel.writeByte(if (hasIncompleteResults) 1 else 0)
        parcel.writeList(repos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReposResponse> {
        override fun createFromParcel(parcel: Parcel): ReposResponse {
            return ReposResponse(parcel)
        }

        override fun newArray(size: Int): Array<ReposResponse?> {
            return arrayOfNulls(size)
        }
    }
}
