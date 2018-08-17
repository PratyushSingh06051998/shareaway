var express = require("express");
var app = express();
var bodyParser = require('body-parser');
var FCM = require('fcm-node');
var serverKey = 'AAAAH-f5DHY:APA91bEyg1LQlDxCYYxK9t9UhKlLaJQe23S7KjmmEq8cCRCP5pfoNNPW7Pol3wcSvODY6X32aidiGDOigjIXCWNcDzAh5AyBjEN8NtVyndgNrlVJf5Q5iSwiTfONp9ZJrpSC4dblsq4nYPSPBXPbVQL2Y1CFQW8A4A';
var fcm = new FCM(serverKey);
var mysql = require('mysql');
var con = mysql.createPool({
 host: "localhost",
 user: "root",
 password: "root",
 database: "shareway"
});

var port = process.env.PORT || 3000;
app.use(bodyParser());


app.get("/login",function(req,res){

  var email = req.query.email;
  var pass = req.query.pass;

  var obj = {
    status : "SUCCESS"
  }

  console.log(email);
  console.log(pass);
  res.send(JSON.stringify(obj));

})


app.get("/signup",function(req,res){

  console.log("jhsdbhasdvbsdjj");

  var name = req.query.name;
  var email = req.query.email;
  var pass = req.query.pass;
  var pnum = req.query.pnum;
  var sex = req.query.sex;
  var fcm = req.query.fcm;
  console.log(name);
  console.log(email);

  var obj = {
    status : "SUCCESS"
  }

  var sql = "INSERT INTO user_master (um_name,um_email,um_password,um_sex,um_pnumber,um_fcm) VALUES ((?),(?),(?),(?),(?),(?))";

  con.getConnection(function(err,connection){
    if(err){
      obj.status = "FAIL";
      res.send(JSON.stringify(obj));
      console.log(err);
    }else{
      connection.query(sql,[name,email,pass,sex,pnum,fcm],function(err){
        if(err){
          obj.status = "FAIL";
          res.send(JSON.stringify(obj));
          console.log(err);
        }else{
          res.send(JSON.stringify(obj));
        }
      })

      connection.release();
    }

  })

})

app.listen(port,function(err1){
  console.log("Listening on the port 3000");
});
