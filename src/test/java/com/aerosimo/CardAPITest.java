/******************************************************************************
 * This piece of work is to enhance CardChecker project functionality.        *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CardAPITest.java                                                *
 * Created:   29/10/2021, 03:53                                               *
 * Modified:  29/10/2021, 15:46                                               *
 *                                                                            *
 * Copyright (c)  2021.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CardAPITest {

    @BeforeEach
    void setUp() {
        Log.info("Starting Card Validation Test");
    }

    @AfterEach
    void tearDown() {
        Log.info("Card Validation Test complete");
    }

    @Test
    @DisplayName("Validating VISA Card")
    void validateVISA() {
        List<CardMsg> card;
        String expected;
        expected = "VISA";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("4916801905619884");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating MasterCard Card")
    void validateMasterCard() {
        List<CardMsg> card;
        String expected;
        expected = "MasterCard";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("5193347091529678");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating American Express Card")
    void validateAmex() {
        List<CardMsg> card;
        String expected;
        expected = "American Express";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("348235854897579");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating Discover Card")
    void validateDiscover() {
        List<CardMsg> card;
        String expected;
        expected = "Discover";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("6011637797968909");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating DinersClub Card")
    void validateDinersClub() {
        List<CardMsg> card;
        String expected;
        expected = "DinersClub";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("38451119453513");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating enRoute Card")
    void validateenRoute() {
        List<CardMsg> card;
        String expected;
        expected = "enRoute";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("201442720379305");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating Voyager Card")
    void validateVoyager() {
        List<CardMsg> card;
        String expected;
        expected = "Voyager";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("869911334450879");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }

    @Test
    @DisplayName("Validating JCB Card")
    void validateJCB() {
        List<CardMsg> card;
        String expected;
        expected = "JCB";
        String actual;
        actual = null;
        card = CardAPI.ValidateCard("3556504654282618");
        for (CardMsg c : card) {
            actual = c.getCardNetwork();
        }
        assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the Card api");
    }
}