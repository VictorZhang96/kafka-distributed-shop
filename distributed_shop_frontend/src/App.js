import React, { useState } from "react";
import axios from "axios";
import { Card, Button } from "react-bootstrap";

function App() {
  
  const items = [
    {
      id: 1,
      title: "Card 1",
      description: "This is the first card.",
      price: 10,
    },
    {
      id: 2,
      title: "Card 2",
      description: "This is the second card.",
      price: 20,
    },
  ]

  const handleBuy = (item) => {
    const data = {
      "customerId": 10,
      "productId": item.id,
      "productCount": 1,
      "price": item.price,
      "status": "NEW"
    };
    axios.post("http://localhost:8080/orders", data)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row">
        {items.map((card) => (
          <div className="col-md-4" key={card.id}>
            <Card style={{ width: "18rem" }}>
              <Card.Body>
                <Card.Title>{card.title}</Card.Title>
                <Card.Text>{card.description}</Card.Text>
                <Card.Text>Price: ${card.price}</Card.Text>
                <Button onClick={() => handleBuy(card)}>Buy</Button>
              </Card.Body>
            </Card>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;