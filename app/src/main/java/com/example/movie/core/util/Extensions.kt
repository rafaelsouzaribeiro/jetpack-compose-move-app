package com.example.movie.core.util

import com.example.movie.BuildConfig

fun String?.toPostUrl()="${BuildConfig.BASE_URL_IMAGE}$this"

fun String?.toBrckdropUrl()="${BuildConfig.BASE_URL_IMAGE}$this"