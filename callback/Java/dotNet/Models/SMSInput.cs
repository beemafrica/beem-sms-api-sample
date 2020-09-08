using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SMSAPI.Models
{
    public class SMSInput
    {
        public string source_addr { get; set; }
        public int encoding { get; set; }
        public string message { get; set; }
        public List<Recipient> recipients { get; set; }

    }
    public class Recipient{
        public int recipient_id { get; set; }
        public string dest_addr { get; set; }

    }

    public class Airtime
    {
        public string dest_addr { get; set; }
        public int amount { get; set; }
    }
}
