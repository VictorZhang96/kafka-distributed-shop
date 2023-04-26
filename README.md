# Distributed Shop

This project implement distributed transaction with Kafka and springboot on the senario of e shopping.  

![image-20230426172646180](./Kafka-Distributed-Shop/assets/image-20230426172646180.png)

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

![image-20230419224706236](./Kafka-Distributed-Shop/assets/image-20230419224706236.png)

4. modify the `spring.kafka.bootstrap-servers` properties in `application.yml` for **all 3 app**.

![image-20230419224833743](./Kafka-Distributed-Shop/assets/image-20230419224833743.png)

5. Then, run order app, stock app and payment app. 

**To run the react frontend:**

go to the frontend folder and then:

```
npm i && npm start
```

The react frontend will send get/put request to the  `order-service`,  `payment-service`, and `stock-service` with `axios`.

**Expected:**

After you run the frontend, when you click buy button and refresh the page, you shall see the correct account balance, stock number and customer name in the frontend. The frontend use `axios` to send get/put request to the  `order-service`,  `payment-service`, and `stock-service`.

When a order placed, check the log in `order-service`,  `payment-service`, and `stock-service` for detail.
