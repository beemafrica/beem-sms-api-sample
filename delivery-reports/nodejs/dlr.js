const axios = require("axios");
const https = require("https");
const btoa = require("btoa");

const url = "https://apisms.beem.africa/public/v1/delivery-reports";
const api_key = "<API_KEY>";
const secret_key = "<SECRET_KEY>";
const content_type = "application/json";

let payload = {
  headers: {
    "Content-Type": content_type,
    Authorization: "Basic " + btoa(api_key + ":" + secret_key),
  },
  params: {
    dest_addr: "<dest_addr>",
    request_id: "<request_id>",
  },
};

function getDeliveryReports() {
  axios
    .get(url, payload, {
      httpsAgent: new https.Agent({
        rejectUnauthorized: false,
      }),
    })
    .then((resp) => console.log(resp.data))
    .catch((err) => console.log(err.message));
}

getDeliveryReports();
