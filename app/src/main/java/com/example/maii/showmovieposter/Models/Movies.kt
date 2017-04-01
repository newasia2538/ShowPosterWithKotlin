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

    class ResultsBean : Parcelable {

        companion object {
            @JvmField
            val CREATOR = object : Parcelable.Creator<Movies.ResultsBean?> {
                override fun createFromParcel(source: Parcel?): Movies.ResultsBean {
                    return Movies.ResultsBean()
                }

                override fun newArray(size: Int): Array<Movies.ResultsBean?> {
                    return arrayOfNulls<Movies.ResultsBean?>(size)
                }
            }
        }


        override fun writeToParcel(dest: Parcel?, flags: Int) {
            dest?.writeString(poster_path)
            dest?.writeString(overview)
            dest?.writeInt(id)
            dest?.writeString(original_title)
            dest?.writeString(original_language)
            dest?.writeString(backdrop_path)
            dest?.writeDouble(popularity)
            dest?.writeInt(vote_count)
            dest?.writeDouble(vote_average)
            dest?.writeSerializable(release_date)
        }

        override fun describeContents(): Int {
            return 0
        }

        protected fun ResultsBean(`in`: Parcel) {
            poster_path = `in`.readString()
            overview = `in`.readString()
            id = `in`.readInt()
            original_title = `in`.readString()
            original_language = `in`.readString()
            backdrop_path = `in`.readString()
            popularity = `in`.readDouble()
            vote_count = `in`.readInt()
            vote_average = `in`.readDouble()
            release_date = `in`.readString()

        }



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

        dest?.writeInt(page)
        dest?.writeInt(total_results)
        dest?.writeInt(total_pages)
        dest?.writeList(results)

    }

    protected fun Movies (`in`: Parcel) {

        page = `in`.readInt()
        total_pages = `in`.readInt()
        total_results = `in`.readInt()
        `in`.readTypedList<Movies.ResultsBean>(results,ResultsBean.CREATOR)

    }

    override fun describeContents(): Int {
        return 0
    }
}

