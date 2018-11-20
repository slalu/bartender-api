package com.lalu.bartender.domain.mapper

import com.lalu.bartender.domain.Measurement

class MeasurementMapper {
    companion object {
        fun map(measurement: com.lalu.bartender.domain.dto.Measurement): Measurement {
            return Measurement(
                    quantity = measurement.quantity,
                    unit = measurement.unit
            )
        }

        fun map(measurement: Measurement): com.lalu.bartender.domain.dto.Measurement {
            return com.lalu.bartender.domain.dto.Measurement.new {
                quantity = measurement.quantity
                unit = measurement.unit
            }
        }
    }
}