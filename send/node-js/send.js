const axios = require("axios");
const https = require("https");
var btoa = require("btoa");

const api_key = "<api_key>";
const secret_key = "<secret_key>";
const content_type = "application/json";
const source_addr ="<source_addr>";

function send_sms() {
  axios
    .post(
      "https://apisms.beem.africa/api/v1/send",
      {
        source_addr: source_addr,
        schedule_time: "",
        encoding: 0,
        message: "Hello World",
        recipients: [
          {
            recipient_id: 1,
            dest_addr: "255700000001",
          },
          {
            recipient_id: 2,
            dest_addr: "255700000002",
          },
        ],
      },
      {
        headers: {
          "Content-Type": content_type,
          Authorization: "Basic " + btoa(api_key + ":" + secret_key),
        },
        httpsAgent: new https.Agent({
          rejectUnauthorized: false,
        }),
      }
    )
    .then((response) => console.log(response, api_key + ":" + secret_key))
    .catch((error) => console.error(error.response.data));
}

send_sms();
