const express = require("express");
const pgp = require("marketplace");
const objectId = require("marketplace").ObjectId;

const app = express();
const jsonParser = express.json();

const db = new pgp("//postgres://postgres:11111111@localhost:5432/marketplace");

let dbClient;


app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  res.header("Access-Control-Allow-Methods", "GET, PATCH, PUT, POST, DELETE, OPTIONS");
  next();
});

db.connect(function(err, client){
  if(err) return console.log(err);
  dbClient = client;
  app.locals.collection = client.db("marketplace").collection("purchase");
  app.listen(3000, function(){
    console.log("Сервер ожидает подключения...");
  });
});

app.get("/purchases", function(req, res){

  const collection = req.app.locals.collection;
  collection.find({}).toArray(function(err, purchases){

    if(err) return console.log(err);
    res.send(purchases)
  });

});
app.get("/purchase:id", function(req, res){

  const id = new objectId(req.params.id);
  const collection = req.app.locals.collection;
  collection.findOne({_id: id}, function(err, purchase){

    if(err) return console.log(err);
    res.send(purchase);
  });
});

app.post("/purchase", jsonParser, function (req, res) {

  if(!req.body) return res.sendStatus(400);

  const date = req.body.date;
  const productName = req.body.productName;
  const priceForOne = req.body.priceForOne;
  const amount = req.body.amount;
  const purchasePrice = req.body.purchase;
  const logistics = req.body.logistics;
  const costPrice = req.body.costPrice;
  const batchPrice = req.body.batchPrice;
  const extra = req.body.extra;

  const purchase = {date: date, productName: productName, priceForOne: priceForOne, amount: amount, purchasePrice: purchasePrice, logistics: logistics,
                    costPrice: costPrice, batchPrice: batchPrice, extra: extra};

  const collection = req.app.locals.collection;
  collection.insertOne(purchase, function(err, result){

    if(err) return console.log(err);
    res.send(purchase);
  });
});

app.delete("/purchase", function(req, res){

  const id = new objectId(req.params.id);
  const collection = req.app.locals.collection;
  collection.findOneAndDelete({_id: id}, function(err, result){

    if(err) return console.log(err);
    let purchase = result.value;
    res.send(purchase);
  });
});

app.put("/purchase", jsonParser, function(req, res){

  if(!req.body) return res.sendStatus(400);
  const id = new objectId(req.body._id);
  const date = req.body.date;
  const productName = req.body.productName;
  const priceForOne = req.body.priceForOne;
  const amount = req.body.amount;
  const purchasePrice = req.body.purchase;
  const logistics = req.body.logistics;
  const costPrice = req.body.costPrice;
  const batchPrice = req.body.batchPrice;
  const extra = req.body.extra;


  const collection = req.app.locals.collection;
  collection.findOneAndUpdate({_id: id}, { $set: {date: date, productName: productName, priceForOne: priceForOne, amount: amount, purchasePrice: purchasePrice, logistics: logistics,
        costPrice: costPrice, batchPrice: batchPrice, extra: extra}},
    {returnOriginal: false },function(err, result){

      if(err) return console.log(err);
      const purchase = result.value;
      res.send(purchase);
    });
});


process.on("SIGINT", () => {
  dbClient.close();
  process.exit();
});
