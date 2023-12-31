package com.utad.navegacion.recyclerView

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class New(
    val title: String,
    val image: String,
    val description: String,
    val author: String
) : Parcelable
