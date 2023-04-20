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

![image-20230419224706236](/Users/huang/Library/Application Support/typora-user-images/image-20230419224706236.png)

4. modify the `spring.kafka.bootstrap-servers` properties in `application.yml` for **all 3 app**.

![image-20230419224833743](/Users/huang/Library/Application Support/typora-user-images/image-20230419224833743.png)

5. Then, run order app, stock app and payment app. 

**To run the frontend:**

go to the frontend folder and then:

```
npm i && npm start
```

