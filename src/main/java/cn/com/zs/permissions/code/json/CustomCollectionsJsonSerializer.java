package cn.com.zs.permissions.code.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Collections;

/**
 * 标题:
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 * 公司: 广州点睿信息科技有限公司
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/3/3-22:26
 */
public class CustomCollectionsJsonSerializer extends JsonSerializer<Object>{
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if (o == null){
            jsonGenerator.writeStartArray();;
            jsonGenerator.writeEndArray();
        } else {
            jsonGenerator.writeObject(o);
        }
    }
}
