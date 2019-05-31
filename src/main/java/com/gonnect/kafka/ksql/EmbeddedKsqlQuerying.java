package com.gonnect.kafka.ksql;

import io.confluent.ksql.KsqlContext;
import io.confluent.ksql.logging.processing.ProcessingLogContext;
import io.confluent.ksql.util.KsqlConfig;

import java.util.Collections;
import java.util.Map;

public class EmbeddedKsqlQuerying {

    public static void main(final String[] args) {

        final KsqlContext ksqlContext = KsqlContext.create(
                new KsqlConfig(Map.of("bootstrap.servers","localhost:9092")),
                ProcessingLogContext.create());

//        ksqlContext.sql("REGISTER TOPIC orders_topic WITH (VALUE_FORMAT = 'json', "
//                + "kafka_topic='orders_topic_json');");

        ksqlContext.sql("CREATE STREAM orders (ordertime bigint, orderid bigint, itemid varchar, "
                + "orderunits double, arraycol array<double>, mapcol map<varchar, double>) "
                + "WITH (KAFKA_TOPIC = 'orders_topic',VALUE_FORMAT = 'json' , key='orderid');\n");
//        ksqlContext.sql("CREATE STREAM BIGORDERS AS SELECT * FROM ORDERS WHERE ORDERUNITS > 5;");
//        ksqlContext.sql("SELECT * FROM ORDERS;");
//        ksqlContext.sql("CREATE TABLE ORDERSUMS AS select itemid, sum(orderunits) from orders window "
//                + "TUMBLING ( size 30 second) group by itemid;");

        System.out.println("Stream orders is running!");

    }
}
