using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Security.Cryptography.Xml;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.VisualBasic;
//using Newtonsoft.Json;
using SMSAPI.Models;



namespace SMSAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SMSController : ControllerBase
    {
        private const string URL = "https://apisms.bongolive.africa/v1/send";
        private const string URL_Airtime = "https://apiairtime.bongolive.africa/v1/transfer";
        private readonly SMSAPIDBContext _context;

        public SMSController(SMSAPIDBContext context)
        {
            _context = context;
        }

        // POST api/SMS
        [HttpPost]
        public ActionResult Post([FromBody] SMSInput value)
        {

            string DATA = JsonSerializer.Serialize(value);
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(URL);
            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = DATA.Length;
            StreamWriter requestWriter = new StreamWriter(request.GetRequestStream(), System.Text.Encoding.ASCII);
            requestWriter.Write(DATA);
            requestWriter.Close();

            try
            {
                request.PreAuthenticate = true;
                String username = "";
                String password = "";
                String encoded = System.Convert.ToBase64String(System.Text.Encoding.GetEncoding("ISO-8859-1").GetBytes(username + ":" + password));
                request.Headers.Add("Authorization", "Basic " + encoded);

                WebResponse webResponse = request.GetResponse();
                Stream webStream = webResponse.GetResponseStream();
                StreamReader responseReader = new StreamReader(webStream);
                string response = responseReader.ReadToEnd();
                Console.Out.WriteLine(response);
                responseReader.Close();
                return Ok(response);
            }
            catch (Exception e)
            {
                Console.Out.WriteLine("-----------------");
                Console.Out.WriteLine(e.Message);
                return NotFound();
            }
        }

        // POST api/SMS
        [HttpPost]
        [Route("[action]")]
        public ActionResult TransferAirtime([FromBody] Airtime value)
        {
            string DATA = JsonSerializer.Serialize(value);
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(URL_Airtime);
            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = DATA.Length;
            StreamWriter requestWriter = new StreamWriter(request.GetRequestStream(), System.Text.Encoding.ASCII);
            requestWriter.Write(DATA);
            requestWriter.Close();

            try
            {
                request.PreAuthenticate = true;
                String username = "";
                String password = "";
                String encoded = System.Convert.ToBase64String(System.Text.Encoding.GetEncoding("ISO-8859-1").GetBytes(username + ":" + password));
                request.Headers.Add("Authorization", "Basic " + encoded);

                WebResponse webResponse = request.GetResponse();
                Stream webStream = webResponse.GetResponseStream();
                StreamReader responseReader = new StreamReader(webStream);
                string response = responseReader.ReadToEnd();
                Console.Out.WriteLine(response);
                responseReader.Close();
                return Ok(response);
            }
            catch (Exception e)
            {
                Console.Out.WriteLine("-----------------");
                Console.Out.WriteLine(e.Message);
                return NotFound();
            }
        }

        // POST: api/SMS/SMSCallback
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        [HttpPost]
        [Route("[action]")]
        public async Task<ActionResult<SMSCallback>> SMSCallback([Bind("request_id,recipient_id,dest_addr,Status")] SMSCallback smsCallback)
        {
            _context.smsCallback.Add(smsCallback);
            await _context.SaveChangesAsync();


            return new OkObjectResult(smsCallback);
        }
    }
}
