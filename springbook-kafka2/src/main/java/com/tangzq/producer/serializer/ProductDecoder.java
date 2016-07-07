package com.tangzq.producer.serializer;

import com.tangzq.producer.model.Product;
import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;
import org.springframework.util.SerializationUtils;

/**
 * Author tangzq.
 */
public class ProductDecoder implements Decoder<Product> {

    public ProductDecoder(){
    }
    public ProductDecoder(VerifiableProperties properties) {
    }

    @Override
    public Product fromBytes(byte[] bytes) {
        return (Product) SerializationUtils.deserialize(bytes);
    }
}
