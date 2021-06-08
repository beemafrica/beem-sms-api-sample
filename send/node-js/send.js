const axios = require("axios");
const https = require("https");

const token =
  "Basic NWYwOTU4ZDM1ZDgwM2ZlYzpNamhsTUdGbFkyWXpObUk1TVRZd01qZzRZamhtWW1GbU5HSTJOakZsTnprMU16WXlaRFJsTTJOa09HWXdZamd3TlRZeU1HUm1aRFUwTldGa05qSTBOZz09";
const content_type = "application/json";
const source_addr = "INFO";
function send_sms() {
  axios
    .post(
      "https://apisms.beem.africa/v1/send",
      {
        source_addr: source_addr,
        schedule_time: "",
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
          Authorization: token,
        },
        httpsAgent: new https.Agent({
          rejectUnauthorized: false,
        }),
      }
    )
    .then((response) => console.log(response))
    .catch((error) => console.error(error.response.data));
}

send_sms();
