## Kafka KSQL
A project demonstrate embedded Kafka KSQL
## run kafka
````bash
docker-compose up -d
````

## create topic

````bash
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic orders_topic
````

## Run the class EmbeddedKsqlQuerying

This is create a stream orders

