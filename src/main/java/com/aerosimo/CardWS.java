/******************************************************************************
 * This piece of work is to enhance CardChecker project functionality.        *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      CardWS.java                                                     *
 * Created:   29/10/2021, 15:29                                               *
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

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;

import java.util.List;

@WebService(name = "CardValidation", serviceName = "CardService",
        portName = "ValidateCard", targetNamespace = "https://www.aerosimo.com/ws/cardchecker")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class CardWS {

    @WebMethod(operationName = "validateCard")
    @WebResult(name = "validateCard", partName = "validateCardResponse")
    public List<CardMsg> checkCard(@WebParam(name = "CardLongNumber",
            partName = "validateCardRequest") String CardLongNumber) {
        return CardAPI.ValidateCard(CardLongNumber);
    }
}
