package com.example.maii.showmovieposter.Models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Maii on 29/3/2560.
 */
class Movies:Parcelable {






    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
    var results: List<ResultsBean>? = null

    class ResultsBean {

        /**
         * poster_path : /e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg
         * adult : false
         * overview : From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.
         * release_date : 2016-08-03
         * genre_ids : [14,28,80]
         * id : 297761
         * original_title : Suicide Squad
         * original_language : en
         * title : Suicide Squad
         * backdrop_path : /ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg
         * popularity : 48.261451
         * vote_count : 1466
         * video : false
         * vote_average : 5.91
         */


        var poster_path: String? = null
        var adult: Boolean = false
        var overview: String? = null
        var release_date: String? = null
        var id: Int = 0
        var original_title: String? = null
        var original_language: String? = null
        var title: String? = null
        var backdrop_path: String? = null
        var popularity: Double = 0.toDouble()
        var vote_count: Int = 0
        var video: Boolean = false
        var vote_average: Double = 0.toDouble()
        var genre_ids: List<Int>? = null
    }

    val CREATOR: Parcelable.Creator<Movies> = object : Parcelable.Creator<Movies> {
        override fun createFromParcel(source: Parcel?): Movies {
            return Movies()
        }

        override fun newArray(size: Int): Array<Movies?> {
            return arrayOfNulls<Movies?>(size)
        }
    }


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(results?.get(flags)?.poster_path)
        dest?.writeString(results?.get(flags)?.overview)
        dest?.writeInt(results?.get(flags)?.id!!)
        dest?.writeString(results?.get(flags)?.original_title)
        dest?.writeString(results?.get(flags)?.original_language)
        dest?.writeString(results?.get(flags)?.backdrop_path)
        dest?.writeDouble(results?.get(flags)?.popularity!!)
        dest?.writeInt(results?.get(flags)?.vote_count!!)
        dest?.writeDouble(results?.get(flags)?.vote_average!!)
        dest?.writeSerializable(results?.get(flags)?.release_date)
    }

    override fun describeContents(): Int {
        return 0
    }
}

