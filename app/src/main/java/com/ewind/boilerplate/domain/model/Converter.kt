package com.ewind.boilerplate.domain.model

import com.ewind.boilerplate.data.remote.model.Location
import com.ewind.boilerplate.data.remote.model.Shift

fun Shift.toViewModel(): DShift = DShift(
    currency,
    duration,
    earningsPerHour,
    endDatetime,
    endTime,
    id,
    isAutoAcceptedWhenAppliedFor,
    startDate,
    startDatetime,
    startTime,
    tempersNeeded
)

fun Location.toViewModel(): DLocation = DLocation(
    lat, lng
)