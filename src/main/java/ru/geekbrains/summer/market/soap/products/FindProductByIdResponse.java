//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.09.03 at 12:15:52 PM MSK 
//


package ru.geekbrains.summer.market.soap.products;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productDto" type="{http://www.example.com/products}soapProductDto"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productDto"
})
@XmlRootElement(name = "findProductByIdResponse")
public class FindProductByIdResponse {

    @XmlElement(required = true)
    protected SoapProductDto productDto;

    /**
     * Gets the value of the productDto property.
     *
     * @return
     *     possible object is
     *     {@link SoapProductDto }
     *
     */
    public SoapProductDto getProductDto() {
        return productDto;
    }

    /**
     * Sets the value of the productDto property.
     *
     * @param value
     *     allowed object is
     *     {@link SoapProductDto }
     *     
     */
    public void setProductDto(SoapProductDto value) {
        this.productDto = value;
    }

}
