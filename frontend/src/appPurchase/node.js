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
  app.locals.collection = client.db("usersdb").collection("users");
  app.listen(3000, function(){
    console.log("Сервер ожидает подключения...");
  });
});

app.get("/purchases", function(req, res){

  const collection = req.app.locals.collection;
  collection.find({}).toArray(function(err, users){

    if(err) return console.log(err);
    res.send(users)
  });

});
app.get("/purchase:id", function(req, res){

  const id = new objectId(req.params.id);
  const collection = req.app.locals.collection;
  collection.findOne({_id: id}, function(err, user){

    if(err) return console.log(err);
    res.send(user);
  });
});

app.post("/purchase", jsonParser, function (req, res) {

  if(!req.body) return res.sendStatus(400);

  const userName = req.body.name;
  const userEmail = req.body.email;
  const userPassword = req.body.password;
  const userWBKey = req.body.wbKey;
  const userOzonKey = req.body.ozonKey;
  const userIsSubscribe = req.body.isSubscribe;
  const userIsBlocked = req.body.isBlocked;
  const userRole = req.body.role;

  const user = {name: userName, email: userEmail, password: userPassword, wbKey: userWBKey,
                ozonKey: userOzonKey, isSubscribe: userIsSubscribe, isBlocked: userIsBlocked, role: userRole};

  const collection = req.app.locals.collection;
  collection.insertOne(user, function(err, result){

    if(err) return console.log(err);
    res.send(user);
  });
});

app.delete("/purchase", function(req, res){

  const id = new objectId(req.params.id);
  const collection = req.app.locals.collection;
  collection.findOneAndDelete({_id: id}, function(err, result){

    if(err) return console.log(err);
    let user = result.value;
    res.send(user);
  });
});

app.put("/purchase", jsonParser, function(req, res){

  if(!req.body) return res.sendStatus(400);
  const id = new objectId(req.body._id);
  const userName = req.body.name;
  const userEmail = req.body.email;
  const userPassword = req.body.password;
  const userWBKey = req.body.wbKey;
  const userOzonKey = req.body.ozonKey;
  const userIsSubscribe = req.body.isSubscribe;
  const userIsBlocked = req.body.isBlocked;
  const userRole = req.body.role;


  const collection = req.app.locals.collection;
  collection.findOneAndUpdate({_id: id}, { $set: {name: userName, email: userEmail, password: userPassword, wbKey: userWBKey,
        ozonKey: userOzonKey, isSubscribe: userIsSubscribe, isBlocked: userIsBlocked, role: userRole}},
    {returnOriginal: false },function(err, result){

      if(err) return console.log(err);
      const user = result.value;
      res.send(user);
    });
});


process.on("SIGINT", () => {
  dbClient.close();
  process.exit();
});
