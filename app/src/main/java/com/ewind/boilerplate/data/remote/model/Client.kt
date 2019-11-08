package com.ewind.boilerplate.data.remote.model


import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("avg_response_time_in_hours")
    var avgResponseTimeInHours: Int, // 131

    @SerializedName("description")
    var description: String, // Een snel ontbijt of afhaalpanini, businesslunch, bijeenkomst van de netwerkclub, feest of gezellig (zaken)diner: bij Restaurant de Carrousel kan het allemaal, op ieder moment van de dag. Eigentijds eten in een warme, inspirerende sfeer: een bijzondere combinatie van het zakelijke met het gezellige, stadse centrum.

    @SerializedName("factoring_allowed")
    var factoringAllowed: Boolean, // true

    @SerializedName("factoring_payment_term_in_days")
    var factoringPaymentTermInDays: Int, // 3

    @SerializedName("id")
    var id: String, // xvv6vr

    @SerializedName("name")
    var name: String, // Carrousel Eindhoven

    @SerializedName("photos")
    var photos: List<Photo>
)