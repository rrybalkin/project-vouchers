//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.04.21 at 09:33:45 PM MSK 
//


package com.rrybalkin.reporting.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.romansun.reports.jaxb package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Root_QNAME = new QName("http://www.example.org/SaveFormalSchema", "Root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.romansun.reports.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RootType }
     * 
     */
    public RootType createRootType() {
        return new RootType();
    }

    /**
     * Create an instance of {@link VisitorsType }
     * 
     */
    public VisitorsType createVisitorsType() {
        return new VisitorsType();
    }

    /**
     * Create an instance of {@link ReportType }
     * 
     */
    public ReportType createReportType() {
        return new ReportType();
    }

    /**
     * Create an instance of {@link VisitorType }
     * 
     */
    public VisitorType createVisitorType() {
        return new VisitorType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SaveFormalSchema", name = "Root")
    public JAXBElement<RootType> createRoot(RootType value) {
        return new JAXBElement<RootType>(_Root_QNAME, RootType.class, null, value);
    }

}
