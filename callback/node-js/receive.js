const express = require("express");
const app = express();
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.post("/", (req, res) => {
let { request_id, recipient_id, dest_addr, Status } = req.body;

res.json({
  request_id,
  Status,
  "successful": "true" 
  });
});

app.listen(3000, () => console.log("app running on port 3000")});