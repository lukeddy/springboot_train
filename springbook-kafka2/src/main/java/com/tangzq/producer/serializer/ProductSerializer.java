package com.tangzq.producer.serializer;

import com.tangzq.producer.model.Product;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;
import org.springframework.util.SerializationUtils;

/**
 *
 * Author tangzq.
 */
public class ProductSerializer implements Encoder<Product> {

    public ProductSerializer(){
    }
    public ProductSerializer(VerifiableProperties properties) {
    }

    @Override
    public byte[] toBytes(Product product) {
        return SerializationUtils.serialize(product);
    }
}
