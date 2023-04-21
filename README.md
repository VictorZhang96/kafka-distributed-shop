# Distributed Shop

This project implement distributed transaction with Kafka and springboot on the senario of e shopping.  

### Run

**To run the backend:**

1. Make sure you have docker install and go to the backend folder
2. Install Redpanda for running Kafka

```
brew install redpanda-data/tap/redpanda
```

3. start Kafka by running:

```
rpk container start
```

it will print the address for your Kafka node

It is : ```51106``` in my case

4. modify the `spring.kafka.bootstrap-servers` properties in `application.yml` for **all 3 app**. Replace them with your Kafka node port


5. Then, run order app, stock app and payment app. 

**To run the frontend:**

go to the frontend folder and then:

```
npm i && npm start
```

