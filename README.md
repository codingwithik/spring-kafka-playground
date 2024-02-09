# Kafka Playground
Test kafka with consumer groups, consumers, partitions and offsets

### Prerequisites ###

* Maven
* Docker
* Docker Compose
* Java 17

 # Key Components

* Producer: A producer is responsible for publishing data to Kafka topics. It sends records (messages) to one or more Kafka brokers.
* Broker: A Kafka broker is a server responsible for storing and managing Kafka topics. It handles the storage, replication, and distribution of data across partitions.
* Topic: A topic is a category or feed name to which records are published by producers. Topics are divided into partitions to allow for parallel processing and scalability.
* Partition: A partition is a unit of data organization within a topic. Each partition is an ordered, immutable sequence of records. Partitions allow for parallel consumption of data and horizontal scalability.
* Consumer: A consumer reads data from Kafka topics. It subscribes to one or more topics and consumes records produced by producers.
* Consumer Group: Consumers that belong to the same consumer group share the workload of consuming records from partitions. Each partition is consumed by only one consumer within a consumer group, allowing for parallel processing and load balancing.
* ZooKeeper: ZooKeeper is a centralized service used for managing and coordinating distributed systems. In Kafka, ZooKeeper is used for various tasks, including:
    * Managing cluster metadata: ZooKeeper keeps track of information about Kafka brokers, topics, partitions, and consumer groups.
    * Leader election: ZooKeeper is used for leader election within Kafka brokers and partitions. It determines which broker is the leader for each partition.
    * Membership management: ZooKeeper helps manage the membership of Kafka brokers and consumer groups.
    * Configuration management: ZooKeeper stores and manages Kafka's configuration settings.
 

### How do I start the single kafka and zookeeper instance? ###

* docker-compose build
* docker-compose up -d

### How do I start the services? ###

* docker-compose -f services.yml build
* docker-compose -f services.yml up -d

### How do I stop the service? ###

* docker-compose -f services.yml down

### How do I stop the single kafka instance? ###

* docker-compose down

### Testing ###

* curl -X POST http://localhost:6000/send?message=testing test-1 topic
* curl -X POST http://localhost:6000/send-message?message=testing test-2 topic
* curl -X POST http://localhost:6005/send?name=codingwithik
* curl -X POST http://localhost:6005/multi-send?name=codingwithik
