const bodyParser = require("body-parser");
const app = express();
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.post("/", (req, res) => {
let {
     request_id,
     recipient_id,
     dest_addr,
     Status 
    } = req.body;

     // sending response.

    res.json({
         request_id,
         Status,
        "successful": "true" 
            });

    });

app.listen(3000, () => console.log("app running on port 3000")});