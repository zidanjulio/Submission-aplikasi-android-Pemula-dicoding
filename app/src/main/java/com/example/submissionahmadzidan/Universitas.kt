package com.example.submissionahmadzidan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Universitas(
    val name: String,
    val description: String,
    val photo: Int
) :Parcelable
