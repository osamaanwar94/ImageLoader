@file:Suppress("unused")

package com.tintash.imageloader

import android.app.Activity
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import java.io.File

/**
 * Loads the image from the given url
 *
 * @receiver ImageView target view
 * @param url NonNull/NonEmpty string url
 * @param placeHolder Int? placeHolder Resource id
 * @param radius Int
 */
fun ImageView.loadImageFromUrl(url: String, @DrawableRes placeHolder: Int? = null, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(url)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 * Loads the image from the given url
 *
 * @receiver ImageView target view
 * @param url String NonNull/NonEmpty string url
 * @param placeHolder Drawable placeHolder Drawable
 * @param radius Int
 */
fun ImageView.loadImageFromUrl(url: String, placeHolder: Drawable, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(url)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 * Loads the image from the given url
 *
 * @receiver ImageView target View
 * @param url String NonNull/NonEmpty string url
 * @param requestOptions RequestOptions Glide.RequestOptions object
 */
fun ImageView.loadImageFromUrl(url: String, requestOptions: RequestOptions) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(url)
            .apply(requestOptions)
            .into(this)
    }
}

/**
 * Loads the image from the given drawable resource Id
 *
 * @receiver ImageView target View
 * @param drawable Int Drawable resource Id
 * @param placeHolder Int? placeHolder Resource id
 * @param radius Int
 */
fun ImageView.loadImageFromDrawable(@DrawableRes drawable: Int, @DrawableRes placeHolder: Int? = null, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param drawable Int
 * @param placeHolder Drawable
 * @param radius Int
 */
fun ImageView.loadImageFromDrawable(@DrawableRes drawable: Int, placeHolder: Drawable, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param drawable Int
 * @param requestOptions RequestOptions
 */
fun ImageView.loadImageFromDrawable(@DrawableRes drawable: Int, requestOptions: RequestOptions) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(requestOptions)
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param drawable Drawable
 * @param placeHolder Int?
 * @param radius Int
 */
fun ImageView.loadImageFromDrawable(drawable: Drawable, @DrawableRes placeHolder: Int? = null, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param drawable Drawable
 * @param placeHolder Drawable
 * @param radius Int
 */
fun ImageView.loadImageFromDrawable(drawable: Drawable, placeHolder: Drawable, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param drawable Drawable
 * @param requestOptions RequestOptions
 */
fun ImageView.loadImageFromDrawable(drawable: Drawable, requestOptions: RequestOptions) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(drawable)
            .apply(requestOptions)
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param file File
 * @param placeHolder Int?
 * @param radius Int
 */
fun ImageView.loadImageFromFile(file: File, @DrawableRes placeHolder: Int? = null, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(Uri.fromFile(file))
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param file File
 * @param placeHolder Drawable
 * @param radius Int
 */
fun ImageView.loadImageFromFile(file: File, placeHolder: Drawable, radius: Int = 0) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(file)
            .apply(getRequestOptions(radius, placeHolder))
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @param file File
 * @param requestOptions RequestOptions
 */
fun ImageView.loadImageFromFile(file: File, requestOptions: RequestOptions) {
    if (shouldStartLoadImage()) {
        Glide.with(this)
            .load(file)
            .apply(requestOptions)
            .into(this)
    }
}

/**
 *
 * @receiver ImageView
 * @return Boolean
 */
private fun ImageView.shouldStartLoadImage(): Boolean {
    val activity = this.context as? Activity
    return !(activity?.isDestroyed == true || activity?.isFinishing == true)
}

/**
 *
 * @param radius Int
 * @param placeHolder Int?
 * @return RequestOptions
 */
private fun getRequestOptions(radius: Int, @DrawableRes placeHolder: Int?) = RequestOptions().apply {
    if (radius > 0) {
        transform(CenterCrop(), RoundedCorners(radius))
    }

    placeHolder?.let {
        placeholder(it)
    }
}

/**
 * Returns RequestOptions with applied radius/CenterCropped and placeHolder
 *
 * @param radius Int
 * @param drawable Drawable?
 * @return RequestOptions
 */
private fun getRequestOptions(radius: Int, drawable: Drawable?) = RequestOptions().apply {
    if (radius > 0) {
        transform(CenterCrop(), RoundedCorners(radius))
    }

    placeholder(drawable)
}