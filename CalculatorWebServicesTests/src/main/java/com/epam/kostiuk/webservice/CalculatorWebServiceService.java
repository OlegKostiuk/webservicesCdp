package com.epam.kostiuk.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.17
 * 2015-09-10T18:21:55.546+03:00
 * Generated source version: 2.7.17
 * 
 */
@WebServiceClient(name = "CalculatorWebServiceService", 
                  wsdlLocation = "http://localhost:8080/CalculatorWebService/calculator?wsdl",
                  targetNamespace = "http://webservice.kostiuk.epam.com/") 
public class CalculatorWebServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.kostiuk.epam.com/", "CalculatorWebServiceService");
    public final static QName CalculatorPort = new QName("http://webservice.kostiuk.epam.com/", "calculatorPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/CalculatorWebService/calculator?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CalculatorWebServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/CalculatorWebService/calculator?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CalculatorWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalculatorWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorWebServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorWebServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorWebServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "calculatorPort")
    public Calculator getCalculatorPort() {
        return super.getPort(CalculatorPort, Calculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "calculatorPort")
    public Calculator getCalculatorPort(WebServiceFeature... features) {
        return super.getPort(CalculatorPort, Calculator.class, features);
    }

}