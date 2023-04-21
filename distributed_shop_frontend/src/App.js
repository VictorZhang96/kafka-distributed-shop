import React, { useState, useEffect } from "react";
import axios from "axios";
import { Card, Button } from "react-bootstrap";

function randomGateway() {
  const serverNumber = 1;
  const randomInt = Math.floor(Math.random() * serverNumber) + 1;
  const serverPortList = [8080, 8081, 8082];
  return serverPortList[randomInt - 1];

}

function App() {
  const [data, setData] = useState(null);
  const [stockData, setStockData] = useState(null);


  const items = [
    {
      id: 1,
      title: "Book",
      description: "This is the first card.",
      price: 10,
      stock: stockData ? stockData[0].availableItems : null,
    },
    {
      id: 2,
      title: "Bike",
      description: "This is the second card.",
      price: 20,
    },
  ]

  const handleBuy = (item) => {
    const port = randomGateway();
    console.log("sending request to server: ", port)
    const data = {
      "customerId": 10,
      "productId": item.id,
      "productCount": 1,
      "price": item.id,
      "status": "NEW"
    };
    axios.post(`http://localhost:${port}/orders`, data)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    const fetchData = async () => {
      const url = `http://localhost:8083/users/10`;
      try {
        const response = await axios.get(url);
        setData(response.data);
        console.log(response.data)
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      const url = `http://localhost:8085/stock/`;
      try {
        const response = await axios.get(url);
        setStockData(response.data);
        console.log("get stock data: ", response.data)
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="container">
      <div className="row">
        <h1 style={{fontSize: '80px', textAlign: 'center', margin: '30px 0'}}>Distributed Shop</h1>
        <h1> Name: {data ? data.name : "loading"}</h1>
        <h1> Balance: {data ? data.amountAvailable :  "loading"}</h1>

        {stockData ? stockData.map((card) => (
          <div className="col-md-4" key={card.id}>
            <Card style={{ width: "18rem", margin: "30px 0"}}>
              <Card.Body>
                <Card.Title>{card.name}</Card.Title>
                <Card.Text>{card.description}</Card.Text>
                <Card.Text>Price: ${card.id}</Card.Text>
                <Card.Text>In stock: {card.availableItems}</Card.Text>
                <Button onClick={() => handleBuy(card)}>Buy</Button>
              </Card.Body>
            </Card>
          </div>
        )) : null}

      </div>
    </div>
  );
}

export default App;