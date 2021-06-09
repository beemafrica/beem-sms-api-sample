const axios = require("axios");
const https = require("https");
var btoa = require("btoa");

const username = "<api_key>";
const password = "<secret_key>";
const content_type = "application/json";

function check_balance() {
  axios
    .get("https://apisms.beem.africa/public/v1/vendors/balance", {
      headers: {
        "Content-Type": content_type,
        Authorization: "Basic " + btoa(username + ":" + password),
      },
      httpsAgent: new https.Agent({
        rejectUnauthorized: false,
      }),
    })
    .then((response) => console.log(response, username + ":" + password))
    .catch((error) => console.error(error));
}

check_balance();