package com.example.ecommerce.utils

import java.text.DecimalFormat

class ChangeNumber {
    fun format(n: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(n)
    }

}