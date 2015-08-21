package com.epam.kostiuk.webservice;

import com.epam.kostiuk.webservice.operations.Add;
import com.epam.kostiuk.webservice.operations.Div;
import com.epam.kostiuk.webservice.operations.Mul;
import com.epam.kostiuk.webservice.operations.Pow;
import com.epam.kostiuk.webservice.operations.Sub;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

/**
 * Soap web service wsdl access: http://localhost:8080/CalculatorWebService/calculator?wsdl
 */

@WebService(name = "calculator")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CalculatorWebService {

    public CalculatorWebService() {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
    }

    @WebMethod(operationName = "add")
    public void add(@WebParam(name = "value1") float value1, @WebParam(name = "value2") float value2,
                    @WebParam(name = "result", mode = WebParam.Mode.OUT) Holder<Double> result) {
        result.value = new Add().perform(value1, value2);
    }

    @WebMethod(operationName = "div")
    public void div(@WebParam(name = "value1") float value1, @WebParam(name = "value2") float value2,
                    @WebParam(name = "result", mode = WebParam.Mode.OUT) Holder<Double> result) {
        result.value = new Div().perform(value1, value2);
    }

    @WebMethod(operationName = "sub")
    public void sub(@WebParam(name = "value1") float value1, @WebParam(name = "value2") float value2,
                    @WebParam(name = "result", mode = WebParam.Mode.OUT) Holder<Double> result) {
        result.value = new Sub().perform(value1, value2);

    }

    @WebMethod(operationName = "mul")
    public void mul(@WebParam(name = "value1") float value1, @WebParam(name = "value2") float value2,
                    @WebParam(name = "result", mode = WebParam.Mode.OUT) Holder<Double> result) {
        result.value = new Mul().perform(value1, value2);
    }

    @WebMethod(operationName = "pow")
    public void pow(@WebParam(name = "value1") float value1, @WebParam(name = "value2") float value2,
                    @WebParam(name = "result", mode = WebParam.Mode.OUT) Holder<Double> result) {
        result.value = new Pow().perform(value1, value2);
    }

}


