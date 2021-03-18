package com.example.fdaapi3.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class RecalledItem(
    val results : List<Item>,
) : Parcelable
@Parcelize
data class Item(
        @SerializedName("_id")
        val address_1: String,
        val reason_for_recall: String,
        val address_2: String,
        val product_quantity: String,
        val code_info: String,
        val center_classification_date: String,
        val distribution_pattern: String,
        val state: String,
        val product_description: String,
        val report_date: String,
        val classification: String,
        val recalling_firm: String,
        val recall_number: String,
        val initial_firm_notification: String,
        val product_type: String,
        val event_id: String,
        val termination_date: String,
        val recall_initiation_date: String,
        val postal_code: String,
        val voluntary_mandated: String,
        val status: String,
) : Parcelable
