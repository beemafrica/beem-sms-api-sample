const https = require("https");

function send_sms() {
  axios.post(
    "https://dev-sms.bongolive.africa/api/v1/send",
    {
      source_addr: "INFO",
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
        "Content-Type": "application/json",
        Authorization:
          "Basic NWYwOTU4ZDM1ZDgwM2ZlYzpNamhsTUdGbFkyWXpObUk1TVRZd01qZzRZamhtWW1GbU5HSTJOakZsTnprMU16WXlaRFJsTTJOa09HWXdZamd3TlRZeU1HUm1aRFUwTldGa05qSTBOZz09",
      },
      httpsAgent: new https.Agent({
        rejectUnauthorized: false,
      }),
    }
  ).then(response=>console.log(response)).catch(error=>console.error(error.response.data))
}

send_sms();