package org.simpleapp.validation

object PhoneNumberValidator {
    private val phoneNumberPattern = Regex("""^[+]?[0-9().,;*#\-\s]+$""")

    fun isValid(value: String): Boolean {
        val phoneNumber = value.trim()
        return phoneNumber.isNotEmpty() &&
            phoneNumber.any(Char::isDigit) &&
            phoneNumberPattern.matches(phoneNumber)
    }
}
