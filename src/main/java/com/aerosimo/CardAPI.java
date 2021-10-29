/******************************************************************************
 * This piece of work is to enhance CardChecker project functionality.        *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CardAPI.java                                                    *
 * Created:   29/10/2021, 03:52                                               *
 * Modified:  29/10/2021, 15:45                                               *
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

import java.util.ArrayList;
import java.util.List;

public class CardAPI {

    public static void main(String[] args) {
        System.out.println(ValidateCard("3556504654282618"));
    }

    public static List<CardMsg> ValidateCard(String cardLongNumber) {
        List<CardMsg> cardList;
        cardList = new ArrayList<>();

        String digit1 = cardLongNumber.substring(0, 1);
        String digit2 = cardLongNumber.substring(0, 2);
        String digit4 = cardLongNumber.substring(0, 4);

        if (cardLongNumber.chars().allMatch(Character::isDigit)) {
            /* ----
             ** VISA  prefix=4
             ** ----  length=13 or 16  (can be 15 too!?! maybe)
             */
            if (digit1.equals("4") && (cardLongNumber.length() == 13 || cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "VISA"));
                Log.info("VISA Card validation is successful");
            }
            /* ----------
             ** MASTERCARD  prefix= 22 ... 27
             **             prefix= 51 ... 55
             ** ----------  length= 16
             */
            else if (digit2.compareTo("22") >= 0 && digit2.compareTo("27") <= 0 && (cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "MasterCard"));
                Log.info("MasterCard validation is successful");
            } else if (digit2.compareTo("51") >= 0 && digit2.compareTo("55") <= 0 && (cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "MasterCard"));
                Log.info("MasterCard validation is successful");
            }
            /* ----
             ** AMEX  prefix=34 or 37
             ** ----  length=15
             */
            else if ((digit2.equals("34") || digit2.equals("37")) && (cardLongNumber.length() == 15)) {
                cardList.add(new CardMsg("OK", "American Express"));
                Log.info("Amex Card validation is successful");
            }
            /* -----
             ** JCB prefix=3528.....3589
             **     prefix=1800.....2131
             ** ----- length=16
             */
            else if ((digit4.compareTo("3528") >= 0 && digit4.compareTo("3589") <= 0) && (cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "JCB"));
                Log.info("JCB Card validation is successful");
            } else if ((digit4.equals("1800") || digit4.equals("2131")) && (cardLongNumber.length() == 15)) {
                cardList.add(new CardMsg("OK", "JCB"));
                Log.info("JCB Card validation is successful");
            }
            /* -----
             ** enRoute prefix=300 ... 305 or 36 or 38
             ** ----- length=14
             ** Valid length: 15 digits. First four digits must be 2014 or 2149.
             */
            else if ((digit4.equals("2014") || digit4.equals("2149")) && (cardLongNumber.length() == 15)) {
                cardList.add(new CardMsg("OK", "enRoute"));
                Log.info("enRoute Card validation is successful");
            }
            /* -----
             ** DCLUB prefix=300 ... 305 or 36 or 38
             **  300000 through 305999
             **    309500 through 309599
             **    360000 through 369999
             **    380000 through 399999
             ** ----- length=14
             */
            else if ((digit4.compareTo("3000") >= 0 && digit4.compareTo("3999") <= 0) && (cardLongNumber.length() == 14)) {
                cardList.add(new CardMsg("OK", "DinersClub"));
                Log.info("DinersClub Card validation is successful");
            }
            /* ----------
             ** BANKCARD    prefix= 5610
             ** ----------  length= 16
             */
            else if ((digit4.equals("6333") ||
                    digit4.equals("6759") ||
                    digit4.equals("6334") ||
                    digit4.equals("6767") ||
                    digit4.equals("5641") ||
                    digit4.equals("5610")) && (cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "DebitCard"));
                Log.info("DebitCard validation is successful");
            }
            /* ----
             ** DISCOVER card prefix = 60
             ** --------      length = 16
             */
            else if ((digit4.equals("6011") || digit2.equals("65")) && (cardLongNumber.length() == 16)) {
                cardList.add(new CardMsg("OK", "Discover"));
                Log.info("Discover Card validation is successful");
            }
            /* ----
             ** VOYAGER card prefix = 8699
             ** --------      length = 15
             */
            else if (digit4.equals("8699") && (cardLongNumber.length() == 15)) {
                cardList.add(new CardMsg("OK", "Voyager"));
                Log.info("Voyager Card validation is successful");
            } else cardList.add(new CardMsg("NOK", "Unknown"));
        } else cardList.add(new CardMsg("NOK", "Invalid Card Number"));
        return cardList;
    }
}