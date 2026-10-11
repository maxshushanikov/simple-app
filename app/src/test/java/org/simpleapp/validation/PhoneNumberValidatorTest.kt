package org.simpleapp.validation

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PhoneNumberValidatorTest {
    @Test
    fun acceptsValidPhoneNumberFormats() {
        assertTrue(PhoneNumberValidator.isValid("+1 (234) 567-8900"))
        assertTrue(PhoneNumberValidator.isValid("555-1234"))
        assertTrue(PhoneNumberValidator.isValid("12,34;5"))
    }

    @Test
    fun rejectsBlankValuesAndValuesWithoutDigits() {
        assertFalse(PhoneNumberValidator.isValid(""))
        assertFalse(PhoneNumberValidator.isValid("   "))
        assertFalse(PhoneNumberValidator.isValid("+()-"))
    }

    @Test
    fun rejectsUnsupportedCharacters() {
        assertFalse(PhoneNumberValidator.isValid("555-CALL"))
        assertFalse(PhoneNumberValidator.isValid("555/1234"))
    }

    @Test
    fun acceptsSurroundingWhitespace() {
        assertTrue(PhoneNumberValidator.isValid(" 555-1234 "))
    }
}
